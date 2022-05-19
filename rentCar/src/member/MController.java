package member;



public class MController {

	
	private MDAO dao = new MDAO();
	
	public boolean rent(MVO data) {
		
		//아이디 중복체크하기
	MVO information = dao.get(data.getId());
	if(information == null) {
		boolean result = dao.add(data);
		if(result) {
		 return true;
		   }
	     }
		return false;
	      }

	public MVO login(String id, String pwd) {
		MVO information = dao.get(id);
		
		if(information !=null) {
			if(information.getId().equals(pwd)) {
				return information;
			}
		}
		return null;
	}

	public boolean update(MVO data) {
		return dao.modify(data);
	}

  public boolean remove(MVO data, String password) {
    	 if(data.getPwd().equals(password)) {
    		 return dao.remove(data);
         }else {
    		 return false;
    	 }
  }

}
