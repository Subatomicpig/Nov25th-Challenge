//main class will be using java and drawing the grid instead of 
//writing it to the console



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import java.util.Scanner;



import javax.swing.*;


public class main extends JPanel{
	
	//draws the rectangles
	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		//g2d.setColor(Color.RED);	
		//g2d.fillRect(50, 0, 30, 30);
	}
	
	
	//get user input to determine how much to draw
	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		int boardSize;
		char positions[][] = null;
		boolean moving[][] = null;
		boolean done = false;
		
		//inits the board to the size entered
		boardSize = sc.nextInt();
		
		
		//init array to the size enetered
		positions = new char[boardSize][boardSize];
		moving = new boolean[boardSize][boardSize];
		
		//intits the positions on the board
		positions = initBoard(boardSize,positions,moving);
		printBoard(positions,boardSize);

		//moveSand(moving,positions,boardSize);
		//printBoard(positions,boardSize);
		
		JFrame frame = new JFrame("Nov 25th");
		
		
		
		//frame.add(new main());
		//frame.setSize(300, 300);
		//frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add code to draw graphics here 
		
		
	
	}
	
	//check for peice of sand
	//update position set previous position to blank
	public static void moveSand(boolean moving[][],char board[][],int size){
		
		boolean canMove = false;
		char temp = 'x';
		
		//loop through arrays
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				canMove = checkBelow(i,j,board,size);
				//check if we are in bounds
				if((i + 1) < size){
					//update the board
					if(canMove == true && board[i][j] != 'X'){
						board[i][j] = ' ';
						board[i + 1][j] = '.';
					}	
				}
			}
		}
	}
	
	
	//takes a position of sand and checks if something is below it
	public static boolean checkBelow(int x, int y,char board[][],int boardSize){
		boolean empty = true;
		
		if((x + 1) < boardSize){
			if(board[x + 1][y] == 'X'){
				empty = false;
			}
		}
		return empty;
	}
	
	
	//checks if a peice of the board is sand and sets its moving flag to true
	public static void startMoving(boolean moving[][],char board[][],int size){
		
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(board[i][j] == '.'){
					moving[i][j] = true;
				}
			}
		}
	}
	
	
	//checks if the sand is still falling by checking the boolean flag
	public static boolean stillMoving(boolean moving[][],int size){
		boolean stillMoving = false;
		
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(moving[i][j] == true){
					stillMoving = true;
				}
				else
					stillMoving = false;
			}
		}
		System.out.println(stillMoving);
		return stillMoving;
	}
	
	//sets up the board
	public static char[][] initBoard(int boardSize,char board[][],boolean moving[][]){
		
		Random rand = new Random();
		int ranX,ranY,numOfRocks = 0;
		int count = 0;
		
		numOfRocks = (int) (5 + (Math.random() * (10 - 5) + 1));
		System.out.println("Number of ROcks:" + numOfRocks);
		
		for(int i=0; i < boardSize; i++){
			for(int j=0; j < boardSize; j++){
				ranX = (int) (0 + (Math.random() * ((boardSize - 1) - 0) + 1));
				ranY = (int) (0 + (Math.random() * ((boardSize - 1) - 0) + 1));
				System.out.println("X:" + ranX + "Y:" + ranY);
				//tells if the peice is moving or not default false not moving
				moving[i][j] = false;
				if(i == 0){
					board[i][j] = '.';
				}
				//if we have the number of rocks we need
				if(count < numOfRocks){
					board[ranX][ranY] = 'X';
					count++;
					System.out.println("Count" + count);
				}
				else
					board[i][j] = ' ';
				
			}
		}
		
		
		return board;
	}
	
	//prints the board to console
	public static void printBoard(char board[][],int size){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(board[i][j]);
				if(j == size - 1){
					System.out.println();
				}
			}
		}
	}
	

}
