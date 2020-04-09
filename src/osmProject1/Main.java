package osmProject1;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AppView view = new AppView();
				AppModel model = new AppModel();
				AppController ctrl = new AppController(view,model);
				
			}
		});

	}

}
 