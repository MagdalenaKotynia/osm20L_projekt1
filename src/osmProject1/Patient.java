package osmProject1;

public class Patient {

	/*Attributes of data type class */
	private String mName = null;
	private String mSurname = null;
	private String mPESEL = null;
	private String mInsurance = null;			
	private String mGender = null;
	private Examination mExam = null;	
	
	

	public Patient() {}
	
	public Patient(String name, String surname,String gender, String pesel, String insurance, Examination exam) {
		setPatient(name, surname, gender, pesel, insurance, exam);
	}
	public Patient(Patient patient) {
		this(patient.mName, patient.mSurname, patient.mGender, patient.mPESEL, patient.mInsurance, patient.mExam);
	}
	
	/*Setters*/
	public void setName(String name) {
		this.mName=name;
	}
	public void setSurname(String surname) {
		this.mSurname=surname;
	}
	public void setPESEL(String pesel) {
		this.mPESEL=pesel;
	}
	public void setInsurance(String insurance) {
		this.mInsurance=insurance;
	}
	public void setGender(String gender) {
		this.mGender=gender;
	}
	public void setExam(Examination exam) {
		this.mExam=exam;
	}
	public void setPatient(String name, String surname, String gender, String pesel, String insurance, Examination exam) {
		this.mName=name;
		this.mSurname=surname;
		this.mPESEL=pesel;
		this.mInsurance=insurance;
		this.mGender=gender;
		this.mExam=exam;
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
	public boolean checkPatient() {
		// TODO Consider if condition for now it is not very useful and add condition for mExam
		if(this.mName.isBlank() || isAlphabet(this.mName)==false || this.mSurname.isBlank() || isAlphabet(this.mSurname)==false ||
				this.mPESEL.length()!=11 ||isNumeric(this.mPESEL) == false || this.mInsurance.isBlank() || this.mGender.isBlank()) 
		{
			return(false);
		}
		else 
		{
			return(true);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this==obj)
			return true;
		if (obj==null || this.getClass()!=obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (this.mPESEL==null) {
			if (other.mPESEL!=null)
				return(false);
		}
		else if (!this.mPESEL.equals(other.mPESEL)) {
			return(false);}
		else {
			if(this.mSurname.equals(other.mSurname) || this.mName.equals(other.mName)) {
		return(false);
			}
		}
		return(true);
	}
	
	/*Printing method*/
	public String toString() {
		return("Imie: " + this.mName +" Nazwisko: " + this.mSurname + " Plec: " + this.mGender + " PESEL: " + this.mPESEL + " Ubezpieczenie: " + 
	this.mInsurance );
	}

	public static boolean isNumeric(String str)
	{
		for (char c : str.toCharArray())
		{
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}
	
	public static boolean isAlphabet(String str)
	{
		for (char c: str.toCharArray())
		{
			if (!Character.isAlphabetic(c))
				return false;
		}
		return true;
	}
		
	
	
	
	
	

	
	}


