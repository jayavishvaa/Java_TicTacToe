import java.util.*;

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> CPUPositions = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] gameBoard = {
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}
		};
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter your position:");
			
			int playerPos = sc.nextInt();
			
			while (playerPositions.contains(playerPos) || CPUPositions.contains(playerPositions))
			{
				System.out.println("Position already taken! choose available position");
				playerPos = sc.nextInt();
			}
			
			printPiece(gameBoard,playerPos,"Player");
			
			String result = checkWinner();
			
			if (result.length() > 0)
			{
				System.out.println(result);
				break;
			}
			
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			
			while (playerPositions.contains(cpuPos) || CPUPositions.contains(cpuPos))
			{
				cpuPos = rand.nextInt(9) + 1;
			}
			
			printPiece(gameBoard,cpuPos,"CPU");
			
			printGameBoard(gameBoard);
			
			result = checkWinner();
			
			if (result.length() > 0)
			{
				System.out.println(result);
				break;
			}
			
		}
		 
		
 
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		
		
		
		for(char[] row : gameBoard) {
			for(char c : row)
			{
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	public static void printPiece(char[][] gameBoard,int pos,String user) {
		
		char symbol = ' ';
		
		if (user.equals("Player"))
		{
			symbol = 'X';
			playerPositions.add(pos);
			
		}
		else if (user.equals("CPU")){
			symbol = 'O';
			CPUPositions.add(pos);
		}
		
		
		switch(pos) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = symbol;
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
		}
	}
	
	public static String checkWinner() {
		
		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(7, 5, 3); 
		
		List<List> winning = new ArrayList<List>();
		
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2); 
		
		for (List l : winning)
		{
			if (playerPositions.containsAll(l))
			{
				return "Congraturation u won!... :)";
			}
			else if (CPUPositions.containsAll(l))
			{
				return "CPU Wins :(";
			}
			else if (playerPositions.size() + CPUPositions.size() == 9)
			{
				return "Thats a Tie!!!!";
			}
		}
		
		return "";

	}

}
