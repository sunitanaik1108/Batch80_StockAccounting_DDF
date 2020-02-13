package CommonFunLibrary;

import utilities.ExcelFileUtils;

public class DriverScript {

	public static void main(String[] args) throws Exception
	{
		ExcelFileUtils exp= new ExcelFileUtils();
		int rc=exp.rowCount("Supplier");
		
		ERP_Function erp= new ERP_Function();
		
		for(int i=1;i<=rc;i++){
			
			String sname=exp.getData("Supplier", i, 0);
			String address=exp.getData("Supplier", i, 1);
			String city=exp.getData("Supplier", i, 2);
			String country=exp.getData("Supplier", i,3);
			String cperson=exp.getData("Supplier", i, 4);
			String pnumber=exp.getData("Supplier", i, 5);
			String mail=exp.getData("Supplier", i, 6);
			String mnumber=exp.getData("Supplier", i, 7);
			String note=exp.getData("Supplier", i, 8);
			
			
			erp.lunchApp("http://webapp.qedge.com/dashboard.php");
			erp.login("admin", "master");
			erp.supplier(sname, address, city, country, cperson, pnumber, mail, mnumber, note);
			erp.closeApp();
		}
		
		
	}

}
