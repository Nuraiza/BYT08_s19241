
public class Division implements IOperation {

	@Override
	public int evaluate(Expression left, Expression right) {
		// TODO Auto-generated method stub
		return left.evaluate() / right.evaluate();
	}

	

}
