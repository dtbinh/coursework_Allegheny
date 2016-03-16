#include <stdio.h>

extern void rot(int array[], int len);

void display(int a[], int n);

int main() {
  int a1[10] = {1,2,3,4,5,6,7,8,9,10};
  int a2[25]; /* We'll fill it with {1, 2, 3, ..., 25} */
  int i;
  for (i = 0; i < 25; i++) { a2[i] = i+1; }

  rot(a1,10);
  printf("After calling rot on array a1, a1 contains:\n");
  display(a1,10);

  rot(a2,25);
  rot(a2,25);
  rot(a2,25);
  printf("\n\nAfter calling rot three times on array a2, a2 contains:\n");
  display(a2,25);
  printf("\n");
}

void display(int a[], int n) {
  int i;
  for (i = 0; i < n; i++) {
    printf("%d ",a[i]);
  }
}
