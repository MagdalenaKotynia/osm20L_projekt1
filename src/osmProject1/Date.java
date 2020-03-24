package osmProject1;


public class Date {

	/*Attributes of data type class, used for storage of examination date */
	private Integer mDay;
	private Integer mMonth;			
	private Integer mYear;
	private static final int NumOfDays[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/*Default class constructor*/
	public Date() {
	}
	
	/* Class constructor */
	public Date(Integer day, Integer month, Integer year) {
		if(checkDate(day, month, year)) {
		this.setDate(day, month, year);
		}
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
	public void setDate(Integer day, Integer month, Integer year) {
		if (Date.checkDate(day, month, year)) {
			this.mDay = day;
			this.mMonth = month;
			this.mYear = year;
		}
	}

	public void setDay(Integer day) {
		if(day>=1 && day<=31) {
		this.mDay=day;
		}
	}
	public void setMonth(Integer month) {
		if(month>=1 && month<=12) {
		this.mMonth=month;
		}
	}
	public void setYear(Integer year) {
		if(year>=0) {
		this.mYear=year;
		}
	}
	
	/* Method for verifying validity of given date*/
	// TODO Verify whether .intValue is necessary 
	public static boolean checkDate(Integer day, Integer month, Integer year) {
		if(year.intValue()==0 || month.intValue()<1 || month.intValue()>12 || day.intValue()<1 || day.intValue()>Date.NumOfDays[month-1]) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Comparing method*/	// TODO Might require some tweaking in order to use ArrayList methods
	public boolean equals(Date date) {
		if(date==null || this.mYear!=date.mYear || this.mMonth!=date.mMonth || this.mDay!=date.mDay) {
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
