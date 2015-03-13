package audiosurf.model;


public class Model implements IModel {
	
private static Model instance = null;
	
	
	private Model(){
		//to-do
	}
	
	public static IModel getInstance(){
		if(instance == null)
			instance = new Model();
		return instance;
	}
}
