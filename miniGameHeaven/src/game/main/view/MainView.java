package game.main.view;

import java.util.Scanner;

import game.card.view.CardView;
import game.frog.Frog;
import game.frog.FrogView;
import game.main.controller.MainController;
import game.main.model.Member;
import game.maze.view.MazeView;

public class MainView {
	Scanner sc = new Scanner(System.in);

	public void main() {
		MainController mc = new MainController();
		while (true) {
			System.out.println("---------------------------------------------");
			System.out.println("*★    < M I N I    G A M E    H E A V E N > ★*");
			System.out.println("=============== 1. 게임 시작 ===================");
			System.out.println("=============== 2. 회원 가입 ===================");
			System.out.println("=============== 0. 게임 종료 ===================");
			System.out.println("---------------------------------------------");
			System.out.print("sel > ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {
			case 1:
				mc.start(start());
				break;
			case 2:
				mc.newMem(selId());
				break;
			case 0:
				System.out.println("@@@ 종료합니다 @@@");
				return;
			}
		}
	}

	private Member start() {
		System.out.print("ID를 입력하세요 : ");
		String id = sc.next();
		System.out.print("PWD를 입력하세요 : ");
		String pWD = sc.next();
		Member m = new Member();
		m.setID(id);
		m.setPWD(pWD);
		return m;
	}

	private String selId() {
		System.out.print("ID를 입력하세요 : ");
		String str = sc.next();
		return str;
	}

	public Member newMem(String selId) {
		System.out.print("PWD를 입력하세요 : ");
		String pWD = sc.next();
		System.out.print("닉네임을 입력하세요 : ");
		String nickName = sc.next();
		Member m = new Member(selId, pWD, nickName);
		return m;
	}

	public void print(String str) {
		System.out.println(str);
	}

	public void gameList() {
		while (true) {
			System.out.println("게임 목록");
			System.out.println("1. 미로 찾기");
			System.out.println("2. 카드 게임");
			System.out.println("3. 개구리 게임");
			System.out.print("sel > ");
			int sel = sc.nextInt();
			sc.nextLine();
			switch (sel) {
			// 컨트롤러.게임 -> 메인 컨트롤러에서 각 게임의 뷰어로 연결(?)
			case 1:
				MazeView mv = new MazeView();
				mv.main();
				break;
			case 2:
				CardView cv = new CardView();
				cv.main();
				break;
			case 3:
				FrogView fv = new FrogView();
				fv.main();
				break;
			default:
				System.out.println("뷁");
				continue;
			//0종료
			case 0:
				return;
			}
		}
	}
}
