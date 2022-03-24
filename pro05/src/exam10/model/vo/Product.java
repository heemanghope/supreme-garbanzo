package exam10.model.vo;

public class Product {
      private String pName="키보드";
      private int price = 25000;
      private String brand ="X오X드";
      
      // 기본 생성자는 생략하여 쓰는 것으로 한다.
   //매개변수가 있는 생성자가 없기 때문에.가능!!
      public void information( ) { //메서드명이 information
    	System.out.println(pName);  
    	System.out.println(price);  
    	System.out.println(brand);  
    	  
    	  
    	  
      }
}
