     public class Expression {

	private char op;

	private Expression left;

	private Expression right;

	private int constant;

	public Expression(int constant) {
		this.op = 'c';
		this.constant = constant;
	}

	public Expression(char op, Expression left, Expression right) {
		this.op = op;
		this.left = left;
		this.right = right;
	}
	// In this exercise I created four classes for 4 operations -+/* which implement IOperation interface
	//and in each class there is a method evaluate which performs required operation

	public int evaluate() {
		IOperation operation;
		switch (op) {
		case 'c':
			return constant;
		case '+':
			operation = new Addition();
			return operation.evaluate(left, right);
		case '-':
			operation = new Substraction();
			return operation.evaluate(left, right);
		case '*':
			operation = new Multiplication();
			return operation.evaluate(left, right);
		case '/':
			operation = new Division();
			return operation.evaluate(left, right);
		default:
			throw new IllegalStateException();
		}
	}
}
