#include <stdio.h>

int main(){
    int n, aux;
    scanf( "%d " , &n );

    for( int i=0 ; i<n ; i++ ){
        aux = getchar();
        while( aux <= 'Z' && aux >= 'A' ){
            if( aux >= 'A' && aux <= 'C' )
                printf( "2" );
            else if( aux >= 'D' && aux <= 'F' )
                printf( "3" );
            else if( aux >= 'G' && aux <= 'I' )
                printf( "4" );
            else if( aux >= 'J' && aux <= 'L' )
                printf( "5" );
            else if( aux >= 'M' && aux <= 'O' )
                printf( "6" );
            else if( aux >= 'P' && aux <= 'S' )
                printf( "7" );
            else if( aux >= 'T' && aux <= 'V' )
                printf( "8" );
            else
                printf( "9" );
            aux = getchar();
        }
        printf( "\n" );
    }
    return 0;
}
