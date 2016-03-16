/*SJ Guillaume
 * Honor Code Pledge: yes
 *210
 *Lab 2 Part 6
 *manipulate character strings: takes one word and inserts the next inside the first letter, then prints
 *a third word inside the first letter of the second word and continues printing.
 */
#include <stdio.h>

int size1(char *s);
int size2(char *s);
int size3(char *s);


main(){
    char string1[] = "Interesting";
    char string2[] = "String";
    char string3[] = "Manipulationzzzz";

    int a = size1(string1);
    int b = size2(string2);
    int c = size3(string3);

    int d = 0;
    int e = 0;
    int f = 0;

    char string[40];

    while(d < a){
        putchar(string1[d]);
        d++;
        while(e<b){
            putchar(string2[e]);
            e++;
            while(f<c){
                putchar(string3[f]);
                f++;
            }
        }
    }
    printf("\n");
}

int size1(char *s){
     int i = 0;
     while (s[i] != '\0') {
         ++i;
     }
     return i;
}

int size2(char *s){
     int k = 0;
     while (s[k] != '\0') {
         ++k;
     }
     return k;
}

int size3(char *s){
     int j = 0;
     while (s[j] != '\0') {
         ++j;
     }
     return j;
}




