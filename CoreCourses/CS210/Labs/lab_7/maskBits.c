/**
 * SJ Guillaume
 * Honor Code
 * Take in three integers from user (a, begin, and end)
 * unsigned int a
 * begin and end should be int range 0 to 31
 * and should specify starting and ending bit positions in a
 * print out the integer formed by just the bits in positions begin through end of the integer a
 */
#include <stdio.h>

int main() {
    unsigned int a;
    unsigned int begin, end;
    printf("Enter an unsigned integer a: ");
    scanf("%u", &a);

    printf("Enter beginning and ending bit positions (between 0 and 31): ");
    scanf("%d %d",&begin, &end);

    unsigned int mask = 0xFFFFFFFF;
    unsigned int answer;
    mask = mask<<begin;
    mask = mask >> begin;
    mask = mask>>(31-end);
    mask = mask <<(31-end);
    answer = a & mask;
    answer = answer>>(31-end);
  /*  answer = (((((mask<<begin)>>begin)>>(31-end))<<(31-end)) &a)>>(31-end);
    answer = answer>>(31-end);*/

    /*printf for the answer */
    printf("Answer = %d \n", answer);


}
