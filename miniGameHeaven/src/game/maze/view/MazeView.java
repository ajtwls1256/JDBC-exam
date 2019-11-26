package game.maze.view;

import java.util.Scanner;
import game.maze.controller.MazeController;

public class MazeView {
	Scanner sc = new Scanner(System.in);

	public void main() {
		MazeController mc = new MazeController();
			while (true) {
				System.out.println("★ ★  미 로 찾 기 ★ ★ ");
				System.out.println("1. 게임 시작");
				//System.out.println("2. 타임어택");
				System.out.println("3. 랭킹");
				System.out.println("0. 종료");
				System.out.print("선택 > ");
				switch (sc.nextInt()) {
				case 1:
					mc.gameStart(level());
					break;
				case 2:
					TimeAttack();
					break;
				case 3:
					mc.ranking();
					break;
				case 0:
					return;
				}
			}
		
	}

	public int level() {
		int level =0;
		while (true) {
			System.out.println("1.상, 2.중, 3.하");
			level = sc.nextInt();
			if (level > 3 || level < 1) {
				System.out.println("다시 선택해주세요.");
			}else {
				break;
			}
		}
		return level;
	}

	public void TimeAttack() {

	}

	public void ranking() {

	}
}