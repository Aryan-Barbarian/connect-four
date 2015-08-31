import java.util.Scanner;
public class HumanPlayer extends Player {

	public HumanPlayer(String mark) {
		super(mark);
	}

	public int bestMove() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt(); // TODO: Errors?
	}

}