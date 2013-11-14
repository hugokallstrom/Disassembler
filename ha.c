#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(int argc, char *argv[]) {

	readFile();

	return 0;
}

int readFile(void) {

	static const char filename[] = "file.txt";
	FILE *file = fopen(filename, "r");

	if (file != NULL ) {
		char line[128];
		while (fgets(line, sizeof line, file) != NULL ) {
			fputs(line, stdout); /* write the line */
		}
		fclose(file);
	}
	else {
		perror(filename); /* why didn't the file open? */
		return -1;
	}

	return 1;
}
