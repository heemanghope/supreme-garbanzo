package exam01;

import java.util.Arrays;

public class Sample10 {

	public static void main(String[] args) {
		/*
		 *  동적 배열
		 *          - 기존 배열의 크기보다 크거나 작은 새로운 배열을 만들어서 사용하는 형태
		 *          // 고정 값값값- 복사...(깊은 복사)
		 *          
		 *          
		 */
		
		int[] arr1 = new int[] {1,2,3};
	    System.out.println(Arrays.toString(arr1));
		 //얕은 복사 참조값을 같게한다. arr1에 새로운 배열 참조 i < arr1.length; i++   
	     //동적 배열을 만들기 위해 임시 배열 저장 공간 생성
		 int[] temp =new int[arr1.length +1];
		//arr1 3->4 기존의 가지고 있던 길이가 3에서 4로 늘어난다.//실제로는 늘어난건데 같은 공간을 사용하는것처럼 보임
		 for(int i =0; i < arr1.length; i++) {
		      temp[i] =arr1[i];//깊은 복사
		
	          }
	     arr1 =temp;//얕은 복사-참조값을 만들어줌.
	
	     System.out.println(Arrays.toString(arr1));
	         
	         //clone 으로는 동적배열이 불가능하다.(그대로 가져와서 저장)
	         //Arrays.copyof//System.arraycopy만 동적 배열 가능
	         
	    
	         
	         //Arrays.copyof 를 사용한 동적 배열
	         temp =Arrays.copyOf(arr1,arr1.length +1);
	         arr1=temp;
	         
	         System.out.println(Arrays.toString(arr1));
    	   
	         
	         //System.arraycopy 를 사용한 동적 배열 
	         temp =new int[arr1.length +1];
	         System.arraycopy(arr1,0, temp,0, arr1.length);
	         arr1= temp; //얕은 복사
	         
	         System.out.println(Arrays.toString(arr1));
	         
	         temp =new int[arr1.length +1];
	         System.arraycopy(arr1,0, temp,1, arr1.length);
	         arr1= temp;
	         
	         System.out.println(Arrays.toString(arr1)); //tostring 알아서 배열을 계산해줌
	         
             }
             

}
