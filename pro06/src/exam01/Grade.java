package exam01;

public class Grade {
	private String name;
	private double score;
	private char rank ;   //멤버변수
	private char[] rankArr =
			new char [] {'F','F','F','F','E','E','D','C','B','A','A'};
	
	public Grade(String name) {//매개변수              //이름을 초기화시키기 위해서
		this.name =name;
		//멤버변수와 매개변수 이름이 같기 떄문에 this로 구별시켜준다.
		
	}
	
	public Grade(String name,double score) {
	    this.name=name;    //this(name);은 String name 을 가르키는 것이다. 중복이 많으니까 중복을 줄이기 위해서 재사용성을 높이기 위해서..
		this.setScore(score);  //this.setScore(score);
		
		
	}
	
	public String getName() {
		return this.name;  //(this).name이 생략되어있다라고 생각하기.
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double score) {
		this.score =score;
		this._setRank(score);
		
		
		}
	public char getRank() {
		return this.rank;
	}
	
	private void _setRank(double score) {                
		this.rank =this.rankArr[(int)(this.score/10)];
		                                                          
		//switch((int)(this.score/10)) {
	//		case 10: case 9:
	//		   this.rank ='A';   break;
	//		case 8:
	//		   this.rank ='B';   break;
	//		case 7:
	//		   this.rank ='C';   break;
	//		case 6:
	//		   this.rank ='D';   break;
	//		case 5:
	//		   this.rank ='E';   break;
	//		case 4: case 3: case 2: case 1: case 0:
	//		   this.rank ='F'; 
	//	}
		
		if(this.score  <=100 && this.score>=90) {
			this.rank ='A';
			
		}else if(this.score<90&&this.score >=80) {
			this.rank='B';
			
		}else if(this.score<80&&this.score >=70) {
			this.rank='C';
			
		}else if(this.score<70&&this.score >=60) {
			this.rank='D';
			
		}else if(this.score<60&&this.score >=40) {
			this.rank='E';
			
		}else if(this.score<40) {
			this.rank='F';
		}
	}

	
	
}
