package osmProject1;



public class Patient {

	/*Attributes of data type class */
	private String mName = "Jan";
	private String mSurname = "Kowalski";
	private String mPESEL = "99033000987";
	private String mInsurance = "NFZ";			// TODO Consider using Enum for Insurance and Gender ---- extra-curricular xD
	private String mGender = "Mężczyzna";
	private Examination mExam = null;			
	

	public Patient() {}
	
	public Patient(String n, String s, String p, String i, String g, Examination e) {
		setPatient(n, s, p, i, g, e);
	}
	public Patient(Patient patient) {
		this(patient.mName, patient.mSurname, patient.mPESEL, patient.mInsurance, patient.mGender, patient.mExam);
	}
	
	/*Setters*/
	public void setName(String n) {
		this.mName=n;
	}
	public void setSurname(String s) {
		this.mSurname=s;
	}
	public void setPESEL(String p) {
		this.mPESEL=p;
	}
	public void setInsurance(String i) {
		this.mInsurance=i;
	}
	public void setGender(String g) {
		this.mGender=g;
	}
	public void setExam(Examination e) {
		this.mExam=e;
	}
	public void setPatient(String n, String s, String p, String i, String g, Examination e) {
		this.mName=n;
		this.mSurname=s;
		this.mPESEL=p;
		this.mInsurance=i;
		this.mGender=g;
		this.mExam=e;
	}
	
	/*Getters*/
	public String getName() {
		return(this.mName);
	}
	public String getSurname() {
		return(this.mSurname);
	}
	public String getPESEL() {
		return(this.mPESEL);
	}
	public String getInsurance() {
		return(this.mInsurance);
	}
	public String getGender() {
		return(this.mGender);
	}
	public Examination getExam() {
		return(this.mExam);
	}
	
	/* Method for verifying validity of given patient ---- may not be necessary */
	public static boolean checkPatient(String n, String s, String p, String i, String g) {
		// TODO Consider if condition for now it is not very useful and add condition for mExam
		if(n.isBlank() || s.isBlank() || p.length()!=11 || i.isBlank() || g.isBlank()) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Comparing method*/							// TODO Might require some tweaking in order to use ArrayList methods
	public boolean equals(Patient p) {
		if(p==null || this.mName!=p.mName || this.mSurname!=p.mSurname || this.mPESEL!=p.mPESEL || 
				this.mInsurance!=p.mInsurance ||this.mGender!=p.mGender || this.mExam!=p.mExam) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Printing method*/
	public String toString() {
		return("Imię: " + this.mName +" Nazwisko: " + this.mSurname + " PESEL: " + this.mPESEL + " Ubezpieczenie: " + 
	this.mInsurance + " Płeć: " + this.mGender);
	}
	
	}


