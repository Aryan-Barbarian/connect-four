public abstract class Player {
 	private Game game;
 	private String mark;
 	public Player(String mark) {
 		this.game = null;
 		this.mark = mark;
 	}

	public Player(Game game, String mark) {
		this(mark);
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
	public int getMove() {
		return this.bestMove();
	}

	public String getMark() {
		return this.mark;
	}


}