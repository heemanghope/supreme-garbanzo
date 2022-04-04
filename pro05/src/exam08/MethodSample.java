package exam08;

public class MethodSample {
	
	public int num1;		// 인스턴스 변수 = 멤버 변수(필드)
	public static int num2;	// 클래스 변수 = 정적 변수 = 정적 멤버 변수(필드)
	
	public void method01() {
		System.out.println("일반(인스턴스) 메서드 실행됨.");
	}
	
	public static void method02() {
		System.out.println("static(정적/클래스) 메서드 실행됨.");
	}
	
	public int method03() {
		return 0;
	}
	
	public int[] method04() {
		int[] result = new int[3];
		return result;//return 결과값을 반환한다.
	}
	
	public String method05() {
		String result = new String(); //String 과 같은 객체 타입은 Null로 return시킬 수 있음.
		return result;
	}
	
	public void method06(int []arr) {
		System.out.println(arr);
		arr[0] =10;//얕은복사 활용하기
	}
	
	public void method07(int ... nums) {
		for(int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
}
