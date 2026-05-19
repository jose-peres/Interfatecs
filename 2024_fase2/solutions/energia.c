#include <stdio.h>
#include <stdlib.h>

int E, L;

int links[100][3];

int parent[31], rank[31];

int CompareLinks(const void *a, const void *b){
  const int *linkA = a;
  const int *linkB = b;
  return linkA[2] - linkB[2];
}

void Initialize(){
  for(int i=1; i<=E; i++){
    parent[i] = i;
    rank[i] = 0;
  }
}
int Find(int v){
  if(v != parent[v])
    parent[v] = Find(parent[v]);
  return parent[v];
}
void Union(int r, int s){
  if(rank[r] > rank[s])
    parent[s] = r;
  else{
    parent[r] = s;
    if(rank[r] == rank[s])
      rank[s]++;
  }
}

int main(){
  scanf("%d %d", &E, &L);

  for(int i=0; i<L; i++)
    scanf("%d %d %d", links[i], links[i]+1, links[i]+2);
  qsort(links, L, sizeof(links[0]), CompareLinks);

  Initialize();
  int total = 0;

  for(int i=0; i<L; i++){
    int u = links[i][0];
    int v = links[i][1];
    int cost = links[i][2];

    int r = Find(u);
    int s = Find(v);
    if(r != s){
      total += cost;
      Union(r, s);
    }
  }

  printf("%d\n", total);
  return 0;
}
