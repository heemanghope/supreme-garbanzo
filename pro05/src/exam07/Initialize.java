package exam07;

public class Initialize {
         
	      public int n1= 10;
	      public static int n2 =20;
	      
	      
          public String s1 = "빈값";
          public static String s2= "정적";
          
          public boolean b1 =true;
          public double d1 = 1.0;
          
          {
        	  n1= 20;
        	  s1=s1+ "입니다.";
        	  b1=!b1;
        	  d1 += 9;
        	                         //스태틱 변수 o
          }
          
          static {
        	   n2 =30;
        	   s2=s2+ "!!!";         //인스턴스 변수에는 스태틱 변수는 불가능 x
        	   		
          }
          
          
}
