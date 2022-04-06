package exam04;



public class PremiumCustomer extends Customer {
                
                 private double discount;
                 private int priceTotal;

                 public PremiumCustomer(String name, int age, char gender) {
                	 super(name, age , gender);
                 }
                 
                 //프리미엄의 고객의 경우에는 다르다.누적구입액! 중요! 
                 @Override
                 public void buy(String productName,double price) {
                	price = _calcDistcount(price);
                	this.priceTotal += price;//현재 가격에 누적구입액을 증가
                	System.out.printf("%s님이 %s 을(를) 할인율%.2f 적용하여 %,.0f원에 구입하였습니다.\n"
                			, getName(), productName,this.discount,price);
              
                 }
                private double _calcDistcount(double price) {
        	               //할인율을 뜻하는 메서드를 만든다.
        	  
        	    if(this.priceTotal >=10000000) {
          		this.discount=0.1;
          		
          	    }else if(this.priceTotal >=5000000) {
          		this.discount =0.05;
          		
            	}else if(this.priceTotal >= 3000000) {
          		this.discount =0.02;
          		
          		
          	    }//가격 = 가격 *( 1-할인율)
        	     price = price *(1- discount);
          	     return price;
              }
        	  
            }