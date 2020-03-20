package osmProject1;

public class Date {

	/*Attributes of data type class, used for storage of examination date */
	private Integer mDay;
	private Integer mMonth;
	private Integer mYear;
	private static final int NumOfDays[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/* Class constructor */
	public Date(Integer d, Integer m, Integer y) {
		
		this.setDate(d, m, y);
		
	}

	/* Copying constructor */
	public Date(Date date) {
	
	this(date.mDay, date.mMonth, date.mYear);
		
	}
	
	
	/*Getters*/
	public Integer getDay() {
		return(this.mDay);
	}
	
	public Integer getMonth() {
		return(this.mMonth);
	}
	public Integer getYear() {
		return(this.mYear);
	}
	
	/*Setters*/
	public void setDate(Integer d, Integer m, Integer y) {
		if (Date.checkDate(d, m, y)) {
			this.mDay = d;
			this.mMonth = m;
			this.mYear = y;
		}
	}
	
	/* Method for verifying validity of given date*/
	// TODO Verify whether .intValue is necessary 
	public static boolean checkDate(Integer d, Integer m, Integer y) {
		if(y.intValue()==0 || m.intValue()<1 || m.intValue()>12 || d.intValue()<1 || d.intValue()>Date.NumOfDays[m-1]) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Comparing method*/		// TODO Not sure about this one, I have not managed to read the third lecture yet. 
	public boolean equals(Date d) {
		if(d==null || this.mYear!=d.mYear || this.mMonth!=d.mMonth || this.mDay!=d.mDay) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Printing Method*/
	public String toString() {
		return(this.mDay + "." + this.mMonth + "." + this.mYear);
	}
	
}
