package dept.model;
//DTO(Data Transfer Object) :계층간 데이터 교환
//(vo)와 혼용하여 사용함
//로직을 가지고 있지 않은 순수한 데이터의 객체
//객체의 속성과 속성의 접근을 위한 getter,setter메소드만 있음

public class DeptDTO {
	private int deptId;
	private String deptName;
	private int mngId;
	private int locId;
	
	public int getDeptId() {
		return deptId;
	}
	
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public int getMngId() {
		return mngId;
	}
	
	public void setMngId(int mngId) {
		this.mngId = mngId;
	}
	
	public int getLocId() {
		return locId;
	}
	
	public void setLocId(int locId) {
		this.locId = locId;
	}
	
	@Override
	public String toString() {
		return "DeptDTO [deptId=" + deptId + ", deptName=" + deptName + ", mngId=" + mngId + ", locId=" + locId + "]";
	}
}
