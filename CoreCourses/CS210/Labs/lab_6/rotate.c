/**
 * SJ Guillaume
 * Lab 6, part 1
 * Due October 19, 2015
 * I hereby recognize and pledge to fulfill my responsibilities, as defined in the Honor Code, and to maintain the integrity of both myself and the College community as a whole.
 */
#include <stdio.h>

/* Function prototypes: */
void aprint(int a[], int n);
void rotl(int a[], int n);

int main() {
  /* Three arrays to be rotated: */
  int a1[] = {10,20,30,40};
  int a2[] = {3};
  int a3[] = {11,12,13,14,15,16,17,18,19};

  /* Array a1: */
  printf("Unrotated array: ");
  aprint(a1,4);
  rotl(a1,4);
  printf("Rotated array: ");
  aprint(a1,4);
  rotl(a1,4);

  /* Array a2: */
  printf("Unrotated array: ");
  aprint(a2,1);
  rotl(a2,1);
  printf("Rotated array: ");
  aprint(a2,1);
  rotl(a2,1);

  /* Array a3: */
  printf("Unrotated array: ");
  aprint(a3,9);
  rotl(a3,9);
  printf("Rotated array: ");
  aprint(a3,9);
  rotl(a3,9);
}

/**
 * aprint(a,n): prints the elements of array a (of size n)
 *   on a single line, separated by blanks and terminating
 *   with a newline.
 */
void aprint(int a[], int n) {
  int i;

  for (i = 0; i < n; i++) {
    printf("%d ",a[i]);
  }
  printf("\n");
}

/**
 * rotl rotates the contents of an array one place to the left
 */
void rotl(int a[], int n) { /*a[] is the array, n is the size of array*/
    int b[10];
    b[0] = a[0];    /*saves first index of a to array b*/
    int g = 0;      /* g and i are counters*/
    int i = 1;
    while (i < n){  /*while i is less than size*/
        a[g] = a[i];/*make the index hold the value of the next index*/
        i++;        /*increment i and g*/
        g++;
    }
    a[g]= b[0];     /*set last index of a to the original first, held in temp b*/
}
