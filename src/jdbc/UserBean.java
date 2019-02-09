package jdbc;

public class UserBean {
	String name;
	Integer socres;
		public UserBean(String name,Integer socres)
		{
			this.name=name;
			this.socres=socres;
		}
		 public String getname() {
		        return name;
		    }
		    public void setname(String stuid) {
		        this.name = name;
		    }
		    public Integer getsocres() {
		        return socres;
		    }
		    public void setsocres(String stuid) {
		        this.socres = socres;
		    }
		    
}
