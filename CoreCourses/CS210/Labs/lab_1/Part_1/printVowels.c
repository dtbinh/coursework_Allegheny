/**
 * SJ Guillaume
 * Sample program (based on K & R page 17):
 * print only the vowels in the input file
 * (not including \n, which is always copied).
 *
 * To compile and run this on a data file named "myfile.txt", type:
 *
 *      gcc even.c  -o even
 *      ./even  <  myfile.txt
 */
#include <stdio.h>
main() {
char c = getchar();
    while (c != EOF) {
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
            putchar(c); /* Don't count the newline! */
            c = getchar();
        }
        else if (c == '\n' ){
            putchar(c);
            c = getchar();
        }
        else {
            c=getchar();
        }
    }
}
