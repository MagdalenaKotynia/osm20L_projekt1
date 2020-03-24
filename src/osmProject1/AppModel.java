package osmProject1;
import java.util.*;

public class AppModel {

	/*Random code, just for future reference*/
	/* Attributes */
	private ArrayList<Patient> mList = new ArrayList<>();

	
	public AppModel()
	{
		
	}
	
	public void addPatient(Patient p)
	{
		this.mList.add(p);
	}
	
	public void removePatient(Patient p)
	{
		this.mList.remove(p);
	}
