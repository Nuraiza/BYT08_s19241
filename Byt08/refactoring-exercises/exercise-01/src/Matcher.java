
public class Matcher {
	public Matcher() {
	}

	
	public boolean IsMatched(int[] expected, int[] actual, int clipLimit, int delta) {

		// Clip "too-large" values
		Clip(actual, clipLimit);

		// Check for length differences
		if (actual.length != expected.length)
			return false;

		// Check that each entry within expected +/- delta
		return compareElements(expected, actual, delta);
	}

// In this exercise I refactored the code in the following way: I extracted 2 methods from chunk of code in
	// IsMatched method, so that it looks clearer by Refactor-> Extract method function
	
	
	
	private boolean compareElements(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;

		return true;
	}


	private void Clip(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}
	

	
}