package audiosurf.controller;

public class ControllerForView implements IControllerForView {
	
private static ControllerForView instance = null;
	
	
	private ControllerForView(){
		//to-do
	}
	
	public static IControllerForView getInstance(){
		if(instance == null)
			instance = new ControllerForView();
		return instance;
	}


}
