; Bob Roos
; C-callable function to rotate an array a of length n by 1 place to the left.
;
; The equivalent program in C would look like:
;
;    void rot(int a[], int n) {
;      int temp,i;
;      temp = a[0];
;      for (i = 1; i < n; i++) {
;        a[i-1] = a[i];
;      }
;      a[n-1] = temp;
;    }
;
; C will push the arguments onto the stack; the return value goes in
; register eax.

global  rot 

rot: 
        push    ebp       ; ALWAYS START WITH THESE TWO LINES!
        mov     ebp,esp   ; ALWAYS START WITH THESE TWO LINES!

        mov     eax,[ebp+8]    ; first parameter a is 8 bytes from ebp
        mov     ebx,[ebp+12]   ; second parameter n is 12 bytes from ebp
        mov 	ecx,[eax]      ; eax contains address of a[0]
                               ; so ecx is the "temp" that holds a[0]
        mov     edx,ebx        ; edx will be our loop counter
        dec     edx            ; edx = n-1

loop:   jz      done           ; if edx is 0, we're done
      ; In the following comments, i = (n - edx)
        mov	esi,[eax+4]  ; a[i] = a[i+1]
        mov     [eax],esi

        add     eax,4
        sub     edx,1
        jmp     loop
done:   mov     [eax],ecx

        mov esp,ebp       ; ALWAYS END WITH THESE THREE LINES!
        pop ebp           ; ALWAYS END WITH THESE THREE LINES!
        ret               ; ALWAYS END WITH THESE THREE LINES!

