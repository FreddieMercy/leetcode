#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#define MAX_LEN 100
int main()
{
	int ch;
	int d;
	char s[MAX_LEN];
	char sen[MAX_LEN];

	scanf("%d%d", &ch, &d);
	scanf("%s%*c", &s); //discard last char, which is "\n"
						//scanf("\n");
	scanf("%[^\n]", &sen);

	printf("%d\n%d\n\n%s\n%s\n", ch,d, s, sen);
	return 0;
}