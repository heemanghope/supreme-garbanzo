package exam07;

public class Ovr {

	public static void main(String[] args) {
		int arr[];
		int i =0;
		arr = new int[10];
		arr[0] =0;
		arr[1]= 1;
	//  arr[2]= 1;
	//  arr[3] =2;
 //     arr[4] = 3;
	//  arr[5] =5;
//      arr[6] =8;
//      arr[7] =13;
//		arr[8] =21;
//      arr[9] =34;		
		while(i<8) {
			arr[i+2] =arr[i+1]+arr[i];
			//int가 0일때 arr2의 값은 1이다.
			i++;
			
		}
       System.out.println(arr[9]);
	}

}
