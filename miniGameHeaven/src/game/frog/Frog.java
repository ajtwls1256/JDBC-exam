package game.frog;

import java.util.ArrayList;
import java.util.Scanner;

public class Frog {
	
	Scanner sc = new Scanner(System.in);
	
	// 맵
	ArrayList<ArrayList<Integer>> map = new ArrayList<>();
	// 개구리
	Location frogLocation = new Location();
	// 오른쪽에서 오는 차
	ArrayList<Location> rightCars = new ArrayList<>();
	// 왼쪽에서 오는 차
	ArrayList<Location> leftCars = new ArrayList<>();
	
	
	boolean gameOver = false;
	
	// 개구리 진행 방향
	int direction = -1;
	
	// 움직인 횟수
	int count = 0;
	
	
	
	public Frog()
	{
		int sleepTime = 500;
		
		initGame();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();
		
		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();

		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();

		sleep(sleepTime);
		
		moveMap();
		
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		print();

		
	}
	
	public void initGame()
	{
		frogLocation.setRow(11);
		frogLocation.setCol(10);

		
		gameOver = false;
		direction = -1;
		count = 0;
		
		
		map.clear();
		
		int size = 11;
		
		for(int i =0; i< size; i++)
		{
			map.add(new ArrayList<Integer>());
			
			for(int j=0; j<size * 2 + 1; j++)
			{
				map.get(i).add(1);
			}
		}
		
//		System.out.println("Θ Ω θ δ"); 개구리 후보들

		
		rightCars.clear();
		leftCars.clear();
		
		// 차들 시작 위치 설정
		rightCars.add(new Location(1, 9));
		rightCars.add(new Location(3, 9));
		rightCars.add(new Location(5, 9));
		rightCars.add(new Location(7, 9));
		rightCars.add(new Location(8, 9));
		rightCars.add(new Location(9, 9));
		rightCars.add(new Location(11, 9));
		rightCars.add(new Location(12, 9));
		rightCars.add(new Location(14, 9));
		rightCars.add(new Location(17, 9));
		rightCars.add(new Location(19, 9));
		rightCars.add(new Location(20, 9));
		rightCars.add(new Location(22, 9));
		
		
		rightCars.add(new Location(1, 7));
		rightCars.add(new Location(2, 7));
		rightCars.add(new Location(3, 7));
		rightCars.add(new Location(6, 7));
		rightCars.add(new Location(7, 7));
		rightCars.add(new Location(8, 7));
		rightCars.add(new Location(10, 7));
		rightCars.add(new Location(11, 7));
		rightCars.add(new Location(12, 7));
		rightCars.add(new Location(15, 7));
		rightCars.add(new Location(17, 7));
		rightCars.add(new Location(19, 7));
		rightCars.add(new Location(20, 7));
		rightCars.add(new Location(22, 7));
		
		
		rightCars.add(new Location(1, 5));
		rightCars.add(new Location(4, 5));
		rightCars.add(new Location(5, 5));
		rightCars.add(new Location(8, 5));
		rightCars.add(new Location(10, 5));
		rightCars.add(new Location(12, 5));
		rightCars.add(new Location(14, 5));
		rightCars.add(new Location(15, 5));
		rightCars.add(new Location(16, 5));
		rightCars.add(new Location(21, 5));
		rightCars.add(new Location(23, 5));
		
		
		rightCars.add(new Location(2, 3));
		rightCars.add(new Location(3, 3));
		rightCars.add(new Location(4, 3));
		rightCars.add(new Location(6, 3));
		rightCars.add(new Location(8, 3));
		rightCars.add(new Location(9, 3));
		rightCars.add(new Location(12, 3));
		rightCars.add(new Location(13, 3));
		rightCars.add(new Location(15, 3));
		rightCars.add(new Location(19, 3));
		rightCars.add(new Location(21, 3));
		rightCars.add(new Location(23, 3));
		
		
		rightCars.add(new Location(1, 1));
		rightCars.add(new Location(2, 1));
		rightCars.add(new Location(5, 1));
		rightCars.add(new Location(6, 1));
		rightCars.add(new Location(7, 1));
		rightCars.add(new Location(9, 1));
		rightCars.add(new Location(11, 1));
		rightCars.add(new Location(13, 1));
		rightCars.add(new Location(14, 1));
		rightCars.add(new Location(17, 1));
		rightCars.add(new Location(19, 1));
		rightCars.add(new Location(22, 1));
		
		
		

		leftCars.add(new Location(1, 8));
		leftCars.add(new Location(2, 8));
		leftCars.add(new Location(3, 8));
		leftCars.add(new Location(4, 8));
		leftCars.add(new Location(7, 8));
		leftCars.add(new Location(9, 8));
		leftCars.add(new Location(11, 8));
		leftCars.add(new Location(13, 8));
		leftCars.add(new Location(14, 8));
		leftCars.add(new Location(17, 8));
		leftCars.add(new Location(20, 8));
		leftCars.add(new Location(22, 8));
		
	
		
		leftCars.add(new Location(1, 6));
		leftCars.add(new Location(3, 6));
		leftCars.add(new Location(5, 6));
		leftCars.add(new Location(8, 6));
		leftCars.add(new Location(9, 6));
		leftCars.add(new Location(12, 6));
		leftCars.add(new Location(14, 6));
		leftCars.add(new Location(16, 6));
		leftCars.add(new Location(18, 6));
		leftCars.add(new Location(19, 6));
		leftCars.add(new Location(20, 6));
		leftCars.add(new Location(22, 6));
		
		
		leftCars.add(new Location(4, 4));
		leftCars.add(new Location(8, 4));
		leftCars.add(new Location(9, 4));
		leftCars.add(new Location(11, 4));
		leftCars.add(new Location(13, 4));
		leftCars.add(new Location(14, 4));
		leftCars.add(new Location(16, 4));
		leftCars.add(new Location(19, 4));
		leftCars.add(new Location(21, 4));
		leftCars.add(new Location(22, 4));
	
		
		leftCars.add(new Location(1, 2));
		leftCars.add(new Location(2, 2));
		leftCars.add(new Location(5, 2));
		leftCars.add(new Location(6, 2));
		leftCars.add(new Location(9, 2));
		leftCars.add(new Location(11, 2));
		leftCars.add(new Location(13, 2));
		leftCars.add(new Location(14, 2));
		leftCars.add(new Location(16, 2));
		leftCars.add(new Location(17, 2));
		leftCars.add(new Location(19, 2));
		leftCars.add(new Location(21, 2));
	

	}
	
	
	public void main()
	{
		initGame();

		while(true)
		{
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			
			
			print();
			
			// 사망 시
			if(gameOver == true)
			{
				System.out.println("\n개구리가 화살을 맞아 사망했습니다 ㅠ");
				System.out.println("당신이 움직인 횟수는 : " + count);
				gameOver = false;
				return;
			}

			
			// 도착시
			if(frogLocation.getCol() == 0)
			{
				System.out.println("\n개구리가 무사히 도착했습니다!");
				System.out.println("당신이 움직인 횟수는 : " + count);
				return;
			}
			
			
			// 개구리 움직임
			System.out.println("\n1. 왼쪽 2. 오른쪽 3. 직진 0. 종료");
			System.out.print("선택 > ");
			direction = sc.nextInt();
			
			count++;
			
			switch(direction)
			{
				case 1: frogLocation.frogGoLeft();
					break;
				case 2: frogLocation.frogGoRigt(map.get(0).size());
					break;
				case 3: frogLocation.goStraight();
					break;
				case 0: System.out.println("GameOver");
					return;
			}
			
			
			
			
			moveMap();
			
		}
	}
	
	
	
