#include <stdio.h>
#include <unistd.h>

//打印进度条
int main(int argc,char *argv[])
{
		int count = 0;
		char default_char = '-';
		char bar[101] = {default_char};
		for (int i = 0;i < 100; i++){
				bar[i] = default_char;
		}
		bar[100] = '\0';
		char *lab = "-\\|/";

		while(count <= 100){
				printf("[%-100s][%d%%][%c]\r",bar,count,lab[count % 4]);	
				fflush(stdout);
				sleep(1);
				bar[count++] = '#';
				
		}
		printf("\n");
		return 0;
}
