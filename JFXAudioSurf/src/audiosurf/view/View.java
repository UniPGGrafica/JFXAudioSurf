package audiosurf.view;

public class View implements IView {
	
private static View instance = null;
	
	//private StartWindow startWindow = null;
	
	private View(){
		//to-do
	}
	
	public static IView getInstance(){
		if(instance == null)
			instance = new View();
		return instance;
	}

	public void openStartWindow(){
		new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(StartWindow.class);
            }
        }.start();
	}

	
}
