#include <stdio.h>

int main(){
    int N;
    scanf("%d", &N);

    int P[N+1];
    for(int i=1; i<=N; i++)
      scanf("%d", P+i);

    int maxHeap = 1, minHeap = 1;

    for(int i=N; i>1; i--){
      if(P[i] > P[i/2])
        maxHeap = 0;
      if(P[i] < P[i/2])
        minHeap = 0;
    }

    if(maxHeap && minHeap)
      printf("0\n");
    else if(maxHeap)
      printf("2\n");
    else if(minHeap)
      printf("1\n");
    else
      printf("0\n");
    return 0;
}
