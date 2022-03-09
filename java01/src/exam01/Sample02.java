package exam01;

public class Sample02 {

	public static void main(String[] args) {
		int a = 1_000_000;     //1_000_000  10의 6제곱
        int b = 2_000_000;     //2_000_000  10의 6제곱
	
        
        //10의 12제곱       int의 범위는 10의 9제곱
	long c =(long) a *b;              // a *b = 2,000,000,000,000 ?
	
	System.out.println(c);
        
	}

}
