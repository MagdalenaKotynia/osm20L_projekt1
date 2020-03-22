package osmProject1;
import java.util.*;

public class AppModel {

	private ArrayList<Patient> mList = new ArrayList<>();

	
	public AppModel()
	{
		
	}
	
	
	public void addPatient(String n, String s, String p, String i, String g, Examination e){
		e=null;
		this.mList.add(new Patient(n, s, p, i, g, e));
	}
	
	public void removePatient(int index){
		this.mList.remove(index);
	}

}
