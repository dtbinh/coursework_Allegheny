/**
 * Robert Roos
 *    mathdemo.c -- demonstrates some functions in the math library,
 *      in particular, fabs, sqrt, sin, pow, floor, and ceil.
 *
 * To compile and run:
 *         gcc -lm  mathdemo.c  -o mathdemo
 *         ./mathdemo
 */

#include <stdio.h>
#include <math.h>

main() {
    double x; /* input value to be used for testing math functions */

    printf("Enter a number: ");
    scanf("%lf",&x);
    if (x < 0) {
        printf("%f is negative; using ",x);
        x = fabs(x);
        printf("%f instead\n",x);
    }
    printf("Square root of %f = %f\n",x,sqrt(x));
    printf("Sine of %f = %f\n",x,sin(x));
    printf("Cube root of %f = %f\n",x,pow(x,0.333333333));
    printf("Floor of %f = %f\n",x,floor(x));
    printf("Ceiling of %f = %f\n",x,ceil(x));
}
