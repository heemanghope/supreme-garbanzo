package member;

public class MVO {
	
	      private String id;
	      private String pwd;
	      private String name;
	      private int lnumber;
	      private int phonenumber;
	      
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getPwd() {
			return pwd;
		}
		
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getLnumber() {
			return lnumber;
		}
		
		public void setLnumber(int Lnumber) {
			this.lnumber = lnumber;
		}
		
		public void setLnumber(String Lnumber) {
			this.lnumber = Integer.parseInt(Lnumber);
		}
		
		
		public int getPhonenumber() {
			return phonenumber;
		}
		
		public void setPhonenumber(int phonenumber) {
			this.phonenumber = phonenumber;
		}

		public void setPhonenumber(String  phonenumber) {
			this.phonenumber =Integer.parseInt(phonenumber);
			
		}

			

   }

	

	

	