package exam11;

public class Main {

	public static void main(String[] args) {
		BasicCalculator calc1 = new Calculator();
		System.out.println(calc1.add(4 , 2));
		System.out.println(calc1.sub(4 , 2));
		System.out.println(calc1.mul(4 , 2));
		System.out.println(calc1.div(4 , 2));
		
		BasicCalculator calc2 = new EngineerCalc();
		System.out.println(calc2.add(4 , 2));
		System.out.println(calc2.sub(4 , 2));
		System.out.println(calc2.mul(4 , 2));
		System.out.println(calc2.div(4 , 2));
		
        EngineerCalc eng = (EngineerCalc)calc2;
		System.out.println(eng.mod(4,2));
		System.out.println(eng.sqrd(4,2));
		System.out.println(eng.abs(4));
	}

}
