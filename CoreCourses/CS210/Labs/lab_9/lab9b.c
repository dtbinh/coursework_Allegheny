/*
 *SJ and Cathal
 *Honor Code acknowledged
 * */

/**********  DON'T CHANGE ANY C CODE EXCEPT THE arrayCalc FUNCTION! *********/
#include <stdio.h>

/* Function prototype: */
void arrayCalc(int a[], int len);

int main() {
    int a1[] = {4,2,9,-1,6,3};
    int a2[] = {10,9,11,12,15,28,19};
    int a3[] = {2,3,5,8,0,19,1};
    int l1 = 6, l2 = 7, l3 = 7, i;
    arrayCalc(a1,l1);
    for (i = 0; i < l1; i++) { printf("%d ",a1[i]); }
    printf("\n");
    arrayCalc(a2,l2);
    for (i = 0; i < l2; i++) { printf("%d ",a2[i]); }
    printf("\n");
    arrayCalc(a3,l3);
    for (i = 0; i < l3; i++) { printf("%d ",a3[i]); }
    printf("\n");
}

/***********  CHANGE THE FOLLOWING FUNCTION ACCORDING TO THE PROBLEM ******/
void arrayCalc(int a[], int len) {
    int i;
    int temp, temp1;
    temp = a[0];
    temp1=0;
    for (i = 1; i < len; i++){
        if(i==len-1){
            a[0] = a[i] & a[0];
            a[i] = a[i] &a[i-1];
            a[i-1] = temp;
        }else{
            temp1 = a[i] & a[i-1];
            a[i-1] = temp;
            temp = temp1;
        }

    }
}

