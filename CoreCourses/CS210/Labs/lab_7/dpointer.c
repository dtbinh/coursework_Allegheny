/**
 * Bob Roos
 * Demo program for lab 7: pointers and arrays.
 *
 * See K&R, chapter 5.
 *
 * This program shows use of pointer variables to access
 * elements of an array.
 */

#include <stdio.h>
#define SIZE 12
int main() {
   double a[SIZE] = {5,3,6,7,2,1,9,8,10,4,11,0};
   double *b, *c;
   int i,temp;

   /* Ordinary array indexing: this you should already know how to do! */
   for (i = 0; i < SIZE; i++) {
     printf("%G ",a[i]);
   }
   printf("\n");

   /* Using a pointer to advance through the array. We start with
      b pointing to a, then we add 4 to b each time through the loop:
   */
   b = a;
   for (i = 0; i < SIZE; i++) {
     printf("%G ",*(b++)); /* "b++" will add 4 since b points to int */
   }
   printf("\n");

   /* Changing the base of the array. Here, we set the pointer to
      the END of array a, but we offset all of our indices by -11 to
      compensate. Note that "c[1]", "c[2]", etc. are all illegal
      locations under this scheme.
   */
   c = a+SIZE-1; /* c now points to the LAST element in a */
   for (i = -(SIZE-1); i <= 0;  i++) { /* Indices are c[-11], c[-10], ..., c[0] */
     printf("%G ",c[i]);
   }
   printf("\n");

   /* Reverse elements in an array: */
   b = a;
   c = a+SIZE-1;
   for (i = 0; i < SIZE/2; i++) {
     temp = *b;
     *(b++) = *c;
     *(c--) = temp;
   }

   for (i = 0; i < SIZE; i++) {
     printf("%G ",a[i]);
   }
   printf("\n");
}
