/**
 * Bob Roos
 * chars.c:
 *     Simple string manipulation. Replace characters in a line.
 *     This also shows the perils of doing formatted character input--
 *     sometimes we have to skip over unwanted whitespace chars!
 *
 * To compile and run:
 *    gcc chars.c -o chars
 *    ./chars
 */

#include <stdio.h>

/* Function prototypes: */
int size(char *s);
int mygetchar();

main() {
    /* The line to be changed: */
    char line[] = "a liquid that was almost, but not quite, entirely unlike tea.";
    char old, new;  /* old = replaced, new = replaced by */
    int len; /* length of the string */
    int i; /* loop counter */
    char skip; /* needed to skip over a newline char */

    len = size(line);
    printf("Original string: %s\n",line);

    printf("What non-blank character would you like replaced? ");
    old = mygetchar();

    printf("What non-blank character would you like to replace it with? ");
    new = mygetchar();

    for (i = 0; i < len; i++) {
        if (line[i] == old) {
            line[i] = new;
        }
    }

    printf("Modified string: %s\n",line);
}

/**
 * size: returns the length of the string s
 */
int size(char *s) {
     int i = 0;
     while (s[i] != '\0') {
         ++i;
     }
     return i;
}

/**
 * mygetchar: returns the first non-whitespace character encountered
 * in the input (whitespace = space, tab, or newline)
 */
int mygetchar() {
     int c;
     c = getchar();
     while (c == ' ' || c == '\t' || c == '\n') {
         c = getchar();
     }
     return c;
}
