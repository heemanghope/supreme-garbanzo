import ex01.Reservation;
import ex01.car.Car;
import ex01.member.Member;

public class RentTest {

	public static void main(String[] args) {
		
		//회원가입
		Member member =new Member(); 
		member.regMember();
		
		//렌터카를 조회하기
		Car car = new Car();
		Car.checkCarInfo();
		
		//예약
		Reservation reservation = new Reservation();
        Reservation.reservationCar();
	}

}
