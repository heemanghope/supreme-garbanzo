package exam01;

import java.util.Random;
public class Sample09 {

	public static void main(String[] args) {
		/*
		 * 배열의 크기가 5 인 정수 배열을 생성하고 해당 배열에 1~19까지의 
		 * 정수 값을 임의로 생성하여 초기화 하는 작업을 수행하도록 한다.
		 * 단, 배열에 초기화된 값은 중복되어서는 안된다.
		 * 
		 */
		Random rand = new Random();            
	    int[] arr1 =new int[5];
	    boolean duplicate =false;//flag를 이용한다.
	    
	    for (int i=0;i <arr1.length;)  {
	    	int num = rand.nextInt(19) + 1;     
	    	duplicate =false;       //중복이 있으면 안된다.
	    	
	    	for(int j =0; j <i; j++)//중복 검사 수행하기.0과1까지만 .2일떄 j
	    		if(arr1[j] == num) {
	    			duplicate =true;
	    			
	    			break;//인접한 for문 중단시키기
	    		}
	    	
	    	  if(! duplicate) {//중복이 안되엇을때만 추가해라
	             arr1[i] =num;//1씩 증가가 아니라 데이터를 추가할때마다
	                           //중복이 되었다면 유지를 시켜주고 중복이 안되었을때는 다음걸로 증가시키기
	             System.out.print(arr1[i] + "\t"); 
	             i++;
	    	  } 
	            
	    
	    }
	    
	   
	    	System.out.print("\n");
	}
	 
    }

