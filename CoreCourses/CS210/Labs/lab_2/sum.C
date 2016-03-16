/* SJ Guillaume
 * 210
 * Lab 2 Part 3
 * write a function that takes two int parameters and returns a double value equal to their arithmetic mean
 * modeled off pate 26 of C book
 */

#include <stdio.h>


double sum(int i, int j);

main(){
    int a, b;
    printf("Enter two integer values for which you would like to calculate the mean: \n");
    scanf("%d %d", &a, &b);

    double c = sum(a, b);
    printf("The mean of %d and %d is: %.2f\n", a, b, c);
}

double sum(int i, int j){
    int y = i;
    int z = j;
    double d = (i+j)/2;
    return d;
}
