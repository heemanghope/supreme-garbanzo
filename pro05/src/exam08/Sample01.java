package exam08;

public class Sample01 {

	public static void main(String[] args) {
		MethodSample m1 = new MethodSample();
		m1.method01();
		m1.method02();
		
		System.out.println(m1.num1);
		System.out.println(MethodSample.num2);
		// MethodSample.method01();
		MethodSample.method02();
		
		int var1 = m1.method03(); //int var1 =m1.method03(); int배열을 반환
		int[] var2 = m1.method04();//메서드를 호출call한다.-메서드 본래의 값으로 간다.-return까지 진행- 다시 돌아옴-var2로 간다.
		String var3 = m1.method05();
		
		int[] var4 = new int[] {1, 2, 3};
		System.out.println(var4);
		
		//m1.method06(var4);//참조값만 전달한다. 얕은복사 //return하지않아도 얕은복사하면 가능 (값나오기)
		
		
		//깊은 복사활용하면 값이 달라진다.(새로운경우)
		m1.method06(var4.clone());
		System.out.println(var4[0]);
		m1.method07(1, 2, 3, 4);
	}

}

//코드 잘 확인하기.
