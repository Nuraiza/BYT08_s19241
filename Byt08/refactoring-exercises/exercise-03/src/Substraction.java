
public class Substraction implements IOperation {

	


	@Override
	public int evaluate( Expression left, Expression right) {
		return left.evaluate() - right.evaluate();
	}

}
