; Bob Roos
; C-callable function to test a specifed bit b of a given integer i.
;
; The equivalent program in C would look like:
;
;    int testbit(int i, int b) {
;      int temp = 1 << b; /* "1", shifted left by b bits */
;      return (i & temp) != 0 ;   /* "1" if 1 in bit b of i, "0" otherwise */
;    }
;
; C will push the arguments onto the stack; the return value goes in
; register eax.

global  testbit 

testbit: 
        push    ebp       ; ALWAYS START WITH THESE TWO LINES!
        mov     ebp,esp   ; ALWAYS START WITH THESE TWO LINES!

        mov     ebx,[ebp+8]     ; first parameter i is 8 bytes from ebp
        mov     cl,[ebp+12]     ; second parameter b is 12 bytes from ebp
; NOTE: cl is a special register used to hold the "shift amount"

        mov     eax,1           ; eax = 1
        shl     eax,cl          ; shift eax left by amount in cl
        and     eax,ebx         ; eax = bitwise "and" of eax and i
        jz      done            ; if result was zero, we're done
        mov     eax,1           ; otherwise, put a "1" in eax
done:
        mov esp,ebp       ; ALWAYS END WITH THESE THREE LINES!
        pop ebp           ; ALWAYS END WITH THESE THREE LINES!
        ret               ; ALWAYS END WITH THESE THREE LINES!

