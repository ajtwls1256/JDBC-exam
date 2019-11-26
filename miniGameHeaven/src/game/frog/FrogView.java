package game.frog;

import java.util.Scanner;

public class FrogView {
	Scanner sc = new Scanner(System.in);

	public void main()
	{
		
		Frog fg = new Frog();
		
		while (true) 
		{
			System.out.println("\n★ ★  개구리 길 건너기 ★ ★ ");
			System.out.println("1. 게임 시작");
			System.out.println("2. 랭킹");
			System.out.println("0. 종료");
			System.out.print("선택 > ");
			switch (sc.nextInt()) {
			case 1:
				
				fg.main();
				break;
			case 2:
				
				break;
			case 0:
				return;
			}
		}
	}
	
	
	
	
	
}
