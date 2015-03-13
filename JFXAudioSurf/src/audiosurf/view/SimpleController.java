package audiosurf.view;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;


public class SimpleController {
	
	
	/*
	 * 	Variabili degli oggetti del file FXML
	 */
	
	//ToolBar
	@FXML
	private ToolBar upToolBar;
	
	//Button
	@FXML
	private Button creditsButton;
	@FXML
	private Button exitButton;
	@FXML
	private Button fullScreenButton;	
	
	/*
	 * Variabili per memorizzare le coordinate del muse
	 * Spostamento finestra dalla ToolBar superiore
	 */
	private double deltaMouseX, deltaMouseY;
	private boolean isDraggable = true;

	
	//Reference to the StartWindow
		private StartWindow startWindow;
		
	/*
	 * METODI DI UTILITA'
	 */
		
	/*
	 * E' chiamato dall'applicazione principale per referenziare se stesso
	 * 
	 * @param startWindow
	 */
	public void setStartWindow(StartWindow startWindow){
		this.startWindow = startWindow;
	}
	
	/*
	 * METODI PER FXML
	 */
	
	/*
	 * Metodo per settare lo stage tra 
	 * 	 FULLSCREEN ---- WINDOW MODE
	 * cambiando nome al "text" del bottone
	 */
	
	@FXML
	public void handleFullScreenButton() {
    	if(!startWindow.getPrimaryStage().isFullScreen()) {
    		isDraggable = false;
    		startWindow.getPrimaryStage().setFullScreen(true);
    		fullScreenButton.setText("Window Mode");
    		fullScreenButton.setMinWidth(180);
    	}
    	else {
    		isDraggable = true;
    		startWindow.getPrimaryStage().setFullScreen(false);
    		fullScreenButton.setText("FullScreen");
    		fullScreenButton.setMinWidth(140);
    	}
    	
    }
	
	@FXML
	public void handleExitButton() {
		startWindow.getPrimaryStage().close();
    }
	
	
	/*
	 * Metodo per la memorizzazione delle coordinate del mouse per spostamento dello Stage
	 */
	@FXML
	public void handleUpToolBarPressed(MouseEvent event) {
		if(isDraggable){
			deltaMouseX =  startWindow.getPrimaryStage().getX() - event.getScreenX();
			deltaMouseY = startWindow.getPrimaryStage().getY() - event.getScreenY();
		}
    }
	/*
	 * Aggiorna la posizione dello Stage alle nuove coordinate 
	 * tramite il drag della finestra dalla ToolBar
	 */
	@FXML
	public void handleUpToolBarDragged(MouseEvent event) {
		if(isDraggable){
			startWindow.getPrimaryStage().setX(event.getScreenX() + deltaMouseX);
			startWindow.getPrimaryStage().setY(event.getScreenY() + deltaMouseY);
		}
    }
	
	
	
}