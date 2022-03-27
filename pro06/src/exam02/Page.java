package exam02;

	public class Page {
		private int pageNumber;			// 페이지 번호
		private int limitPageNumber;	// 최대 페이지 번호
		
		public Page(int limitPageNumber) {//페이지번호가 0이어도 생성하고 동작하는데 문제없음
			this.limitPageNumber = limitPageNumber;
		}
		
		public Page(int pageNumber, int limitPageNumber) {
			this.pageNumber = pageNumber;//페이지넘버는 초기화 하지않았지만.
			this.limitPageNumber = limitPageNumber; //기준점을 만들어놔야한다. 매개변수가 있는 생성자를 만들어야한다.
		}                                               //리미트번호만 생성자를 만들어놓음
		
		
		public int getPageNumber() {
			return this.pageNumber;  //현재페이지를 알아볼수 있는 클래스
		}
		
		public int getLimitPageNumber() {
			return this.limitPageNumber;
		}
		
		public void movePage(int pageNumber) {
			if(pageNumber <= limitPageNumber && pageNumber >= 1) {
				this.pageNumber = pageNumber;
			} else {
				System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
			}
		}
		
		public void nextPage() {
			if(!existsNextPage()) {
				System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
			} else {
				this.pageNumber++;
			}
		}
		
		public void nextPage(int count) {
			if(!existsNextPage(count)) {//이전의 페이지를 넘길 수 있는지 없는지 확인을 하고
				System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
			} else {
				this.pageNumber += count;//이후로 넘기기
			}
		}
		
		public void prevPage() {
			if(!existsPrevPage()) {
				System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
			} else {
				this.pageNumber--;
			}
		}
		
		public void prevPage(int count) {
			if(!existsPrevPage(count)) {  //이전의 페이지를 넘길 수 있는지 없는지 확인을 하고
				System.out.println("더 이상 책의 페이지를 넘길 수 없습니다.");
			} else {
				this.pageNumber -= count;//이전으로 넘기기
			}  //넘길수 있으면 넘기도록해야한다.
		}
		
		public boolean existsNextPage() {
			if(pageNumber + 1 <= limitPageNumber) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean existsNextPage(int count) {
			if(pageNumber + count <= limitPageNumber) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean existsPrevPage() {
			if(pageNumber - 1 >= 1) {
				return true;
			} else {
				return false;
			}
		}
		
		public boolean existsPrevPage(int count) {
			if(pageNumber - count >= 1) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	//클래스 만들기.
//필요한 메서드,필요한 매개변수만들고, 생성자 만들고..
