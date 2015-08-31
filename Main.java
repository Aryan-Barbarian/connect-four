public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");

		int size = 6;
		Player p1 = new AIPlayer("X");
		Player p2 = new AIPlayer("O");
		Game game = new Game(p1, p2, size);	
		while (game.getWinner() == null) {
			game.turn();
		}

	};
}