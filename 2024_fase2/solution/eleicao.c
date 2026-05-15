#include <stdio.h>
#include <stdlib.h>

#define MAX(a,b) ((a) > (b) ? (a): (b))

int main(){
  int c, N;
  scanf("%d", &c);
  scanf("%d", &N);

  int stations[N][2];

  for(int i=0; i<N; i++){
    int aux, cost, people;
    scanf("%d %d %d", &aux, &cost, &people);
    stations[i][0] = cost;
    stations[i][1] = people;
  }

  int **matrix = malloc((N+1)*sizeof(int*));
  for(int i=0; i<=N; i++){
    matrix[i] = malloc((c+1)*sizeof(int));
    for(int j=0; j<=c; j++)
      matrix[i][j] = 0;
  }


  // knapsack problem
  for(int j=1; j<=c; j++){
    for(int i=1; i<=N; i++){
      int cost, people;
      cost = stations[i-1][0];
      people = stations[i-1][1];
      if(cost > j)
        matrix[i][j] = matrix[i-1][j];
      else{
        matrix[i][j] = MAX(
          matrix[i-1][j],
          people + matrix[i-1][j-cost]
        );
      }
    }
  }

  printf("%d\n", matrix[N][c]);

  for(int i=0; i<=N; i++)
    free(matrix[i]);
  free(matrix);
  return 0;
}
