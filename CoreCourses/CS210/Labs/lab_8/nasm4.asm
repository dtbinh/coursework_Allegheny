; Bob Roos
; Fourth NASM example. This is equivalent to the C program:
;
;      #include <stdio.h>
;      int main() {
;         int x = 3882;
;         int y = 99;
;         int z = x * y;
;         printf("x=%d,y=%d,z=%d\n",x,y,z);
;      }

;
; To assemble, load, and run:
;
;      nasm -f elf nasm4.asm
;      gcc -m32 nasm4.o
;      ./a.out
;
; You can also name your executable file something other than a.out:
;
;      nasm -f elf nasm4.asm
;      gcc -m32 nasm4.o -o nasm4
;      ./nasm4

	extern	printf  ; We are going to use C's printf function

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.data   ; constants go here

x:	dd	3882  ; dd = 32-bit word (like .word in MIPS)
y:	dd	99
fmt:	db	"x=%d,y=%d,z=%d",10,0 ; db is like MIPS .ascii, but

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section .bss	; variables go here
z:	resb	4	; reserve one word (4 bytes)


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.text	; program goes here

	global	main	; we're following C program conventions
main:	
	push 	ebp	; always include these two steps...
	mov	ebp,esp ; ...right at the beginning

	mov	eax,[x]	; eax = x 
	mov	ebx,[y]	; ebx = y 
	mul	ebx     ; eax = eax * ebx. NOTE: multiplicand always goes in eax
	mov	[z],eax	; z = eax (= x*y)

	; Get ready to print. We must push the arguments to the printf
	; function in reverse order:
	push	dword	[z]	; first, push z (LAST argument)
        push	dword	[y]	; ... then push y
	push	dword	[x]	; ... then push x
	push	dword	fmt	; ... then push format (FIRST argument)
	call	printf
	add	esp,16		; pop 4 arguments from stack

	mov	esp,ebp	; always include these two steps...
	pop	ebp	; ...at the end

	ret		; return from the program
