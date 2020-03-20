package osmProject1;


public class Patient {

	/*Attributes of data type class */
	private String mName = "Jan";
	private String mSurname = "Kowalski";
	private String mPESEL = "99033000987";
	private String mInsurance = "NFZ";
	private String mGender = "Mężczyzna";
	

	public Patient() {}
	
	public Patient(String n, String s, String p, String i, String g) {
		setPatient(n, s, p, i, g);
	}
	public Patient(Patient patient) {
		this(patient.mName, patient.mSurname, patient.mPESEL, patient.mInsurance, patient.mGender);
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
	public void setPatient(String n, String s, String p, String i, String g) {
		this.mName=n;
		this.mSurname=s;
		this.mPESEL=p;
		this.mInsurance=i;
		this.mGender=g;
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
	
	/* Method for verifying validity of given patient*/
	public static boolean checkPatient(String n, String s, String p, String i, String g) {
		// TODO Consider if condition
			return(false);
		
	}
	/*Comparing method*/
	public boolean equals(Patient p) {
		if(p==null || this.mName!=p.mName || this.mSurname!=p.mSurname || this.mPESEL!=p.mPESEL || this.mInsurance!=p.mInsurance ||this.mGender!=p.mGender) {
			return(false);
		}else {
			return(true);
		}
	}
	/*Printing method*/
	public String toString() {
		return("Imię: " + this.mName +"Nazwisko: " + this.mSurname + "PESEL: " + this.mPESEL + "Ubezpieczenie: " + 
	this.mInsurance + "Płeć: " + this.mGender);
	}
	
	}


