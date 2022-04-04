package exam10.model.vo;

public class Member {

	
	private String memberld;
	private String memverPwd;
	private String memberName;
	private int age;
	private char gender;
	private String phone;
	private String email;
	
	// 기본 생성자는 매개변수가 있는 생성자가 없으면 자동생성
	
	public void changeName(String name) {
	//접근제한자//리턴타입  //메서드 //매개 변수 자료형
		memberName =name;
		
	}
	public void printName() {
		System.out.println(memberName);
		
	}
}
