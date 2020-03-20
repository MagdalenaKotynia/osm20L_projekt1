package osmProject1;
// TODO consider inheritance after Examination class
public class Date {

	/*Attributes of data type class, used for storage of examination date */
	private Integer mDay = 20;
	private Integer mMonth = 2;			/*I've added default values in order to make prospective debugging easier */
	private Integer mYear = 1998;
	private static final int NumOfDays[]= {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/*Default class constructor*/
	public Date() {
		/*Same as for default values. May come in handy in the near future.*/
	}
	
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
	// TODO add verifying method
	public void setDay(Integer d) {
		this.mDay=d;
	}
	public void setMonth(Integer m) {
		this.mMonth=m;
	}
	public void setYear(Integer y) {
		this.mYear=y;
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
	/*Comparing method*/		
	// TODO Not sure about this one, I have not managed to read the third lecture yet. 
	// TODO Verify whether if condition is valid (may require using static equal, doubtful but better to be safe than sorry)
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
