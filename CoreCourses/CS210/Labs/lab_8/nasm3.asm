; Bob Roos
; Third NASM example. This is equivalent to the C program:
;
;      #include <stdio.h>
;      int main() {
;         int p = 0x0000ABCD;
;         int q = 0x00009876;
;         int p_and_q = p & q;
;         int p_or_q = p | q;
;         printf("p=%d,q=%d,p&q=%d,p|q=%d\n",p,q,p_and_q,p_or_q);
;         printf("p=%08X,q=%08X,p&q=%08X,p|q=%08X\n",p,q,p_and_q,p_or_q);
;      }
;
; To assemble, load, and run:
;
;      nasm -f elf nasm3.asm
;      gcc -m32 nasm3.o
;      ./a.out
;
; You can also name your executable file something other than a.out:
;
;      nasm -f elf nasm3.asm
;      gcc -m32 nasm3.o -o nasm3
;      ./nasm3

	extern	printf  ; We are going to use C's printf function

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.data   ; constants go here

p:	dd	0x0000ABCD  ; dd = 32-bit word (like .word in MIPS)
q:	dd	0x00009876
fmt1:	db	"p=%d,q=%d,p&q=%d,p|q=%d",10,0 ; db is like MIPS .ascii, but
fmt2:	db	"p=%08X,q=%08X,p&q=%08X,p|q=%08X",10,0

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section .bss	; variables go here
p_and_q:resb	4	; reserve one word (4 bytes)
p_or_q:	resb	4	; reserve one word (4 bytes)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.text	; program goes here

	global	main	; we're following C program conventions
main:	
	push 	ebp	; always include these two steps...
	mov	ebp,esp ; ...right at the beginning

	mov	eax,[p]	; eax = p 
	and	eax,[q] ; eax = eax and q
	mov	[p_and_q],eax	; p_and_q = eax

	mov	eax,[p]	; eax = p 
	or	eax,[q] ; eax = eax or q
	mov	[p_or_q],eax	; p_or_q = eax

	; Get ready to print. We must push the arguments to the printf
	; function in reverse order:
	push	dword	[p_or_q]	; first, push p_and_q (LAST argument)
        push	dword	[p_and_q]	; ... then push p_or_q
	push	dword	[q]	; ... then push q
	push	dword	[p]	; ... then push p
	push	dword	fmt1	; ... then push format1 (FIRST argument)
	call	printf

	; We're going to call printf again, but the only thing that's
	; changing is the format, so we'll only pop one thing from the
	; stack and replace it with the new format. The other four
	; arguments to printf are still on the stack.

	add	esp,4		; pop fmt1
	push	dword	fmt2	; push fmt2
	call	printf		; print again, with new format
	add	esp,20		; pop 5 arguments from stack

	mov	esp,ebp	; always include these two steps...
	pop	ebp	; ...at the end

	ret		; return from the program
