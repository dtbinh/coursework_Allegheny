/**
 * Bob Roos
 *
 * input.c:
 *   Demonstration of scanf. To compile and run:
 *
 *     gcc input.c  -o input
 *     ./input
 *
 * Things to try:
 *       999 3.14 27.9  [results in i=999  d=3.14  c='2'  f=7.9]
 *       9993.1427.9    [results in i=9993  d=.1427 c='.' f=9]
 *       1
 *       2
 *       3
 *       4              [results in i=1  d=2  c='3'  f=4]
 */
#include <stdio.h>
main() {
    int i;
    double d;
    char c;
    float f;

    printf("Enter an int, a double, a char, and a float: ");
    scanf("%d %lf %c %f",&i, &d, &c, &f);;
    printf("You entered: i = %d, d = %f, c ='%c', f = %f\n",i,d,c,f);
}
