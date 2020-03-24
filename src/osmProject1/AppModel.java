package osmProject1;
import java.util.*;

public class AppModel {

	private ArrayList<Patient> mList = new ArrayList<>();
	private Patient mPatient = null;


	
	public AppModel()
	{
		
	}
	
	
	public void createPatient(String name, String surname, String pesel, String insurance, String gender, Examination exam )
	{
		
		
		addPatient(new Patient(name, surname, pesel, insurance, gender, exam));
		
	}
	
	
	
	public void addPatient(Patient patient)
	{
		this.mList.add(patient);
	}
	
	
	public void removePatient(Patient patient)
	{
		
		this.mList.remove(patient);
	}
	
	/*czy dodawac podobne do tej niej metody, czy moge siegac po nie z Patient?*/
	
	public void setPESEL(String pesel)
	{
		this.mPatient.setPESEL(pesel);
	}
	
	
	
	
	
	/*czy dodawac metody getName, getSurname itp itd
	 * czy definiowac wszystkie atrybuty pacjenta i badania znowu?
	 * czy do metody createpatient potem przekazywac dane z getPesel itp.?
	 */


}
