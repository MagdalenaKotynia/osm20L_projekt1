package osmProject1;
import java.util.*;

public class AppModel {
	
	

	protected ArrayList<Patient> mList;
	//protected Patient mPatient;
	
	

	//redundancja przenies appModel do myTable
	
	public AppModel()
	{
		mList = new ArrayList<Patient>();
	}
	
	public void add(Patient patient) {
		mList.add(patient);
		
	}
	
	public void addExamToPatient(Patient patient, Examination exam)
	{
		patient.setExam(exam);
	}
	public ArrayList<Patient> getPatients(){
		return mList;
	}
	
	public Patient getPatient(int index) {
		
		return mList.get(index);
	}
	

	
	public void remove(Patient patient) {
		mList.remove(patient);

	}
	


}


	
	
	
	
	