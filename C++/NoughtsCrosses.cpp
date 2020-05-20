/*
    Project Title  : Noughts & Crosses
    Version        : 1.0
    Developed By   : Aditya Vikram Singh
*/

#include <iostream.h>
#include <conio.h>

int iswin( unsigned int []);

void main()
{
    clrscr();
    unsigned char A[9]={'1','2','3','4','5','6','7','8','9'};
    int moves=0, pos;
    for(int K=1; K<=9 && !iswin(A); K++)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
                cout<<A[3*i+j]<<" ";
            cout<<endl;
        }
        cout<<"Player "<<1+moves%2<<"'s Turn- Enter Position of choice: "; cin>>pos;
        if (moves%2) A[pos-1]='X';
        else A[pos-1]='O';
        moves++;
    }
    
    for(int i=0; i<3; i++)
    {
        for(int j=0; j<3; j++)
            cout<<A[3*i+j]<<" ";
        cout<<endl;
    }
    
    if (iswin(A)) cout<<"Player "<<iswin(A)<<" wins!!"<<endl;
    else cout<<"Game drawn!!"<<endl;
    getch();
}

int iswin( unsigned char A [] )
{
    for(int J=0; J<3;J++)
    {
        if       (A[J*3]==A[J*3+1] && A[J*3+1]==A[J*3+2]) return A[J*3+1]; // Rows
        else if  (A[J]==A[J+3] && A[J+3]==A[J+6]) return A[J+3] ; // Columns
        else if  (A[J]==A[4] && A[4]==A[8-J]) return A[4]; // Diagonals
    }
    return 0;
}
