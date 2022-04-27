package exam11;
abstract class Unit2{
	int x,y;
	abstract void move(int x,int y);
	void stop() {System.out.println("멈춥니다.");}
	
}//인터페이스의 모든 메서드는 예외없이 public을 써야한다.
interface Fightable{
	void move(int x, int y);//public abstract 생략됨.
	void attact(Fightable f);//public abstract 생략됨.
	
}

class Fighter extends Unit2 implements Fightable{
	//오버라이딩: 조상보다 접근제어자가 좁으면 안됨.
	public void move(int x, int y) { //아무것도 안써있으면 default로 범위가 조상보다 넓어지므로 쓰면 안됨.private너무 좁음
		System.out.println("["+x+","+y+"]로 이동");
	}
	public void attact(Fightable f) {
		System.out.println(f+"를 공격");
	}
	
	//싸울수있는 상대를 불러온다.
	Fightable getFightable(){
		Fighter f = new Fighter();
		return f;
	}
}
public class FighterTest{
	
public static void main(String[] args) {
	Fighter f = new Fighter();
	Fightable f2 = f.getFightable();

//   Unit2 f = new Fighter(); //Unit2에는 attack()이 없으므로 호출 불가
//	Unit2 u = new Fighter();
//	Fightable f = new Fighter();
//	u.move(100,200);
//	u.attack(new Fighter()); //Unit2에는 attack()이 없으므로 호출 불가
//	u.stop();
	
	
//	f.move(100,200);
//	f.attact(new Fighter());
	//f.stop(); fightable에 stop()이없어서 호출불가
}

}

