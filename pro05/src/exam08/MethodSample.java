package exam08;

public class MethodSample {
	
	
	
	public int num1;                    //인스턴스 변수 = 멤버 변수(필드)
	
	public static int num2;              //클래스 변수 =정적 변수 = 정적 멤버 변수(필드)
	
	
	public static void method01() {
		  System.out.println("일반(인스턴스) 메서드 실행됨.");
	}
    
	
	public static void method02() {
		System.out.println("static(정적/클래스) 메서드 실행됨.");
	}

	public int method03() {
		return 0; //연산하는 값이 없으므로 
	}
	
	public int[] method04() {
		int[] result = new int[3];      //int 배열로 한다.
		
		return result;//result반환해라.
	}
	
	public String method05() {  //String 자료형이 아니라 클래스(객체)를 의미한다.
		String result = new String();
	    return result; //String return 타입은 null로도 할수있음 . return null;
	}
	
   public int[] method06(int[] arr) {
	   System.out.println(arr);
	   arr[0] =10;//return을 시켜주지 않아도 
	   return arr;
       }
     
	public void method07(int...nums) {
		//가변인자는 항상 마지막에 와야한다.
		for (int i =0; i<nums.length; i++) {
        	System.out.println(nums[i]);
	
                 }
	
         }

// 조합해서 하는것

}
	
