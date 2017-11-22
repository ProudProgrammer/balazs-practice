package hu.gaborbalazs.lambda;

public class LambdaExpressionProblem {

	public static void main(String[] args) {

	    System.out.println(">> main()");
	    
		try {
			m1();
		} catch (Exception e) {
			System.out.println("Caught, but I don't want to throw away");
		}
		
		try {
		    m5();
		} catch(RuntimeException e) {
		    System.out.println("Caught, but I don't want to throw away");
		}
		
		System.out.println("<< main()");
	}
	
	public static void m1() throws Exception {
		LambdaExpressionProblem.m3(() -> LambdaExpressionProblem.m2(5));
	}
	
	public static void m2(Integer i) throws MyException {
		System.out.println(i);
	}
	
	public static void m3(MyInterfaceWithException myInterface) throws Exception {
		myInterface.accept();
	}
	
	public static void m4(MyInterface myInterface) {
	    myInterface.accept();
	}
	
	public static void m5() {
	    m4(() -> {
	        System.out.println("m4() called from m5()");
	        throw new RuntimeException("Exception from m5()");
	    });
	}
}

@SuppressWarnings("serial")
class MyException extends Exception {
	
	public MyException() {
		super();
	}
	public MyException(String s) {
		super(s);
	}
}

interface MyInterfaceWithException {
	void accept() throws Exception;
}

interface MyInterface {
    void accept();
}