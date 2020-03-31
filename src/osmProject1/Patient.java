package osmProject1;

import java.util.ArrayList;

public class Patient {

	/*Attributes of data type class */
	private String mName = null;
	private String mSurname = null;
	private String mPESEL = null;
	private String mInsurance = "NFZ";			// TODO Consider using Enum for Insurance and Gender ---- extra-curricular xD
	private String mGender = "Mezczyzna";
	private Examination mExam = null;	
	private ArrayList mPatientAtributes = null;
	

	public Patient() {}
	
	public Patient(String name, String surname, String patient, String insurance, String gender, Examination exam) {
		setPatient(name, surname, patient, insurance, gender, exam);
	}
	public Patient(Patient patient) {
		this(patient.mName, patient.mSurname, patient.mPESEL, patient.mInsurance, patient.mGender, patient.mExam);
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
	public void setPatient(String name, String surname, String patient, String insurance, String gender, Examination exam) {
		this.mName=name;
		this.mSurname=surname;
		this.mPESEL=patient;
		this.mInsurance=insurance;
		this.mGender=gender;
		this.mExam=exam;
	}
	public void setPatientAtributesList(Patient patient) //add get, czy po prostu atrybuty??
	{
		this.mPatientAtributes.add(this.getName());
		this.mPatientAtributes.add(this.getSurname());
		this.mPatientAtributes.add(this.getGender());
		this.mPatientAtributes.add(this.getPESEL());
		this.mPatientAtributes.add(this.getInsurance());
		this.mPatientAtributes.add(this.getExam());
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
		else if (!this.mPESEL.equals(other.mPESEL))
			return(false);
		return(true);
	}
	
	/*Printing method*/
	public String toString() {
		return("Imie: " + this.mName +" Nazwisko: " + this.mSurname + " PESEL: " + this.mPESEL + " Ubezpieczenie: " + 
	this.mInsurance + " Plec: " + this.mGender);
	}
	
	public ArrayList getPatientAtributes()
	{
		return(this.mPatientAtributes);
	}
	
	//funkcja ktora bedzie zwracala ArrayList atrybutow
	
	}


