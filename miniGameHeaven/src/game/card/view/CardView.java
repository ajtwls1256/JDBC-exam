package game.card.view;

import java.util.Random;
import java.util.Scanner;

public class CardView {
	public void main () {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int [][] card2d = new int [2][5];
		int [] card = new int[10];
		
		String [] cardStr = new String[10];
		String [][] card2dStr = new String[2][5];
		
		for(int i = 0; i<10; i++) {
			card[i] = r.nextInt(10)+1;
			for(int j = 0; j < i; j++) {
				if(card[i] == card[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i =0; i<5; i++) {
			card2d[0][i] = card[i];
		}
		
		for(int i =0; i<5; i++) {
			card2d[1][i] = card[i+5];
		}
		
	
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				System.out.print(card2d[i][j]+"\t");
			}
			System.out.println();
		}
		
		for(int i =0; i<10; i++) {
			if(card[i] == 1 || card[i] == 2) {
				cardStr[i] = "☆";
			}
			if(card[i] == 3 || card[i] == 4) {
				cardStr[i] = "♡";
			}
			if(card[i] == 5 || card[i] == 6) {
				cardStr[i] = "♣";
			}
			if(card[i] == 7 || card[i] == 8) {
				cardStr[i] = "■";
			}
			if(card[i] == 9 || card[i] == 10) {
				cardStr[i] = "☎";
			}
		}
		
		for(int i =0; i<5; i++) {
			card2dStr[0][i] = cardStr[i];
		}
		
		for(int i =0; i<5; i++) {
			card2dStr[1][i] = cardStr[i+5];
		}
	
		printUpper();
		printMiddle(card2dStr[0][0],card2dStr[0][1],card2dStr[0][2],card2dStr[0][3],card2dStr[0][4]);
		printLower();
		printUpper();
		printMiddle(card2dStr[1][0],card2dStr[1][1],card2dStr[1][2],card2dStr[1][3],card2dStr[1][4]);
		printLower();
		sleep(2000);
				
		for(int i =0; i<20; i++) {
			System.out.println();
		}
		
		System.out.println();
		printUpper();
		printMiddle(" ", " ", " ", " ", " ");
		printLower();
		
		printUpper();
		printMiddle(" ", " ", " ", " ", " ");
		printLower();
		
		String [] temp = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
		
		String [] tempStrArr = new String [10];
		for(int i = 0; i<10; i++) {
			tempStrArr[i] = " ";
		}
		
		int success = 0;
		int count = 0;
		
		int correctNum[] = new int[10];
		
		while(true) {
			boolean check = false; 
			count ++;
			System.out.println(count+"번째 시도중이십니다.");
			System.out.print("선택 > ");
			int sel1 = sc.nextInt();
			int sel2 = sc.nextInt();
			
			if(sel1 == sel2 ) {
				System.out.println("서로 다른 숫자를 입력해주세요.");
				count--;
				continue;
			}
			
			for(int i=0; i<10; i++) {
				if(correctNum[i] == sel1 || correctNum[i] == sel2) {
					System.out.println("이미 맞춘 카드가 포함되어 있습니다. 다른 숫자를 입력해주세요.");
					check = true;
					count--;
					break;
				}
			}
			
			if(check == true) {
				continue;
			}
			
			String sel1Str;
			String sel2Str;
			
			if(sel1 >= 6) {
				sel1Str = card2dStr[1][sel1-6];
				temp[sel1-1] = sel1Str;
				
			}else {
				sel1Str = card2dStr[0][sel1-1];
				temp[sel1-1] = sel1Str;
			}
			
			if(sel2 >= 6) {
				sel2Str = card2dStr[1][sel2-6];
				temp[sel2-1] = sel2Str;
			}else {
				sel2Str = card2dStr[0][sel2-1];
				temp[sel2-1] = sel2Str;
			}
			
			
			switch(sel1) {
			case 1:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 2:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 3:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 4:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 5:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 6:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 7:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 8:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 9:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			case 10:
				tempStrArr[sel1-1] = cardStr[sel1-1];
				break;
			}
			
			
			
			switch(sel2) {
			case 1:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 2:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 3:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 4:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 5:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 6:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 7:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 8:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 9:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			case 10:
				tempStrArr[sel2-1] = cardStr[sel2-1];
				break;
			}
			
			
			printUpper();
			printMiddle(tempStrArr[0], tempStrArr[1], tempStrArr[2], tempStrArr[3], tempStrArr[4]);
			printLower();
			printUpper();
			printMiddle(tempStrArr[5], tempStrArr[6], tempStrArr[7], tempStrArr[8], tempStrArr[9]);
			printLower();
			
			
			if(!(tempStrArr[sel1-1].equals(tempStrArr[sel2-1]))) {
				tempStrArr[sel1-1] = " ";
				tempStrArr[sel2-1] = " ";
				sleep(2000);
				
				for(int i = 0; i < 10; i++) {
					System.out.println();
				}
				printUpper();
				printMiddle(tempStrArr[0], tempStrArr[1], tempStrArr[2], tempStrArr[3], tempStrArr[4]);
				printLower();
				printUpper();
				printMiddle(tempStrArr[5], tempStrArr[6], tempStrArr[7], tempStrArr[8], tempStrArr[9]);
				printLower();
				
			} else {
				success++;
				correctNum[sel1-1] = sel1;
				correctNum[sel2-1] = sel2;
			}
			
			if(success == 5) {
				System.out.println("축하합니다 ^^*");
				System.out.println(count+"번 만에 맞추셨군요! ^^*");
				return;
			}
		}
	}
	
	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void printUpper() {
		System.out.printf("┌───┐┌───┐┌───┐┌───┐┌───┐");
		System.out.println();
	}
	
	public void printMiddle(String str1, String str2, String str3, String str4, String str5) {
		System.out.printf("│ %s ││ %s ││ %s ││ %s ││ %s │",str1, str2, str3, str4, str5);
		System.out.println();
	}
	
	public void printLower() {
		System.out.printf("└───┘└───┘└───┘└───┘└───┘");
		System.out.println();
	}
}