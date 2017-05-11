package hu.gaborbalazs.lambda;

public class LambdaExpressionProblem {

	public static void main(String[] args) {

		try {
			m1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void m1() throws Exception {
		LambdaExpressionProblem.m3(() -> LambdaExpressionProblem.m2(5));
	}
	
	public static void m2(Integer i) throws MyException {
		System.out.println(i);
	}
	
	public static void m3(MyInterface myinterface) throws Exception {
		myinterface.accept();
	}
}

class MyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MyException() {
		super();
	}
	public MyException(String s) {
		super(s);
	}
}

interface MyInterface {
	void accept() throws Exception;
}