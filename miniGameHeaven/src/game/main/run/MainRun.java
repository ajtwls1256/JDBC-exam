package game.main.run;

import java.util.Scanner;

import game.card.view.CardView;
import game.frog.Frog;
import game.frog.FrogView;
import game.main.view.MainView;
import game.maze.controller.MazeController;
import game.maze.view.MazeView;

public class MainRun {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
//		MainView mv = new MainView();
//		mv.main();
		
		
//		MazeView mv = new MazeView();
//		mv.main();
		
		
//		Frog fg = new Frog();
//		fg.main();
		FrogView fv = new FrogView();
		fv.main();
		
		
//		CardView cv = new CardView();
//		cv.main();
	}
}
