package xoxOyunu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class xoxOyunu1 {
	
	static ArrayList<Integer> playerPositions= new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions= new ArrayList<Integer>();

	public static void main(String[] args) {
		
		char[][] gameBoard= {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
		};
	
		printGameBoard(gameBoard);
		
		
		
		while(true) {
			Scanner scan= new Scanner(System.in);
			System.out.print("hamlenizi yapiniz (1-9):");
	        int playerPos=scan.nextInt();
	        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
	        	System.out.println("DOGRU POZISYONLARI GIRIN");
	        	playerPos= scan.nextInt();
	        }
	        
			placePeace(gameBoard,playerPos,"player");
			
			String sonuc= kazananıBul();
			if(sonuc.length()>0) {
				 System.out.println(sonuc);
				 break;
				 
			 }
			Random rand= new Random();
			int cpuPos= rand.nextInt(9)+1;
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				 cpuPos= rand.nextInt(9)+1;
			}
			placePeace(gameBoard,cpuPos,"cpu");
			
			printGameBoard(gameBoard);
			
		 sonuc= kazananıBul();
		 if(sonuc.length()>0) {
			 System.out.println(sonuc);
			 break;
			 
		 }
		
		}
		
	}
	public static void printGameBoard(char[][] gameBoard) {
		
	    for(char[] row: gameBoard) {
	    	for(char c: row) {
	    		System.out.print(c);
	    	}
	    	System.out.println();
	    }
	    }
	    

	public static void placePeace(char[][] gameBoard, int pos, String user) {
		
		char sembol= ' ';
		if(user.equals("player")) {
			sembol='X';		
			playerPositions.add(pos);
		}else if(user.equals("cpu")) {
			sembol='O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
		case 1:
			gameBoard[0][0]=sembol;
			break;
		case 2:
			gameBoard[0][2]=sembol;
			break;
		case 3:
			gameBoard[0][4]=sembol;
			break;
		case 4:
			gameBoard[2][0]=sembol;
			break;
		case 5:
			gameBoard[2][2]=sembol;
			break;
		case 6:
			gameBoard[2][4]=sembol;
			break;
		case 7:
			gameBoard[4][0]=sembol;
			break;
		case 8:
			gameBoard[4][2]=sembol;
			break;
		case 9:
			gameBoard[4][4]=sembol;
			break;
			default:
			break;
		}
		
	}
	public static String kazananıBul() {
		
		List ustSira = Arrays.asList(1,2,3);
		List ortaSira = Arrays.asList(4,5,6);
		List altSira = Arrays.asList(7,8,9);
		List solSutun = Arrays.asList(1,4,7);
		List ortaSutun= Arrays.asList(2,5,8);
		List altSutun= Arrays.asList(3,6,9);
		List capraz1= Arrays.asList(1,5,9);
		List capraz2 = Arrays.asList(7,5,3);
				
		List<List> kazanan = new ArrayList<List>();
		kazanan.add(ustSira);
		kazanan.add(ortaSira);
		kazanan.add(altSira);
		kazanan.add(solSutun);
		kazanan.add(ortaSutun);
		kazanan.add(altSutun);
		kazanan.add(capraz1);
		kazanan.add(capraz2);
		
		for(List l: kazanan) {
			
			if (playerPositions.containsAll(l)) {
				return"TEBRIKLER KAZANDINIZ";
			}else if(cpuPositions.containsAll(l)) {
				return"cpu kazandi uzgunuz";  // burayla ilgilenicem
			}else if(playerPositions.size() + cpuPositions.size() == 9) {
				return"kazanan yok";
			}
	}
			
		
		
		return"";
	}
	

}
