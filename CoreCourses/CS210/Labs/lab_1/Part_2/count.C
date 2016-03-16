/**
 * SJ Guillaume
 * Lab 1
 * CMPSC 210
 * This part of the assignment counts the number of vowels and the number of consonants.
 * The program then prints out the total counts of each from a text file.
 */
#include <stdio.h>
main(){
char c = getchar();
int vowelCount = 0;
int consonantCount =0;

    while ((c=getchar()) != EOF) {
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U') {
            vowelCount++;
        }
        else if ((c >= 'a'&& c<='z')|| (c >= 'A' && c<='Z')){
            consonantCount++;
        }
        else if (c == '\n' ){ }
        else if (c== ' ') { }
       // else{
       // consonantCount++;
      //  }
    }
    printf("Vowel Count: %d\nConsonant Count: %d\n", vowelCount, consonantCount);
}
