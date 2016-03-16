; Bob Roos
; First NASM example. This is equivalent to the C program:
;
;      #include <stdio.h>
;      int main() {
;           int r = 119;
;           int s = -32;
;           int t = 7;
;           int u = (r-(s-t)) & (s+t-r);
;           printf("r =%d, s=%d, t=%d, u=%d\n", r,s,t,u")
;           }
;
; To execute:
;      nasm -f elf nasm1.asm
;      gcc -m32 nasm1.o -o nasm1
;      ./nasm1

	extern	printf  ; We are going to use C's printf function

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.data   ; constants go here

r:	dd	119	; dd = 32-bit word (like .word in MIPS)
s:  dd	-32
t:  dd  7

fmt:	db	"r=%d,s=%d,t=%d,u=%d",10,0 ; db is like MIPS .ascii, but
					;     NOTE: 10 = '\n', 0 = '\0'
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

		section .bss	; variables go here
u:	resb	4	; reserve one word (4 bytes)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	section	.text	; program goes here

	global	main	; we're following C program conventions
main:	
	push 	ebp	; always include these two steps...
	mov	ebp,esp ; ...right at the beginning

	mov	eax,[r]	; eax = contents of r (=119)
	mov	ebx,[s]	; ebx = contents of s (=-32)
	mov	ecx,[t]	; ecx = contents of t (=-7)
	sub	ebx,ecx ; ebx = ebx - ecx (s-t)
	sub	eax,ebx ; eax = eax - ebx (r-(s-t))
	mov	ebx, [s]; ebx = s
	add	ebx,[t] ; ebx = ebx + t (s+t)
	sub	ebx,[r] ; ebx = ebx + r (s+t+r)
	;logical and part
	and	eax,ebx ; logical and of expressions shown in header comments
	mov	[u],eax;; move copy eax into memory location u

	; Get ready to print. We must push the arguments to the printf
	; function in reverse order:
	push	dword	[u]     ;push LAST onto stack
	push	dword	[t]
	push	dword	[s]
	push	dword	[r]     ;push FIRST onto stack
    push	dword	fmt     ;push format onto stack
	
	call	printf
	add	esp,20		; since we pushed five words, pop 20 bytes

	mov	esp,ebp	; always include these two steps...
	pop	ebp	; ...at the end

	ret		; return from the program
