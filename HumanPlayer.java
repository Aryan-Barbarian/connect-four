import java.util.Scanner;
public class HumanPlayer extends Player {

	public HumanPlayer(String mark) {
		super(mark);
	}

	public int bestMove() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where to move to?");
		return scanner.nextInt(); // TODO: Errors?
	}

	public int getMove() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Where to move to?");
		return scanner.nextInt(); // TODO: Errors?
	}

}