package osmProject1;



public class Main {

	public static void main(String[] args) {
		
		AppView view = new AppView();
		AppModel model = new AppModel();
		AppController ctrl = new AppController(view,model);
		MyActionListener testListener = new MyActionListener();
	}

}
 //commit check