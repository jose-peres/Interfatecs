#include <stdio.h>

int main(){
  int V, N;
  scanf("%d %d", &V, &N);
  int target = 200-V;

  int freq[201];
  for(int i=0; i<=200; i++)
    freq[i] = 0;

  for(int i=0; i<N; i++){
    int aux;
    scanf("%d", &aux);
    freq[aux]++;
  }

  int found = 0;
  for(int i=30; i<=200; i++){
    for(int j=i; j<=200; j++){
      for(int k=j; k<=200; k++){
        if(freq[i] >= 1+(i==j)+(i==k) && freq[j] >= 1+(j==k) && freq[k] >= 1){
          if(i+j+k == target)
            found = 1;
        }
      }
    }
  }
  
  printf(found?"fretegratis\n":"fretepago\n");
  return 0;
}
