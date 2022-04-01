package exam01;

import java.util.Arrays;

public class Sample01 {

	public static void main(String[] args) {
		
		/*
		 * String 생성자
		 */
		String s1 = new String();
		String s2 = new String("생성자");
		
		char[] cArr = new char[] {'A','B','C','D'};
		String s3 = new String(cArr);
		
		byte[] bArr = new byte[] {65, 66,67,68};
		
		String s4 = new String(bArr);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
		/*
		 * String 관련 메서드
		 */
		String s5,s6;
		
         s5 = new String("동일문자열비교");
         s6 = new String("동일문자열비교");
         
         boolean isEqual =s5.equals(s6);
         System.out.println("s5.equals(s6) -> " + isEqual);
         
         int len =s5.length();
         System.out.println("s5.length() ->"+ len);
         
         for(int i=0; i<s5.length(); i++) {
           char c1 = s5.charAt(i);
         System.out.printf("s5.charAt(%d) ->%c\n" ,i,c1);
         
         } 
         s5 ="Java Programming Language";
         boolean isContains =s5.contains("Program");
         System.out.println("s5.contains(\"Program\") -> " +isContains);
         
         isContains =s5.contains("program");
         System.out.println("s5.contains(\"program\") -> " +isContains);
         
         
         int location;
         location = s5.indexOf("Program");
         System.out.println("s5.indexOf(\"program\") -> " +location);
         
         
  
         location = s5.indexOf("program");
         System.out.println("s5.indexOf(\"program\") -> " +location);
         
         s5 = s5.replace("Program", "프로그램");
         System.out.println("s5.replace(\"Program\", \"프로그램\") -> " +s5);
         
         s5 = s5.replace("java", "자바");
         System.out.println("s5.replace(\"java\", \"자바\") -> " +s5);
         
         String[] sArr;
         sArr =s5.split( " ");
         System.out.println("s5.split(\"\") -> " + Arrays.toString(sArr));
         
         s5 =String.join("_", sArr);
         System.out.println("String.join(\"_\",sArr) -> " +s5);
         
         s5 = "     앞/뒤로 공백이 존재하는 문자열   ";
         System.out.println(s5);
         
         s5 =s5.trim();
         System.out.println("s5.trim() -> " +s5);//앞뒤 공백을 제거해준다.
         
         s5 = "String Methods";
         System.out.println("s5. toUpperCase()  -> " + s5.toUpperCase());
         System.out.println("s5. toLowerCase()  -> " + s5.toLowerCase());
         
        		 
         System.out.println("s5.substring(3,6) -> " + s5.substring(3,6)); //원하는 범위만큼 잘라내기
         System.out.println("s5.substring(7,11) -> " + s5.substring(7,11)); //원하는 범위만큼 잘라내기
        
         
         s6 = "Meth";
 		System.out.println("s5.substring(7, 11) -> " + s5.substring(s5.indexOf(s6), s5.indexOf(s6) + s6.length()));
         
	    //System.out.prinf("포멧형식이 있는 문자열", 포멧형식에 사용할 값...)
 		s6=String.format("%d/%s/%.1f",10,"포멧문자열",10.123);
 		System.out.println(s6);
 		
 		
 		
 		s6 ="02-ertf-5678";      
 		boolean isMatch =s6.matches("\\d{3}-\\d{4}-\\d{4}"); 
 		//  정규표현식 문자열이라고함.     숫자3자 - 숫자4자 - 숫자4자
 		System.out.println("전화번호 형식과 일치합니까? ->" + isMatch);
 		
	}

}

// 자바에서 문자열에 사용하는 \(역슬레시)는 어디에 사용되는가? -이스케이프 문자에 사용.
// 정규표현식 -> \d//숫자를 의미한다.1자        // 정규표현식\d를 넣어준것임.