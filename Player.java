public abstract class Player {
 	private Game game;

 	public Player() {
 		this.game = null;
 	}

	public Player(Game game) {
		this();
		this.game = game;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game newGame) {
		this.game = newGame;
	}

	public Board getBoard() {
		return this.game.getBoard();
	}

	public abstract int bestMove();

}