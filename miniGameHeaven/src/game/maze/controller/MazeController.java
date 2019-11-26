package game.maze.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import game.main.view.MainView;


public class MazeController {
	int[] localpoint = new int[2];
	int[] endpoint = new int[2];
	boolean crash = false;
	boolean escape = false;
	
	Scanner sc = new Scanner(System.in);
	MainView mv = new MainView();

	public MazeController() {

	}

	public long gameStart(int sel) {
		// 3. 어려움 20x20 / 2. 중급 15x15 / 1. 초급 10x10
		BufferedReader br = null;
		int [] initPos = new int[2];
		escape = false;
		int x;
		if (sel == 1) {
			x = 10;
		} else if (sel == 2) {
			x = 15;
		} else if (sel == 3) {
			x = 20;
		} else {
			System.out.println("뷁");
			return -1;
		}
		
		int[][] maze = new int[x][x];
		
		try {
			FileReader fr = new FileReader("C:\\Users\\user1\\Desktop\\미로" + sel + ".txt");
			br = new BufferedReader(fr);
			// 처음 4줄은 시작위치, 종료위치
			localpoint[0] = Integer.parseInt(br.readLine())-1;
			initPos[0] = localpoint[0];
			localpoint[1] = Integer.parseInt(br.readLine())-1;
			initPos[1] = localpoint[1];
			endpoint[0] = Integer.parseInt(br.readLine())-1;
			endpoint[1] = Integer.parseInt(br.readLine())-1;
			for (int i = 0; i < x; i++) {
				String linetxt = br.readLine(); // 한 줄을 읽어옴
				if (linetxt == null) {
					break;
				}
				for (int j = 0; j < x; j++) {
					maze[i][j] = linetxt.charAt(j)-48;
				}
			}
		} catch (FileNotFoundException e) {

		} catch (IOException e) {
			e.printStackTrace();
		}
		long timerStart = System.currentTimeMillis(); //시스템시간

		while (true) {
			// 출력
			for(int i=0;i<50;i++) {
				System.out.println();
			}
			printMaze(x, maze);
			// 움직일 때
			if (!movePoint(sc.nextInt(),maze)) {
				if(crash) {
					printCrash(x, maze);
					crash = false;
					localpoint[0] = initPos[0];
					localpoint[1] = initPos[1];
				}
				if(escape) {
					for(int i=0;i<50;i++) {
						System.out.println();
					}
					printMaze(x, maze);
					mv.print("");
					mv.print("★ ☆ ★ 탈 출 ★ ☆ ★");
					break;
				}
			}
		}

		long timerEnd = System.currentTimeMillis(); //시스템시간
		long timeCost = timerEnd - timerStart;
		
		mv.print(timeCost/1000 +"."+ (timeCost%1000)/10 + "초!!");
		
		return timeCost;
	}

	public void printMaze(int x, int[][] maze) {
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				if (localpoint[0] == i && localpoint[1] == j) {
					System.out.print("○");
				} else if (maze[i][j] == 1) {
					System.out.print("■");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
		}
	}
	
	public void printCrash(int x, int[][] maze) {
		for(int i=0;i<50;i++) {
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				if (localpoint[0] == i && localpoint[1] == j) {
					System.out.print("☆");
				} else if (maze[i][j] == 1) {
					System.out.print("■");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
		}
		sleep(500);
		for(int i=0;i<50;i++) {
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				if (localpoint[0] == i && localpoint[1] == j) {
					System.out.print("★");
				} else if (maze[i][j] == 1) {
					System.out.print("■");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
		}
		sleep(500);
		for(int i=0;i<50;i++) {
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				if (localpoint[0] == i && localpoint[1] == j) {
					System.out.print("☆");
				} else if (maze[i][j] == 1) {
					System.out.print("■");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
		}
		sleep(500);
		for(int i=0;i<50;i++) {
			System.out.println();
		}
		for (int i = 0; i < x; i++) {
			System.out.println();
			for (int j = 0; j < x; j++) {
				if (localpoint[0] == i && localpoint[1] == j) {
					System.out.print("★");
				} else if (maze[i][j] == 1) {
					System.out.print("■");
				} else if (maze[i][j] == 0) {
					System.out.print(" ");
				}
				System.out.print(" ");
			}
		}
		sleep(500);
	}

	public boolean movePoint(int point, int[][] maze) {
		switch(point) {
		case 4:
			if((localpoint[1]<1)) {
				break;
			}
			localpoint[1]--;
			break;
		case 5:
			if((localpoint[0]>maze.length-2)) {
				break;
			}
			localpoint[0]++;
			break;
		case 6:
			if((localpoint[1]>maze.length-2)) {
				break;
			}
			localpoint[1]++;
			break;
		case 8:
			if((localpoint[0]<1)) {
				break;
			}
			localpoint[0]--;
			break;
		default : 		
		}
		if (maze[localpoint[0]][localpoint[1]] == 1) {
			crash = true;
			return false;
		} else if(localpoint[0] == endpoint[0] && localpoint[1] == endpoint[1]) {
			escape = true;
			return false;
		}		
		return true;
	}

	public void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void ranking() {
		
	}

}
