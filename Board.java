public class Board  {
	
	private GamePiece[][] pieces; // indexed [column][row] so be careful
	private Game game;
	private int size;

	public Board(Game game, int size) {
		this.game = game;
		this.size = size;
		this.pieces = this.initPieces(size);
	}

	private GamePiece[][] initPieces(int size) {
		GamePiece[][] ans = new GamePiece[size][size];
		return ans;
	}

	private GamePiece[][] initPieces(GamePiece[][] pieces) {
		int size = pieces.length;
		GamePiece[][] ans = new GamePiece[size][size];

		// TODO: Implement

		return ans;
	}

	public Board(Game game, GamePiece[][] pieces) {
		this(game, pieces.length);
		this.pieces = pieces;
	}

	public Board copy() {
		return new Board(this.game, this.pieces);
	}

	public void move(Player player, int position) {
		// TODO: Implement
	}

	public Board moveCopy(Player player, int position) {
		Board ans = this.copy();
		ans.move(player, position);
	}
}