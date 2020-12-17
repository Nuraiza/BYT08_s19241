public class TicTacToe {
	public StringBuffer board;

	public TicTacToe(String s) {
		board = new StringBuffer(s);
	}

	public TicTacToe(String s, int position, char player) {
		board = new StringBuffer(s);
		board.setCharAt(position, player);
	}

	public int suggestMove(char player) {
		for (int i = 0; i < 9; i++) {
			if (board.charAt(i) == '-') {
				TicTacToe game = makeMove(i, player);
				if (game.winner() == player)
					return i;
			}
		}

		return -1;
	}

	public TicTacToe makeMove(int i, char player) {
		return new TicTacToe(board.toString(), i, player);
	}
//In this exercise winner method was too messy, so I extracted 3 methods from its code into horizontalCheck(),
	// verticalCheck() and diagonalCheck() methods by using Refactor-> Extract method function
	
	
	public char winner() {
		// check for horizontal winner
		horizontalCheck();

		// check for vertical winner
		verticalCheck();

		// check for diagonal winner
		diagonalCheck();

		// no winner yet
		return '-';
	}

	
	
	private char diagonalCheck() {
		// here I prevented the duplication of board.charAt(0) and created a local variable firstChar
		char firstChar = board.charAt(0);
		if (firstChar != '-' && board.charAt(4) == firstChar
				&& board.charAt(8) == firstChar)
			return firstChar;
		if (board.charAt(2) != '-' && board.charAt(4) == board.charAt(2)
				&& board.charAt(6) == board.charAt(2))
			return board.charAt(2);
		return '-';
	}

	
	
	private char verticalCheck() {
		for (int i = 0; i < 3; ++i) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 3) == board.charAt(i)
					&& board.charAt(i + 6) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}

	
	
	
	private char horizontalCheck() {
		for (int i = 0; i < 9; i += 3) {
			if (board.charAt(i) != '-'
					&& board.charAt(i + 1) == board.charAt(i)
					&& board.charAt(i + 2) == board.charAt(i))
				return board.charAt(i);
		}
		return '-';
	}
	
	
	
	
	
	
	
}
