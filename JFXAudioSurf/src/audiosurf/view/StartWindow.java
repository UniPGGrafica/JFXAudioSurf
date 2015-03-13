package audiosurf.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
//import java.util.concurrent.CountDownLatch;

public class StartWindow extends Application {
	/*
	
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static StartWindow startUpWindow = null;

    public static StartWindow waitForStartUpWindow() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return startUpWindow;
    }

    public static void setStartWindow(StartWindow startUpWindow0) {
        startUpWindow = startUpWindow0;
        latch.countDown();
    }

    public StartWindow() {
        setStartWindow(this);
    }

	
    */
    
	/*
	 * COSTANTI STATICHE
	 */
	private final static String TITLE = "JFX Audiosurf";	//Titolo della finestra
	private final static String MENU_BACKGROUND = "img/nebulosa.jpg";
	private final static String STAGE_ICON = "img/ico.jpg";
	private final static String MENU_GUI_FXML = "MenuGUI.fxml";
	private final static int MIN_WIDTH = 800;
	private final static int MIN_HEIGHT = 600;
	
    private Stage primaryStage;
    private AnchorPane menuLayout;
    
 
    @Override
    public void start(Stage primaryStage){
    	
    	this.primaryStage = primaryStage;
        this.primaryStage.setTitle(TITLE);
        this.primaryStage.setMinHeight(MIN_HEIGHT);
        this.primaryStage.setMinWidth(MIN_WIDTH);
        this.primaryStage.initStyle(StageStyle.UNDECORATED);
        this.primaryStage.getIcons().add(new Image(this.getClass().getResource(STAGE_ICON).toString()));
        this.primaryStage.setFullScreen(false);
        this.primaryStage.setResizable(false);
                
        initMenuLayout();
    }
    
    /**
     * 	Initialized the menu from MenuGUI.fxml
     */
    public void initMenuLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StartWindow.class.getResource(MENU_GUI_FXML));
            
            this.menuLayout = (AnchorPane) loader.load();
            this.menuLayout.setStyle("-fx-background-image: url('" + this.getClass().getResource(MENU_BACKGROUND) + "'); -fx-background-size: cover ; -fx-background-position: center;");
            
            // Show the scene containing the menulayout.
            Scene scene = new Scene(menuLayout);            
            this.primaryStage.setScene(scene);

            //Give the controller access to the StartWindow
            SimpleController controller = loader.getController();
            controller.setStartWindow(this);
            
            this.primaryStage.show();                 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    Stage getPrimaryStage(){
    	return this.primaryStage;
    }
}
