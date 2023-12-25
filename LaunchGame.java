import java.util.Scanner;
import java.util.Random;
class TicTacToe
{
static char[][] board;
public TicTacToe()
{
board=new char[3][3];
initBoard();
}
void initBoard()
{
for(int i=0;i<board.length;i++)
{
for(int j=0;j<board[i].length;j++)
{
board[i][j]=' ';
}
}
}
static void dispBoard()
{
System.out.println("-------------");
for(int i=0;i<board.length;i++)
{
System.out.print("| ");
for(int j=0;j<board[i].length;j++)
{
System.out.print(board[i][j]+" | ");
}
System.out.println();
System.out.println("-------------");
}
}


static void placemark(int row,int column,char mark)
{
//board[row][column]=mark;
if(row>=0 && row<=2 && column>=0 && column<=2)
{
board[row][column]=mark;
}
else{
System.out.println("Invalid input");
}
} 
static boolean checkcolwin()
{
for(int j=0;j<=2;j++)
{
if(board[0][j]!=' ' && board[0][j]==board[1][j] && board[1][j] ==board[2][j])
{ 
return true;
}
}
return false;
}
static boolean checkrowwin(){
for(int i=0;i<=2;i++)
{
if(board[i][0]!=' ' && board[i][0]==board[i][1]&&board[i][1]==board[i][2])
{
return true;
}

}
return false;
}
static boolean checkdiagonalwin()
{
if(board[0][0]!=' ' && board[0][0]==board[1][1]&&board[1][1]==board[2][2]||board[0][2]!=' '&& board[0][2]==board[1][1]&&board[1][1]==board[2][0])
return true;
else
return false;
}
}

abstract class Player{
String name;
char mark;
 abstract void makeMove();
boolean isValidMove(int row,int column)
{
if(row >=0&& row<=2 &&column>=0&& column<=2)
{
if(TicTacToe.board[row][column]==' '){
return true;}

return false;
}
return false;
}
}

class HumanPlayer extends Player{

HumanPlayer(String name,char mark)
{
this.name=name;
this.mark=mark;
}
void makeMove()
{
 Scanner scan=new Scanner(System.in);
int row;
int column;

do{
System.out.println("Enter the row and Column");
 row=scan.nextInt();
column=scan.nextInt();
}while(!isValidMove(row,column));
TicTacToe.placemark(row,column,mark);
}
}

class AIPlayer extends Player {

AIPlayer(String name,char mark)
{
this.name=name;
this.mark=mark;
}
void makeMove()
{
 Scanner scan=new Scanner(System.in);
int row;
int column;
/*System.out.println("Enter the row and col");
 row=scan.nextInt();
 column=scan.netInt();*/
do{
Random r=new Random();
row=r.nextInt(3);
column=r.nextInt(3);
}while(!isValidMove(row,column));
TicTacToe.placemark(row,column,mark);
}
}

public class LaunchGame {
public static void main(String[] args)
{
TicTacToe t=new TicTacToe();
//t.dispBoard();
/*t.placemark(0,0,'x');
t.placemark(1,1,'x');
t.placemark(2,2,'x');*/
/*t.placemark(1,1,'o');
t.placemark(0,2,'x');
t.placemark(2,1,'o');*/
//t.dispBoard();
//System.out.println(t.checkdiagonalwin());
//System.out.println(t.checkrowwin());
//System.out.println(t.checkcolwin());
HumanPlayer p1=new HumanPlayer("Sikha",'x');
AIPlayer p2=new AIPlayer("Sweety",'o');
Player cp;
cp=p1;

while(true)
{
//cp=p1;
System.out.println(cp.name+" \tturn ");
cp.makeMove();
TicTacToe.dispBoard();
if(TicTacToe.checkcolwin()||TicTacToe.checkrowwin()||TicTacToe.checkdiagonalwin())
{
System.out.println(cp.name+" has Win");
break;
}
else
{
if(cp==p1)
{
cp=p2;
}
else
{
cp=p1;
}
}
}

 }
}


