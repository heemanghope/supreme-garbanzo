package locs.service;
//enum 열거형 객체만들기
public enum LOCS_SERVICE_STATUS {
	SUCCESS(1, "성공"), FAILED(0, "실패"),
	LOCS_ID_DUPLICATED(-1, "부서 ID 중복 오류"),
	POS_ID_NOT_EXISTS(-2, "코드 존재하지 않음"),
	CITY_ID_NOT_EXISTS(-3, "지역 ID 존재하지 않음"),
	STATE_ID_NOT_EXISTS(-4,"부서 ID 존재하지 않음"),
	COUNTRY_ID_NOT_EXISTS(-5,"지역 ID 존재하지 않음");
	
	public final int value; //접근제한자
	public final String msg;
	
	LOCS_SERVICE_STATUS(int value, String msg) {
		this.value = value;
		this.msg = msg;
	}
	
}