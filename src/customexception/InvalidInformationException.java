package customexception;


public class InvalidInformationException extends Exception{
		
		private String report;
		
	public InvalidInformationException(String r) {
		report = r;
	}
	
	public String getMessage() {
		
		String mssg = "";
		
		if(report.equals(null) || report.equals("")) {
			mssg += " You cannot create an account if you havent enter enough information";
		}
		return mssg;
	}
}
