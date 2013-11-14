#include <stdio.h>
#include <stdlib.h>
#include <string.h>


void readFile(FILE *file);
int main(int argc, char *argv[]) {

	FILE *file;

    if (argc < 2) {
            printf("<No file entered>\n");
            exit(0);
    }


    /* Försöker öppna infilen */
    file = fopen(argv[1], "r");
    if (file == NULL) {
            fprintf(stderr, "<Could not open file> %s\n", argv[1]);
            exit(1);
    }
    /* Om filen som lästes in gick att öppna så
    anropas funktionen readFile */
    else {
            readFile(file);
    }
	fclose(file);


//	parseCodes();

	return 0;
}

void readFile(FILE *file) {

	char line[128];
	while (fgets(line, sizeof line, file) != NULL ) {
		fputs(line, stdout); /* write the line */
		/* If line == hex string
		 * put the hex in an array containing only
		 * hex strings */

		/* else if line == binary string
		 * put the string in an array containing only
		 * binary strings */

	}
}
