package exam13;
import java.util.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Exam {
	public static void main(String[] args){
		Collection c = new TreeSet();
//      Collection c = new HashSet();	참조변수가 collection 인터페이스	
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");
        
        Iterator it = c.iterator();
        
        while(it.hasNext()) {
            Object obj = it.next();
            System.out.println(obj);
        }
 //       for(int i=0; i<list.size(); i++) {
 //           Object obj = list.get(i); //hashset에는 get 없음
 //           System.out.println(obj); list에만 get
 //       }
	}
}
