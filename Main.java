public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");

		int size = 6;
		Player p1 = new AIPlayer();
		Player p2 = new AIPlayer();
		Game game = new Game(p1, p2, size);	

		
	};
}