#include <stdio.h>

int main(){
  int L, C, N, CL, CC;
  scanf("%d %d %d %d %d", &L, &C, &N, &CL, &CC);

  char s[1001];
  scanf("%s", s);

  int hor_diff = 0, ver_diff = 0;

  for(int i=0; i<N; i++){
    switch(s[i]){
      case 'C':
        ver_diff++;
        break;
      case 'D':
        hor_diff--;
        break;
      case 'B':
        ver_diff--;
        break;
      case 'E':
        hor_diff++;
        break;
    }
  }

  if(CC + hor_diff < 1
    || CC + hor_diff > C
    || CL + ver_diff < 1
    || CL + ver_diff > L
  )
    printf("-1 -1\n");
  else
    printf("%d %d\n", CL + ver_diff, CC + hor_diff);

  return 0;
}
