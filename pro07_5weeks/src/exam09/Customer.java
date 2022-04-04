package exam09;


//추상메서드 팀프로젝트할때는 누군가가 미리 작성을 하는 것이다. 추상메서드는 구현하자 

public abstract class Customer implements Basket, Delivery, Payment {
      private String name;
      private int age;
      private char gender;
      private double priceTotal;
      
      public Customer(String name,int age, char gender) {
    	  this.name =name;
    	  this.age = age;
    	  this.gender =gender;
    	  
      } //반환값 string 추상 메서드 사용하기.
      
   public abstract void buy(String productName, double price);
   
   @Override
public void add(String productName) {
	// TODO Auto-generated method stub
	
}
   
   
   
   //환불
   public abstract void refund(String productName);
   
   //장바구니
   public abstract boolean basket(String productName, int count);
   
   //배송조회 
   public abstract String searchDelivery(String orderCode);
   
   //포인트 적립
   public abstract int addPoint(int price);
   
   //추천 상품
   public abstract String[] suggestionProduct();
   

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
     	return gender;
		
		
   }

	public void setGender(char gender) {
		this.gender = gender;
	}

 
    public double getPriceTotal() {
    	return this.priceTotal;
    }
    
    public void setPriceTotal(double priceTotal) {
		this.priceTotal = priceTotal;
	}

  }