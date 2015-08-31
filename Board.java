public class Board  {
	
	private final int MAX_RUN_LENGTH = 4;
	private Player[][] pieces; // indexed [column][row] so be careful
	private Game game;
	private int size;

	public Board(Game game, int size) {
		this.game = game;
		this.size = size;
		this.pieces = this.initPieces(size);
	}

	public Board(Game game, Player[][] pieces) {
		this(game, pieces.length);
		this.pieces = pieces;
	}

	private Player[][] initPieces(int size) {
		Player[][] ans = new Player[size][size];
		return ans;
	}

	private Player[][] initPieces(Player[][] pieces) {
		int size = pieces.length;
		Player[][] ans = new Player[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				ans[i][j] = pieces[i][j];
			}
		}
		return ans;
	}

	public Board copy() {
		return new Board(this.game, this.pieces);
	}

	public void move(Player player, int position) {
		for (int row = 0; row < this.pieces[position].length; row++) {
			if (this.pieces[position][row] == null ) {
				this.pieces[position][row] = player;
				return;
			}
		}
	}

	public int longestRun(Player player) {
		// TODO: maintain a set of col,rows not check again
		int ans = 0;
		for (int col = 0; col < this.size; col++ ) {
			for (int row = 0; row < this.size; row++ ) {
				int newVal = longestRun(player, col, row);
				if (newVal > ans)
					ans = newVal;
			}
		}

		return ans;
	}

	private int longestRun(Player player, int col, int row) {

		if (this.pieces[col][row] != player) {
			return 0;
		}

		int ans = 0;
		
		int newVal = southRun(player, col, row);
		if (newVal > ans)
			ans = newVal;

		newVal = eastRun(player, col, row);
		if (newVal > ans)
			ans = newVal;

		newVal = southEastRun(player, col, row);
		if (newVal > ans)
			ans = newVal;

		newVal = southWestRun(player, col, row);
		if (newVal > ans)
			ans = newVal;

		return ans;
	}

	private int southRun(Player player, int col, int row) {

		int ans = 0;
		for (int i = row; i < this.pieces[col].length; i++ ) {
			if (this.pieces[col][i] == player) {
				ans++;
			} else {
				break;
			}
		}
		return ans;
	}

	private int eastRun(Player player, int col, int row) {
		int ans = 0;
		for (int i = col; i < this.pieces.length; i++ ) {
			if (this.pieces[i][row] == player) {
				ans++;
			} else {
				break;
			}
		}
		return ans;
	}

	private int southWestRun(Player player, int col, int row) {
		int ans = 0;
		for (int i = 0; ((col + i < this.pieces.length) && (row - i >= 0)); i++ ) {
			if (this.pieces[col + i][row - i] == player) {
				ans++;
			} else {
				break;
			}
		}
		return ans;
	}

	private int southEastRun(Player player, int col, int row) {
		int ans = 0;
		for (int i = 0; ((i + col < this.pieces.length) && (i + row < this.pieces.length)); i++ ) {
			if (this.pieces[col + i][row + i] == player) {
				ans++;
			} else {
				break;
			}
		}
		return ans;
	}

	public boolean isWinner(Player player) {
		return (this.longestRun(player) == MAX_RUN_LENGTH);
	}

	public Board moveCopy(Player player, int position) {
		Board ans = this.copy();
		ans.move(player, position);
		return ans;
	}

	public String toString() {
		String ans = "";
		String def = "-";
		for (int row = 0; row < this.size; row++ ) {
			String line = "";
			for (int col = 0; col < this.size; col++ ) {
				Player currPlayer = this.pieces[col][row];
				if (currPlayer == null) {
					line += def;
				} else {
					line += currPlayer.getMark();
				}
			}
			ans += line + "\n";
		}
		return ans;
	}
}