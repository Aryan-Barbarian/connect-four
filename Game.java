public class Game {

	private Board board;
	private Player player1, player2;
	private Player currentPlayer;
	private Player winner;

	public Game(Player p1, Player p2, int size) {
		this.player1 = p1; this.player2 = p2;
		this.currentPlayer = this.player1;
		this.board = new Board(this, size);
	}

	public void turn() {
		Player player = this.currentPlayer;
		System.out.println("Getting next move from " + player.getMark());
		int nextMove = -1;
		while (! this.move(player, nextMove))
			nextMove = player.getMove();
		System.out.println("Player " + player.getMark() + " moved to " + nextMove);
		this.currentPlayer = this.nextPlayer();
		this.printBoard();
	}


	public void printBoard() {
		System.out.println("###  BOARD  ###");
		System.out.println("" + this.board);
		System.out.println("###############");
		System.out.println(this.board.longestRun(this.player1));
		System.out.println(this.board.longestRun(this.player2));
		System.out.println("###############");

	}


	public Player nextPlayer() {
		return getOpponent(this.currentPlayer);
	}

	public Player getOpponent(Player player) {
		if (player == this.player1) {
			return player2;
		} else {
			return player1;
		}
	}

	public boolean move(Player player, int move) {
		return this.board.move(player, move);
	}

	public Player getWinner() {
		if (board.isWinner(this.player1)) {
			return this.player1;
		}

		if (board.isWinner(this.player2)) {
			return this.player2;
		}

		return null;
	}

	public Board getBoard() {
		return this.board;
	}

}