package exam03;

import java.util.Arrays;

public class PersonList {//person 객체를 갖고있는 다른 객체만들어주기.
	private Person[] pList;
	
	public PersonList() {
		this.pList = new Person[0];
	}
	
	public PersonList(Person[] data) {
		this.pList = data;
	}
	
	public Person get(int index) {
		return pList[index];
	}
	
	public int findIndex(String name) {
		for(int i = 0; i < this.pList.length; i++) {
			Person p = this.pList[i];
			if(p.getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean existsName(String name) {
		if(this.findIndex(name) == -1) {
			return false;
		}
		return true;
	}
	
	public void add(Person person) {// 복제              길이보다 하나더 크게 복제
		this.pList = Arrays.copyOf(this.pList, this.length() + 1);
		this.pList[this.length() - 1] = person;//길이에다가 매개변수
	}
	
	public void addFirst(Person person) {//앞에공간만들기 arraycopy
		Person[] temp = new Person[this.length() + 1];//미리 배열을 만들어놓기,this.length보다 하나더큰 공간을 만들어놓음.
		System.arraycopy(this.pList, 0, temp, 1, this.length());
//                                  0부터      1부터        배열의길이만큼      
	    this.pList = temp;
		this.pList[0] = person;
	}
	
	public void remove(int index) {
		Person[] temp = new Person[this.length() - 1];//기존배열-1
		int idx = 0;
		for(int i = 0; i < this.length(); i++) {
			if(i != index) {//인덱스와 값이 달라야만
				temp[idx++] = this.pList[i]; //깊은 복사시키기
			}  // 추가할때만!    메모장. 02:11분부터 
		}
		this.pList = temp;
	}
	
	public void remove(String name) {
		this.remove(this.findIndex(name));
	}
	
	public int length() {
		return this.pList.length;
	}
}
