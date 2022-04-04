package exam04;

public class Sample01 {

	public static void main(String[] args) {
		StaticTest st1 = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
	
	
           StaticTest.share =20;
          // System.out.println(st1.share + "|" + st2.share+ "|" + st3.share);
           System.out.println(StaticTest.share + "|" + StaticTest.share+ "|" + StaticTest.share);
                              //stattictest 클래스명으로 가급적 기본적으로 작성한다.
           
           st1.share =30;
           //System.out.println(st1.share + "|" + st2.share+ "|" + st3.share);
           System.out.println(StaticTest.share + "|" + StaticTest.share+ "|" + StaticTest.share);
           
           st1.share =40;
           //System.out.println(st1.share + "|" + st2.share+ "|" + st3.share);
           System.out.println(StaticTest.share + "|" + StaticTest.share+ "|" + StaticTest.share);
           
           
           FinalTest ft1 = new FinalTest();
           
           System.out.println(ft1.CONSTAT);
           
            //ft1.CONSTANT =20;
          
           FinalstaticTest fst1 = new FinalstaticTest();
           FinalstaticTest fst2 = new FinalstaticTest();
           
           System.out.println(fst1.SHARE_CONSTANT+ "|" + fst2.SHARE_CONSTANT + "|"+ FinalstaticTest.SHARE_CONSTANT);
           }

}

//객체를 여러개 만들어도 공유하고 싶은것이있다.- static을 붙여줌/ 상수-바꾸지않을것이다 - final붙이기
// 공유+ 상수 =  final static
