package exam04;

import java.util.Arrays;

public class GradeList {
	private Grade[] gList;
	
	public GradeList() {
		this.gList = new Grade[0];//비어있는 배열을 만들어놓음.
	}
	
	// 추가
	public void add(Grade grade) {
		this.gList = Arrays.copyOf(this.gList, length() + 1);
		this.gList[length() - 1] = grade;//외부로 받은 grade객체를넣어주기.
	}
	
	public void add(String name) {
		Grade g = new Grade(name);
		this.add(g);//객체 추가시키기
	}
	
	public void add(String name, double score) {
		Grade g = new Grade(name, score); //추가하기
		this.add(g);//내부에 추가시키기
	}
	
	// 수정
	//     - 수정 할 과목을 찾아서 과목명을 수정 -> 변경전 과목명, 변경후 과목명
	//     - 수정 할 과목을 찾아서 점수를 수정 -> 찾을 과목명, 수정할 점수
	//     - 수정 할 과목을 찾아서 과목과 점수를 수정 -> 변경전 과목명, 변경후 과목명, 수정할 점수
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명을 수정
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 점수를 수정
	//     - 수정 할 데이터가 저장되어 있는 인덱스를 지정하여 과목명과 점수를 수정
	public void update(String src, String dest) {//source, destination
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setName(dest);
		}//Grade data =this.gList[i];
		//if(data.getName().equals(src)) {
		//idx=i;
		//break;
		//this.gList[idx].setName(dest); ---src를 dest으로 바꾸어라.
	}
	
	public void update(String src, double score) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setScore(score);
		}//Grade data =this.gList[i];
		//if(data.getName().equals(src)) {
		//idx=i;
		//break;
		//this.gList[idx].setName(dest);
	}
	
	public void update(String src, String dest, double score) {
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx].setName(dest);
			this.gList[idx].setScore(score);
		}
	}
	
	public void update(String src, Grade dest) {//과목 객체를 받아서 Grade dest
		int idx = this.findIndex(src);
		if(idx >= 0) {
			this.gList[idx] = dest;
		}
	}
	
	public void update(int index, String name) {
		if(_validIndex(index)) {
			this.gList[index].setName(name);
		}//인덱스에 맞추어서!..//배열의 크기는 한정되어있는데 -1(음수값)이나 큰 값(초과)이 나오면 안됩니당.
	}//
	
	public void update(int index, double score) {
		if(_validIndex(index)) {
			this.gList[index].setScore(score);
		}
	}
	
	public void update(int index, String name, double score) {
		if(_validIndex(index)) {
			this.gList[index].setName(name);
			this.gList[index].setScore(score);
		}
	}
	
	public void update(int index, Grade grade) {
		if(_validIndex(index)) {
			this.gList[index] = grade;
		}
	}
	
	// 삭제
	public void remove(String name) {
		int index = findIndex(name);
		if(index >= 0) {//삭제는 기존의 배열보다 작은배열을 만들어준다.
			_remove(index);
		}
	}
	
	public void remove(int index) {
		if(_validIndex(index)) {
			_remove(index);
		}
	}
	
	private void _remove(int index) {
		int idx = 0;
		Grade[] temp = new Grade[length() - 1];
		for(int i = 0; i < length(); i++) {
			if(i != index) {
				temp[idx++] = this.gList[i];
			}
		}
		this.gList = temp;
	}
	
	// 조회
	//     - 과목명으로 점수 조회
	//     - 인덱스로 과목명 조회
	//     - 인덱스로 과목명, 점수 조회
	public double getScore(int index) {
		return this.gList[index].getScore();
	}
	
	public double getAvg() {
		// 과목 배열에 있는 점수들의 평균
		return getTotal() / length();
	}
	
	public double getTotal() {
		// 과목 배열에 있는 모든 점수들의 합
		double tot = 0;
		for(int i = 0; i < length(); i++) {   //참조값.setName
			tot += this.gList[i].getScore(); 
		}
		return tot;
	}
	
	public String[] getUnder() {
		// 100점 만점을 기준으로 40점 미만에 해당하는 과목 정보를 구함
		return getUnder(40);//40점미만의 과목 구하기.
	}
	
	public String[] getUnder(double score) {
		// 제시한 score 미만에 해당하는 과목 정보를 구함
		String[] result = new String[0];
		
		for(int i = 0; i < length(); i++) {
			if(this.gList[i].getScore() < score) {
				result = Arrays.copyOf(result, result.length + 1);
				result[result.length - 1] = this.gList[i].getName();
			}
		}
		return result;
	}
	
	public String getTop() {
		// 최고 득점 과목을 구함
		Grade high = this.gList[0];
		
		for(int i = 1; i < length(); i++) {
			if(high.getScore() < this.gList[i].getScore()) {
				high = this.gList[i];
			}
		}
		return high.getName();
	}
	
	public String[] getTop(int count) {        //정렬 큰거 순서대로 하기
		// 최고 득점 과목을 count 만큼 구함
		Grade[] tArr = this.gList.clone();//클론 만들기
		//일단은 같은 위치에 있는 것을 집어넣어라,1번 인덱스는 앞번호보다 작은것을집어넣어라.두번째값 찾기위해서 비교하기
		for(int i = 0; i < tArr.length - 1; i++) {//앞에서 만든거에다가 변수명만 바꿔서
			for(int j = i + 1; j < tArr.length; j++) {// ***tArr.length가 더큰것 이상인것***
				if(tArr[i].getScore() < tArr[j].getScore()) {
					Grade temp = tArr[j];
					tArr[j] = tArr[i];
					tArr[i] = temp;
				}
			}
		}
		
		Grade[] high = Arrays.copyOf(tArr, count);//3개만 짤라서 크기순으로 정렬한다.
		
		String[] result = new String[count];
		for(int i = 0; i < high.length; i++) {
			result[i] = high[i].getName();
		}
		
		return result;
	}
	
	public String getBottom() {
		// 최저 득점 과목을 구함
		Grade low = this.gList[0];
		
		for(int i = 1; i < length(); i++) {
			if(low.getScore() > this.gList[i].getScore()) {
				low = this.gList[i];
			}
		}
		return low.getName();
	}
	
	public String[] getBottom(int count) {
		// 최저 득점 과목을 count 만큼 구함
		Grade[] tArr = this.gList.clone();
		
		for(int i = 0; i < tArr.length - 1; i++) {
			for(int j = i + 1; j < tArr.length; j++) {
				if(tArr[i].getScore() > tArr[j].getScore()) {
					Grade temp = tArr[j];
					tArr[j] = tArr[i];
					tArr[i] = temp;
				}
			}
		}
		
		Grade[] low = Arrays.copyOf(tArr, count);
		
		String[] result = new String[count];
		for(int i = 0; i < low.length; i++) {
			result[i] = low[i].getName();
		}
		
		return result;
	}
	
	public double getScore(String name) {
		int idx = findIndex(name);
		if(idx >= 0) {
			return this.gList[idx].getScore();
		}
		return 0;//없으면 0이다.
	}
	
	public String getName(int index) {
		if(_validIndex(index)) {
			return this.gList[index].getName();
		}
		return null;//잘못지정했다.
	}
	
	public Grade getGrade(int index) {
		if(_validIndex(index)) {
			Grade data = new Grade(this.gList[index].getName(), this.gList[index].getScore());
			return data;////객체의 깊은 복사 아래.grade객체//새로운 객체를 만든다.
			//외부에서 수정하는것을 원치 않는다.하면
		}
		return null;
	}
	
	public int findIndex(String name) {
		for(int i = 0; i < length(); i++) {
			Grade data = this.gList[i];
			if(data.getName().equals(name)) {
				return i;
			}
		}
		return -1;//못찾았늘 경우
	}
	
	public int length() {
		return this.gList.length;
	}
	
	
      //정렬 기능 분리하기
	// 기존에 정렬과 관련된 기능은 다음의 sort 를 사용하는 것으로 변경한다.
	public void sort() {// 매개변수가 없는 것 
		// 오름차순으로 정렬
		for(int i = 0; i < length() - 1; i++) {
			for(int j = i + 1; j < length(); j++) {
				if(this.gList[i].getScore() > this.gList[j].getScore()) {
					Grade temp = this.gList[j];
					this.gList[j] = this.gList[i];
					this.gList[i] = temp;
				}
			}
		}
	}
	
	public void sort(boolean descending) {//매개변수가 있는 변수 //내림차순이면 true
		// 내림차순으로 정렬
		if(descending) {
			for(int i = 0; i < length() - 1; i++) {
				for(int j = i + 1; j < length(); j++) {
					if(this.gList[i].getScore() < this.gList[j].getScore()) {
						Grade temp = this.gList[j];
						this.gList[j] = this.gList[i];
						this.gList[i] = temp;
					}
				}
			}
		} else {
			sort();//오름차순이면 false
		}
	}
	
	
	// 유효한 범위의 인덱스인지 확인하는 메서드
	private boolean _validIndex(int index) {
		return (index >= 0 && index < length());
	}
}

//private boolean
