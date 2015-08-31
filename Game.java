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
		System.out.println("Getting next move from " + player.name);
		int nextMove = player.getMove();
		System.out.println("Player " + player.name + " moved to " + nextMove);
		this.move(player, nextMove);
		this.currentPlayer = this.nextPlayer();
	}


	public void printBoard() {
		System.out.println("###  BOARD  ###");
		System.out.println("" + this.board);
	}


	public Player nextPlayer() {
		if (this.currentPlayer == this.player1) {
			return player2;
		} else {
			return player1;
		}
	}

	public void move(Player player, int move) {
		this.board.move(player, move);
	}

	public Player getWinner() {
		return this.board.getWinner();
	}

}