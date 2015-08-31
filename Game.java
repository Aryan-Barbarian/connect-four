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
		// TODO: Implement

		this.currentPlayer = this.nextPlayer();
	}


	public Player nextPlayer() {
		// TODO: Implement
	}

	public void makeMove(Player player, int move) {
		// TODO: Implement
	}

}