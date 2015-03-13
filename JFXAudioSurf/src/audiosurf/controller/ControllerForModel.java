package audiosurf.controller;

public class ControllerForModel implements IControllerForModel {
	
	
	private static ControllerForModel instance = null;
	
	
	private ControllerForModel(){
		//to-do
	}
	
	public static IControllerForModel getInstance(){
		if(instance == null)
			instance = new ControllerForModel();
		return instance;
	}

}
