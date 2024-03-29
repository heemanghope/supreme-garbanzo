package exam02;

public class Sample02 {

	public static void main(String[] args) {
		//printf 활용하여 표형식으로 출력(정렬)
		//       가급적 영문자로만 작성하세요.
		System.out.print("+--------+--------+\n");         //기본은 오른쪽정렬
		System.out.printf("|%8s|%8s|\n", "name","age");
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "Hong", 34);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "kim",28);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "park",19);
		System.out.print("+--------+--------+\n");
		
		
		System.out.println();      // 위쪽 출력과 구분하기 위한 개행.
		
		
		
		
		
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8s|\n", "name","age");          //-붙이면 왼쪽 정렬 
		System.out.printf("|%-8s|%-8.2f|\n", "Hong", 34.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "kim",28.0);
		System.out.print("+--------+--------+\n");
		System.out.printf("|%-8s|%-8.2f|\n", "park",19.0);
		System.out.print("+--------+--------+\n");
		
				
		
		

		
		
		
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8s|\n", "이름","나이");   //총 8(여덟자리수)은 출력해야하는 단위의 자릿수..
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "홍길동", 34);     //.2f는 소숫점 2자리까지
		System.out.print("+--------+--------+\n");          //일정한 표형식으로 만들기
		System.out.printf("|%8s|%8d|\n", "김스티븐",28);     //터미널이나 콘솔이라는 환경에서 영문자가 1칸
		System.out.print("+--------+--------+\n");
		System.out.printf("|%8s|%8d|\n", "박마리아나",19);
		System.out.print("+--------+--------+\n");
	}

}
