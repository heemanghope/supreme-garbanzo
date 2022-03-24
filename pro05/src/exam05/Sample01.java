package exam05;
import java.util.Random;

public class Sample01 {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();
  
		 System.out.println(c1.radius+"|" +c2.radius);
		
		 c1.radius =1.5;          c2.radius =3.5;
		 System.out.println(c1.radius+"|" +c2.radius);
	
	
	     c1.diamiter =c1.radius *2;
	     c1.diamiter =c2.radius *2;
	     
	     System.out.println(c1.diamiter+"|" +c2.diamiter);
	      
	     c1.area =c1.PI * c1.radius * c1.radius;
	     c1.area =c2.PI * c2.radius * c2.radius;
	     System.out.println(c1.area+"|" +c2.area);
	     
	     Rectangle r1 =new Rectangle();
	     Rectangle r2 =new Rectangle();
	     
	     r1.width =c1.diamiter;
	     r2.width =c2.diamiter;
	     
	     System.out.println(r1.width+"|" +r2.width);
	     
	     Random rand =new Random();
	     
	     r1.height =rand.nextInt(7) +3; //3~9사이의 범위 3,4,5,6,7,8,9
	     r2.height =rand.nextInt(7) +3;
         System.out.println(r1.height + "|"+ r2.height);
         
	     r1.area =r1.width * r1.height;
	     r2.area =r2.width * r2.height;
	     System.out.println(r1.height + "|"+ r2.height);
	     
	     }
 
}
