package game.card;

public class Gawi extends Hand {

	@Override
	public int compare(Hand otherHand) {//상대방의 패-가위일떄 기준
		// -1:패, 0무,1:승
		int res =0;
		if(otherHand instanceof Gawi) {
			res= 0;
		}else if(otherHand instanceof Bawi) {
			res = -1;
	
		}else if(otherHand instanceof Bo) {
			res= 1;
	    }
	      return res;
	      
        } 

	@Override
	public Hand cheat(Hand otherHand) {//무조건 이길 수 있게 만들기.cheat
		Hand newHand =null;
		if(otherHand instanceof Gawi) {
			newHand =new Bawi();//가위를 이길 수 있는 바위!
		
		}else if(otherHand instanceof Bawi) {
			newHand = new Bo();//바위를 이길 수 있는 보!
			
		}else if(otherHand instanceof Bo) {
			newHand = new Gawi();//보를 이길 수 있는 가위
		
	}
		return newHand;

 }
	
}

