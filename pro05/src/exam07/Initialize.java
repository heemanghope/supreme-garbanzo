package exam07;

public class Initialize {
        public int n1 =10;
        public static int n2 = 20;
        public String s1 = "빈값";
        public static String s2 ="정적";
        public boolean b1 = true;
        public double d1=1.0;           //명시적 초기화 블럭
        {
        	n1 =20;
        	s1 =s1 + "입니다.";
        	b1 =!b1;
        	d1+=9; //인스턴스 초기화 블록 초기화
        	s2 =s2 + "~~~~";          //스테틱 변수 가능
        }

          
        static {
        	int n2 = 30;    //인스턴스 변수 안됨.
        	s2 =s2 + "!!!";
        }
        
        
        //인스턴스는 객체를  생성 -> 초기화
        //클래스초기화는 프로그램이 동작할때 최초1회.
        //constructor 생성자 
        //객체가 new 연산자 생성
        //필드는 멤버변수
}