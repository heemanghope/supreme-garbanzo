package exam02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class Sample03 {

	public static void main(String[] args) {
		Set<Integer> hashSet = new HashSet<Integer>();
		Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
		Set<Integer> treeSet = new TreeSet<Integer>();
   
		
		hashSet.add(300); hashSet.add(900); hashSet.add(500);
		hashSet.add(400); hashSet.add(200); hashSet.add(700);
		hashSet.add(200); hashSet.add(600); hashSet.add(800);
		
		
		
		linkedHashSet.add(300); linkedHashSet.add(900); linkedHashSet.add(500);
		linkedHashSet.add(400); linkedHashSet.add(100); linkedHashSet.add(700);
		linkedHashSet.add(200); linkedHashSet.add(600); linkedHashSet.add(800);
	    //순서대로
	
		treeSet.add(300); treeSet.add(900); treeSet.add(500);
		treeSet.add(400); treeSet.add(100); treeSet.add(700);
		treeSet.add(200); treeSet.add(600); treeSet.add(800);
		//오름차순
		
	    System.out.println(hashSet);
	    System.out.println(linkedHashSet);
	    System.out.println(treeSet);
	    
	    Iterator<Integer> iter = hashSet.iterator();
	    while(iter.hasNext()) {
	    	System.out.print(iter.next() + "\t");
	    }
	    System.out.println();
	    
	    ListIterator<Integer> lter = (new ArrayList<Integer>(hashSet)).listIterator(hashSet.size());
	    while(lter.hasPrevious()) {//이전의 기록을 보기 위해서 이전  hashSetIterator리스트를 써주기.
	    	System.out.print(lter.previous() +"\t");
	    	
	    }
	    System.out.println();
	}

}
