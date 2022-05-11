package exam01;

public class MyException {
    public void exceptionThrows() throws Exception {
    	exceptionRun();
    }
    
    public void exceptionNonThrows() {
    	try {
    	      exceptionRun();
    	}catch(Exception e) {
    		System.out.print("에러 처리함.");
    		e.printStackTrace();//어디에서 에러가?출력만
    	}
    }
    
    private void exceptionRun() throws Exception{
    	throw new UserDefineException("사용자 정의 예외처리가 발생하였습니다.");
    }
 
}
