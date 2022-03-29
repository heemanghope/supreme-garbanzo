package exam02;

public class Main {

	public static void main(String[] args) {
		Student s = new Student("홍길동");
        s.setAge(16);
		s.setGender('M');
		s.setClassLevel(1);
		s.setClassRoom(2);
		System.out.println(s.getName());
		
        Teacher t =new Teacher("박주성");
        t.setAge(30);
		t.setGender('M');
		t.setClassLevel(1);
		t.setClassRoom(2);
		t.setSubject("수학");
		System.out.println(t.getName());
		
		// 학생과 선생님 클래스에서 getGender() 라고 할 때 학생은 남학생, 여학생으로 반환되도록 하고
		// 선생님은 남선생님, 여선생님으로 반환되도록 하기 위해 코드를 수정하시오.
        System.out.println(s.getGender());
        System.out.println(t.getGender());
        
	//어떠한 클래스이건 toString이 다있음.
        
        System.out.println(s);
        System.out.println(t);
        
        
        
        Student s1 = new Student("홍길동");
        s.setAge(17);
		s.setGender('M');
		s.setClassLevel(2);
		s.setClassRoom(4);
		System.out.println(s.getName());
		
		
		System.out.println(s.equals(s1)); //객체가 포함하고 있는 값이 같냐는 것을 보느 것이다. //문자열!
		
	}

}
