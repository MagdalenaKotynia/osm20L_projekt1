package osmProject1;

public class Examination {

	/* Attributes */
	private Date mDate = null;
	private Boolean mGhbPresence = false;
	private Double mBloodGlucoseLevel = 21.37;
	private Double mUrineSugarLevel = 14.04;
	
	
	/* Constructors */
	public Examination() {}
	
	public Examination(Date d, Boolean g, Double b, Double u) {
	
		setExam(d, g, b, u);
	}
	
	public Examination(Examination exam) {
		this(exam.mDate, exam.mGhbPresence, exam.mBloodGlucoseLevel, exam.mUrineSugarLevel);
	}
	
	/* Setters */ 
	public void setDate(Date d) {
		this.mDate=d;
	}
	public void setGhb(Boolean g) {
		this.mGhbPresence=g;
	}
	public void setBloodGlucoseLevel(Double b) {
		this.mBloodGlucoseLevel=b;
	}
	public void setUrineSugarLevel(Double u) {
		this.mUrineSugarLevel=u;
	}
	
	public void setExam(Date d, Boolean g, Double b, Double u) {
		this.mDate=d;
		this.mGhbPresence=g;
		this.mBloodGlucoseLevel=b;
		this.mUrineSugarLevel=u;	
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
	
	/* Comparing method */							// TODO Remember about ArrayList
	public boolean equals(Examination e) {
		if(e!=null && this.mDate.equals(e.mDate) && this.mGhbPresence==e.mGhbPresence && this.mBloodGlucoseLevel==e.mBloodGlucoseLevel 
				&& this.mUrineSugarLevel==e.mUrineSugarLevel) {
			return(true);
		}else {
			return(false);
		}
	}
	
	// TODO I wonder whether we should write some checkExam method
	
	/* Printing Method */
	public String toString() {
		return(" Data: " + this.mDate.toString() + " \n" + " Obecność GHB: " + this.mGhbPresence + " \n" + 
	" Poziom Glukozy we krwi: " + this.mBloodGlucoseLevel + " \n" + " Poziom cukru w moczu: " + this.mUrineSugarLevel + "\n");
	} 
	
	
}
