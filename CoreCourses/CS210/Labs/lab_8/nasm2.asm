; Bob Roos
; Second NASM example. This is equivalent to the C program:
;
;      #include <stdio.h>
;      int main() {
;         int a = 2015;
;         int b = 42;
;         int c = -99;
;         int d = (a-b)+c;
;         d = d + 17;
;         printf("a=%d,b=%d,c=%d,d=%d\n",a,b,c,d);
;      }
;
; To assemble, load, and run:
;
;      nasm -f elf nasm2.asm
;      gcc -m32 nasm2.o
;      ./a.out
;
; You can also name your executable file something other than a.out:
;
;      nasm -f elf nasm2.asm
;      gcc -m32 nasm2.o -o nasm2
;      ./nasm2

	extern	printf  ; We are going to use C's printf function

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.data   ; constants go here

a:	dd	2015	; dd = 32-bit word (like .word in MIPS)
b:	dd	42
c:	dd	-99
fmt:	db	"a=%d,b=%d,c=%d,d=%d",10,0 ; db is like MIPS .ascii, but
					;     NOTE: 10 = '\n', 0 = '\0'

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section .bss	; variables go here
d:	resb	4	; reserve one word (4 bytes)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.text	; program goes here

	global	main	; we're following C program conventions
main:	
	push 	ebp	; always include these two steps...
	mov	ebp,esp ; ...right at the beginning

	mov	eax,[a]	; eax = contents of a (= 2015)
	sub	eax,[b]	; eax = eax - contents of b (eax = eax - 42)
	add	eax,[c]	; eax = eax + contents of c (eax = eax + (-99)
	add	eax,17	; eax = eax + 17
	mov	[d],eax	; d = eax (save eax in d)

	; Get ready to print. We must push the arguments to the printf
	; function in reverse order:
	push	dword	[d]	; first, push d (LAST argument)
        push	dword	[c]	; ... then push c
	push	dword	[b]	; ... then push b
	push	dword	[a]	; ... then push a
	push	dword	fmt	; ... then push format (FIRST argument)
	call	printf
	add	esp,20		; since we pushed five words, pop 20 bytes

	mov	esp,ebp	; always include these two steps...
	pop	ebp	; ...at the end

	ret		; return from the program
