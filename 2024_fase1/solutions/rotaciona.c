#include <stdio.h>
#include <math.h>
double M[2];

int main(){
    int N, theta;
    double t;
    scanf( "%d %d", &N , &theta);
    int x ,y;

    t = 3.1415*theta/180;
    M[0] = cos(t);
    M[1] = -sin(t);
    for( int i=0 ; i<N ; i++ ){
        scanf( "%d %d" , &x , &y );
        printf( "%.2lf %.2lf\n" , M[0]*x + M[1]*y , -M[1]*x + M[0]*y );
    }

    return 0;
}
