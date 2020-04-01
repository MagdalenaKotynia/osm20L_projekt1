package osmProject1;
import java.util.Date;

public class Examination {

	/* Attributes */
	
	private Date mDate = null;
	private boolean mGhbPresence = false;
	private double mBloodGlucoseLevel = 21.37;
	private double mUrineSugarLevel = 14.04;
	
	
	/* Constructors */
	public Examination() {}
	
	public Examination(Date d, boolean g, double b, double u) {
	
		setExam(d, g, b, u);
	}
	
	public Examination(Examination exam) {
		this(exam.mDate, exam.mGhbPresence, exam.mBloodGlucoseLevel, exam.mUrineSugarLevel);
	}
	
	/* Setters */ 
	public void setDate(Date date) {
		this.mDate=date;
	}
	public void setGhb(boolean ghb) {
		this.mGhbPresence=ghb;
	}
	public void setBloodGlucoseLevel(double bloodGlucose) {
		this.mBloodGlucoseLevel=bloodGlucose;
	}
	public void setUrineSugarLevel(double urineSugar) {
		this.mUrineSugarLevel=urineSugar;
	}
	
	public void setExam(Date date, boolean ghb, double bloodGlucose, double urineSugar) {
		this.mDate=date;
		this.mGhbPresence=ghb;
		this.mBloodGlucoseLevel=bloodGlucose;
		this.mUrineSugarLevel=urineSugar;	
	}
	
	/* Getters */
	public Date getDate() {
		return(this.mDate);
	}
	public Boolean getGhb() {
		return(this.mGhbPresence);
	}
	public Double getBloodGlucoseLevel() {
		return(this.mBloodGlucoseLevel);
	}
	public Double getUrineSugarLevel() {
		return(this.mUrineSugarLevel);
	}
	

	@Override
	public boolean equals(Object obj)
	{
		if (this==obj)
			return(true);
		if (obj==null || this.getClass()!=obj.getClass())
			return(false);
		Examination other = (Examination) obj;
		if (this.mDate.equals(other.mDate) && this.mGhbPresence==other.mGhbPresence &&  this.mBloodGlucoseLevel==other.mBloodGlucoseLevel && this.mUrineSugarLevel==other.mUrineSugarLevel)
			return(true);
		return(false);	
	}
	
	// TODO I wonder whether we should write some checkExam method
	
	/* Printing Method */
	public String toString() {
		return(" Data: " + this.mDate.toString() + " \n" + " Obecność GHB: " + this.mGhbPresence + " \n" + 
	" Poziom Glukozy we krwi: " + this.mBloodGlucoseLevel + " \n" + " Poziom cukru w moczu: " + this.mUrineSugarLevel + "\n");
	} 
	
	
}
