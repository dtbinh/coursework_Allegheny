; Bob Roos
; First NASM example. This is equivalent to the C program:
;
;      #include <stdio.h>
;      int main() {
;         int i = 2015;
;         int j = 42;
;         printf("i=%d,j=%d,i+j=%d\n",i,j,i+j);
;      }
;
; To assemble, load, and run:
;
;      nasm -f elf nasm1.asm
;      gcc -m32 nasm1.o
;      ./a.out
;
; You can also name your executable file something other than a.out:
;

	extern	printf  ; We are going to use C's printf function

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.data   ; constants go here

i:	dd	2015	; dd = 32-bit word (like .word in MIPS)
j:	dd	42
fmt:	db	"i=%d,j=%d,i+j=%d",10,0 ; db is like MIPS .ascii, but
					;     NOTE: 10 = '\n', 0 = '\0'

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.text	; program goes here

	global	main	; we're following C program conventions
main:	
	push 	ebp	; always include these two steps...
	mov	ebp,esp ; ...right at the beginning

	mov	eax,[i]	; eax = contents of i (= 2015)
	mov	ebx,[j]	; ebx = contents of j (= 42)
	add	eax,ebx	; eax = eax + ebx

	; Get ready to print. We must push the arguments to the printf
	; function in reverse order:
	push	eax		; first, push i+j (LAST argument)
        push	dword	[j]	; ... then push j
	push	dword	[i]	; ... then push i
	push	dword	fmt	; ... then push format (FIRST argument)
	call	printf
	add	esp,16		; since we pushed four words, pop 16 bytes

	mov	esp,ebp	; always include these two steps...
	pop	ebp	; ...at the end

	ret		; return from the program
