/**
 * Bob Roos
 *
 * Using bit patterns as masks. This program takes four characters
 * and, using shift operators, stores them in the four bytes of an
 * unsigned int.
 *
 * Then it uses "masks" and shift operators to extract each of the bytes 
 * and print them back out as characters.
 */
#include <stdio.h>

int main() {
  int mask1 = 0xFF000000; /* captures the leftmost byte in a word */
  int mask2 = 0x00FF0000; /* captures the second byte in a word */
  int mask3 = 0x0000FF00; /* captures the third byte in a word */
  int mask4 = 0x000000FF; /* captures the rightmost byte in a word */
  char c0,c1,c2,c3; /* character values stored in the space of an int */
  int d0,d1,d2,d3; /* character values recovered from a int */
  unsigned s;

  c0 = 'A';
  c1 = 'B';
  c2 = 'C';
  c3 = 'D';

  /******* ENCODE THE CHARS AS AN INT ****************/

  /* The << operator is the left shift operator. (Like "sll" in MIPS.) */
  s = (c0<<24) + (c1<<16) + (c2<<8) + c3; /* Store 4 chars in an int */
  /* You could also write:
     s = (((((c0<<8) + c1)<<8) + c2)<<8) + c3;
  */
   
  /* The ">>" operator is the "shift right" operator. 
     For int values it is like "sra" in MIPS; for unsigned int values
     it is like "srl" in MIPS.
  */

  /******* DECODE THE CHARS ****************/

  d0 = (s & mask1) >> 24; /* leftmost 8 bits = first byte */
  d1 = (s & mask2) >> 16; /* next byte */
  d2 = (s & mask3) >> 8;  /* next byte */
  d3 = (s & mask4);       /* rightmost 8 bits = last byte */
  printf("s = %c%c%c%c\n",d0,d1,d2,d3);

}
