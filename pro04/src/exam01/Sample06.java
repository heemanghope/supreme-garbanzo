package exam01;

import java.util.Arrays;

public class Sample06 {

	public static void main(String[] args) {
		/*
		 * 배열의 깊은 복사 -> 반복문을 사용하여 값을 하나씩 배열에 저장 
		 */
		int[] arr1 =new int [] {1, 2, 3, 4,5};
		int[] arr2 = new int [arr1.length];
		
		for(int i=0; i< arr1.length; i++) {//기본
		    arr2[i] = arr1[i]; 
		   //복사본          원본   
	     }
		
		//자바의 기본 기능을 사용한 깊은 복사
		int[] arr3 =new int[arr1.length];  //arr1 길이가 5개이다. 그러나 배열의 크기가 벗어날수 있으므로 -1 ,4까지.
		System.arraycopy(arr1, 1, arr3, 0,arr1.length -1);         //arr1.length -1 만큼 반복한다
		                // 원본 시작! ,  복사본  ,  i< arr1.length;
		arr1[0] = 10;                                              //배열의 범위를 조심하기
		for(int i =0; i <arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr3[%d] -> %d\n",i, arr1[i],i,arr3[i]); 
		}  
		
		
		//Arrays 객체를 사용한 깊은 복사 //위치를 옮기고 싶다!
        int[] arr4= Arrays.copyOf(arr1,arr1.length); //+1 ,-1 더 늘리거나 줄일수 있는 것이다. 해당하는 크기만큼!!
		                //      arr1이 가지고 있는 것을 크기만큼 !!
		arr1[1] = 20;
		for(int i =0; i <arr1.length; i++) {
			System.out.printf("arr1[%d] -> %d, arr4[%d] -> %d\n",i, arr1[i],i,arr4[i]); 
	}
		//System.out.println("arr4[5] -> " + arr4[5]);
		//System.out.println("arr4[6] -> " + arr4[6]);
		//System.out.println("arr4[7] -> " + arr4[7]);
		//초기화를 별도로 하지 않으면 기본값이 사용된다.-> 정수는 기본값이 0이다 문자열은 null이다.
		
		//배열의 크기를 줄일 시에는 배열의 크기가 작은 것을 기준으로 하기..안그럼 인덱스범위가 초과됨;
		
		
	
	    // .clone() 메서드를 사용한 깊은 복사
	    int[] arr5 = arr1.clone(); //그대로 복사 !!!


        arr1[2] = 30;
        for(int i =0; i <arr1.length; i++) {
	    System.out.printf("arr1[%d] -> %d, arr5[%d] -> %d\n",i, arr1[i],i,arr5[i]); 
            }

  }

}