	public boolean carsCheck(int i, int j)
	{
		
		// 차 체크
		boolean carCheck = false;
		
		for(int k=0; k<rightCars.size(); k++)
		{
			 if(i == rightCars.get(k).getCol() && j == rightCars.get(k).getRow())
			 {
				 carCheck = true;
				 
				 // 개구리가 차에 치일 때
				 if(i == frogLocation.getCol() && j == frogLocation.getRow())
				 {
					 System.out.print("X");
					 gameOver = true;
					 //System.out.println("여기?");
					 return carCheck;
				 }
				 else if(direction == 2 && i == frogLocation.getCol() && j == frogLocation.getRow() - 1)
				 {
					 System.out.print("X");
					 gameOver = true;
					 //System.out.println("아니면여기?");
					 return carCheck;
				 }
				 else
				 {
					 System.out.print("←");
					 //System.out.print("□");
					 continue;
				 }

			 }
		}
		
		
		for(int k=0; k<leftCars.size(); k++)
		{
			 if(i == leftCars.get(k).getCol() && j == leftCars.get(k).getRow())
			 {
				 carCheck = true;
				 
				// 개구리가 차에 치일 때
				 if(i == frogLocation.getCol() && j == frogLocation.getRow())
				 {
					 System.out.print("X");
					 gameOver = true;
					 return carCheck;
				 }
				 else if(direction == 1 && i == frogLocation.getCol() && j == frogLocation.getRow() + 1)
				 {
					 System.out.print("X");
					 gameOver = true;
					 return carCheck;
				 }
				 else
				 {
					 System.out.print("→");
					 //System.out.print("z");
					 continue;
				 }
			 }
		}
		
		return carCheck;
	}
	
	public void print()
	{
		for(int i =0; i<map.size() ; i++)
		{
			for(int j=0; j<map.get(i).size(); j++)
			{
				
				// 차 움직임
				boolean carCheck = carsCheck(i, j);
				
				// 개구리 출력
				if(gameOver == false && (i == frogLocation.getCol() && j == frogLocation.getRow()))
				{
					System.out.print("Ω"); 
					continue;
				}

				// 땅 출력
				if(carCheck == false)
				{
					if((i == 0 || i == map.size()-1) && j % 2 == 0)
						System.out.print("■");
					else if(i == 0 || i == map.size()-1)
						System.out.print(" ");
					else
						System.out.print(" ");
					
					continue;
				}
			}
			
			System.out.println();
		}
	}
	
	public void moveMap()
	{
		
		// 차 움직임
		for(int i =0; i<rightCars.size(); i++)
		{
			rightCars.get(i).goLeft();
			
			if(rightCars.get(i).getRow() < 0)
			{
				rightCars.get(i).setRow(map.get(0).size());
			}
		}
		
		for(int i =0; i<leftCars.size(); i++)
		{
			leftCars.get(i).goRight();
			
			if(leftCars.get(i).getRow() > map.get(0).size() - 1)
			{
				leftCars.get(i).setRow(-1);
			}
		}
	}
	
	public void sleep(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
