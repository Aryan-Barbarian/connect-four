import java.awt.Point;
import java.util.Random;

public class AIPlayer extends Player {
	private final int MINIMUM_SCORE = -1000;
	private final int MAXIMUM_SCORE = 1000;
	public AIPlayer(String mark) {
		super(mark);
	}
	
	public int bestMove() {
		// TODO: Implement
		Point maxVal = maxValue(this.getGame().getBoard(), this, 3);
		System.out.println("BEST MOVE IS : " + maxVal.x + " @ " + maxVal.y);
		return maxVal.x;
	}

	private int heuristic(Board board, Player player) {
		Game game = this.getGame();
		Player opponent = game.getOpponent(player);

		if (board.isWinner(opponent)) {
			return MINIMUM_SCORE;
		}

		if (board.isWinner(player)) {
			return MAXIMUM_SCORE;
		}

		return board.longestRun(player) - board.longestRun(opponent);
	}

	private Point maxValue(Board board, Player player, int depth) {
		Game game = this.getGame();
		Player opponent = game.getOpponent(player);

		if (depth == 0 || board.isWinner(opponent)) {
			return new Point(0, heuristic(board, player));
		}
		depth--;

		int num_moves = game.getBoard().size();

		Random rand = new Random();
		int tempMove = rand.nextInt(num_moves);
		Point ans = new Point(tempMove, MINIMUM_SCORE);

		for (int i = 0; i < num_moves; i++ ) {
			Board possibleBoard = board.moveCopy(player, i);
			if (possibleBoard == null) {
				System.out.println("Board is null");
				continue;
			}
			int possibleVal = -this.maxValue(possibleBoard, opponent, depth).y;
			if (possibleVal == MAXIMUM_SCORE) {
				return new Point(i, possibleVal);
			}
			else if (possibleVal > ans.y) {
				ans.y = possibleVal;
				ans.x = i;
			}
		}

		// TODO: Left off here

		return ans;
	}

}