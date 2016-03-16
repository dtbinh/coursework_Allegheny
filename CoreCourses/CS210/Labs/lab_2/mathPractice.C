/*SJ Guillaume
 *210
 *Lab 2 Part 5
 *Write a C program with two functions.
 *even() returns true for unsigned integers
 *agmean() takes two unsigned integers and returns a double value
 */
#include <stdio.h>
#include <math.h>
int even(unsigned int isEven);
double agmean(unsigned int i, unsigned int j);

main(){
    unsigned int a;
    printf("Enter an unsigned integer value: \n");
    scanf("%u", &a);
    unsigned int b = even(a);
    printf("The unsigned integer is: %d\n", b);


    unsigned int m, n;
    printf("Enter two unsigned integer vlaues: \n");
    scanf("%u %u", &m, &n);
    double answerMean = agmean(m, n);
    printf("The mean is: %f\n",answerMean);

}

int even(unsigned int num){
    unsigned int z = num;
    if (z%2 == 0){
        return 1;
    }
    else{
        return 0;
    }


}

double agmean(unsigned i,unsigned j){
    unsigned r = i;
    unsigned s = j;
    unsigned q = r + s;
    if(q%2 == 0){
        double mean = (r+s)/2;
        return mean;
    }
    else{
        double geomean = sqrt(r*s);
        return geomean;
    }
}




