#include <stdio.h>
#include <string.h>

#define MIN(a, b) ((a < b)? a: b)

char complement(char c){
  switch(c){
    case 'A':
      return 'T';
    case 'T':
      return 'A';
    case 'C':
      return 'G';
    case 'G':
      return 'C';
  }
}

void solve(char s[]){
  size_t n = strlen(s);
  int radii[100001];
  for(int i=0; i<n; i++)
    radii[i] = 0;

  int left = 0;
  int right = -1;
  int best_start = -1;
  int best_len = 0;

  for(int center=0; center<n; center++){
    int radius = 0;
    if(center <= right){
      int mirror = left + right - center + 1;
      radius = MIN(radii[mirror], right-center+1);
    }

    while(center - radius - 1 >= 0
      && center + radius < n
      && s[center - radius - 1] == complement(s[center + radius])
    ){
      radius++;
    }

    radii[center] = radius;

    if(center + radius - 1 > right){
      left = center - radius;
      right = center + radius -1;
    }

    int length = 2*radius;
    if(length >= 4 && length > best_len){
      best_start = center - radius;
      best_len = length;
    }
  }

  if(best_len == 0)
    printf("false\n");
  else
    printf("%d %d\n", best_start+1, best_len);
}

int main(){
  char buff[100001];

  while(scanf("%s", buff) != EOF)
    solve(buff);

  return 0;
}
