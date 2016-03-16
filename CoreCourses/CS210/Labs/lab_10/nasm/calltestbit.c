#include <stdio.h>

extern int testbit(int i, int b);

int main() {
   int n, b;
   printf("Integer to test? ");
   scanf("%d",&n);
   printf("Which bit (0-31)? ");
   scanf("%d",&b);
   printf("The %d bit of %d is %d\n",b,n,testbit(n,b));

   n = 57;
   printf("n = 57 (..0111001)\n");
   for (b = 0; b < 10; b++) {
      printf("The %d bit of %d is %d\n",b,n,testbit(n,b));
   }
}
