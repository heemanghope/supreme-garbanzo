package exam13;

import java.util.ArrayList;
class Tv{}
class Audio{}

public class GenericTest {
    public static void main(String args[]) {
    	//ArrayList list = new ArrayList(); 
    	ArrayList<Tv> list = new ArrayList<Tv>();
    	list.add(new Tv());
    	
    	
    	//Integer i = (Integer)list.get(2); list get2 는 오브젝트 반환하는 타입
    	System.out.println(list);
    	
    	
    }
}
