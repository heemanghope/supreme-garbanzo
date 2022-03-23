package exam08;

public class Sample01 {
 
	
	public static void main(String[] args) {
		MethodSample m1 = new MethodSample();
		m1.method01();
		m1.method02();
		
		System.out.println(m1.num1);
		System.out.println(MethodSample.num2);
		
		
		//MethodSample.method01();
		MethodSample.method02();
		 
		
		int var1 =m1.method03(); //정수값이므로 int값을 넣는다.
		int [] var2 = m1.method04();//int 배열을 반환했다가 저장할수 있게 하라.
		String var3 =m1.method05();
	
		
		int[]var4 =new int[] {1, 2, 3};
		System.out.println(var4); // 출력시킴
		int[] var5=m1.method06(var4.clone());
		System.out.println(var4[0]);
		
		m1.method07(1,2,3,4);//가변인자에 전달할때 배열이 되는 것이다.		
	}
}         

