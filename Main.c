#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {

	readFile();
	parseCodes();

	return 0;
}

Array readFile(void) {

	static const char filename[] = "file.txt";
	FILE *file = fopen(filename, "r");

	if (file != NULL ) {
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
		fclose(file);
	}
	else {
		perror(filename); /* why didn't the file open? */
	}

	return ;
}
