package CommonFunLibrary;

public class Dumyyyy {

	public static void main(String[] args) throws Exception {
		ERP_Function ef= new ERP_Function();
		ef.lunchApp("http://webapp.qedge.com/login.php");
		ef.login("admin", "master");
		ef.supplier("aaaaa", "bbb", "city", "country", "cperson", "pnumber", "mail", "mnumber", "note");
	}
	

}
