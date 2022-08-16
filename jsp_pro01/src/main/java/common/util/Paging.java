package common.util;

import java.util.ArrayList;
import java.util.List;

//페이징처리하는 클래스 별도로 만들기.
public class Paging {
 
	private int offset; //start 시작위치
	private int limit;  //end 목록수 제한(5/10)
	private int currentPageNumber; //1 ,3
	private int nextPageNumber; //2 , 4
	private int prevPageNumber; //0 ,2
	private List<Integer> pageNumberList; //[1,2,3,4,5,,,,]
	private List<Object> pageData; //실제 '1' 데이터가 들어가게 하는것임.
	
	//생성자 ,paging 만들어주는 객체임.
	public Paging(List<Object> datas, int currentPageNumber, int limit) {
		this.offset = limit *(currentPageNumber - 1);
		this.limit= limit;
		this.currentPageNumber = currentPageNumber;
		this.nextPageNumber = currentPageNumber + 1;
		this.prevPageNumber = currentPageNumber - 1;
		int pageNum =1;
		this.pageNumberList = new ArrayList<Integer>();//객체 생성
		for(int i=0; i<datas.size();  i += limit) {
			this.pageNumberList.add(pageNum++);
				//페이지 목록번호가 나오게 하기.
			}
		int max = this.offset + this.limit;
		max = max <datas.size() ? max: datas.size();
        this.pageData = datas.subList(this.offset, max);
	}

	
	public int getOffset() {
		return offset;
	}
	
	
	public int getLimit() {
		return limit;
	}
	
	
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	
	
	public int getNextPageNumber() {
		return nextPageNumber;
	}
	

	public int getPrevPageNumber() {
		return prevPageNumber;
	}
	
	
	public List<Integer> getPageNumberList() {
             return pageNumberList;
       }
	public List<Integer> getPageNumberList(int start, int end) {
		start = start > 0 ?  start : 1;
		end = end < this.pageNumberList.size() ? end : this.pageNumberList.size();
		return pageNumberList.subList(start - 1, end); //첫번째부터 다섯번째 페이지까지
	}
	
	

	
	public List<Object> getPageData() { //list 안에 담는 객체
		return pageData;
	}
	
	public boolean hasNextPage() {
		return this.pageNumberList.contains(this.nextPageNumber);
	}

    public boolean hasPrevPage() {
    	return this.pageNumberList.contains(this.prevPageNumber);
	}
   }


