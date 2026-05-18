#include <stdio.h>

int main(){
  int N;
  scanf("%d", &N);

  printf("%d%c\n", 1+(N-1)/9, 'A'+(N-1)%9);
  
  return 0;
}
