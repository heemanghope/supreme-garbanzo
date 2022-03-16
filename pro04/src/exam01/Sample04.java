package exam01;

public class Sample04 {

	public static void main(String[] args) {
		/*
		 *  변수에 저장된 값을 복사하여 사용
		 */
		int n1 =10;
		int n2 =n1;                // n1에 저장된 값을 n2에 복사
		
		System.out.printf("n1 -> %d, n2 -> %d\n", n1, n2);
		
		n1 =15;
		n2 =100;
		
		System.out.printf("n1 -> %d, n2 -> %d\n", n1, n2);
		
		
		/*
		 *  배열 복사 -> 얕은 복사 //참조값만 복사해서 사용한다.  //서로 같은 공간의 값을 바꾸기
		 */

		
		 int[] arr1 = new int[] {1,2,3,4,5};
		 int[] arr2 = arr1;//arr1의 값을 arr2로 참조값을 만드는 것
		 
		 for (int i =0; i<5; i++) {
			 System.out.printf("arr1[%d] -> %d, arr2[%d] - > %d\n", i,arr1[i],i,arr2[i]);
		 }
		 
		 arr1[0] = 15;
		 arr2[1] = 100;
		 for (int i =0; i<5; i++) {
			 System.out.printf("arr1[%d] -> %d, arr2[%d] - > %d\n", i,arr1[i],i,arr2[i]);
		 }
		 
		 /*
		  * 배열 복사 -> 깊은 복사
		  */
		  
		 int[]arr3 =new int[] {1,2,3,4,5};	 
		 int[]arr4 =new int [5];
		 
		 
		 
		 //배열을 복사하는 것이 아닌 배열에 저장된 값을 복사한다.
		 for(int i=0; i <5; i++) {
			 arr4[i] =arr3[i];
			 
			        // arr3번 arr4번 값이 같지 않음(깊은 복사) -서로 다른 공간의 값을 바꾼다.
		 }
		 
		 for (int i =0; i<5; i++) {
			 System.out.printf("arr3[%d] -> %d, arr4[%d] - > %d\n", i,arr1[i],i,arr4[i]);
		 }
		 
		 arr1[0] = 15;
		 arr2[1] = 100;
		 for (int i =0; i<5; i++) {
			 System.out.printf("arr3[%d] -> %d, arr4[%d] - > %d\n", i,arr1[i],i,arr4[i]);
		 }
		 
		 
	}
 
}

//공간 -> n1 네모안에 값
//공간 -> arr1 (안에 참조값) 만들어줌-> 네모 안에 1,2,3,4(공간) -new int 5//메모리 어딘가에 있는 공간을 만듦.
//int[] arr1;
//참조값이 같은 것이다.
//배열에 저장되어있는 값 자체를 복사한다.-> 깊은 복사
