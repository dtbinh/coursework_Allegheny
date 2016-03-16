/**
 *  * Bob Roos
 *   * Sample program (based on K & R page 17):
 *    * Copy a file, printing only every other character
 *     * (not including \n, which is always copied).
 *      *
 *       * To compile and run this on a data file named "myfile.txt", type:
 *        *
 *         *      gcc even.c  -o even
 *          *      ./even  <  myfile.txt
 *           */
#include <stdio.h>
main() {
        int c, count = 0;
            while ((c=getchar()) != EOF) {
                        if (c == '\n') {
                                        putchar(c); /* Don't count the newline! */
                                                }
                                else if (count%2 == 0) { /* Print and count */
                                            putchar(c);
                                            count++;
                                        }
                                        else { /* Don't print, but count */
                                                    count++;
                                                }
                                            }
}
                        }
            }
}
