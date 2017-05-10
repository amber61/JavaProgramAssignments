import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ButtonDemo extends Application {
   Text text = new Text(50, 50, "JavaFX Programming");
   
   public static void main(String[] args){
	   Application.launch(args);
   }
   
   @Override
   public void start(Stage primaryStage){
	    Scene scene = new Scene(getPane(), 450, 200);
		primaryStage.setTitle("MoveText");
		primaryStage.setScene(scene);
		primaryStage.show();
   }
   
   
   protected BorderPane getPane(){
	   
	  Pane paneForText = new Pane();
	  paneForText.getChildren().add(text);

      Button btLeft = new Button("Left");
      Button btRight = new Button("Right");
      
      HBox paneForButtons = new HBox(20);
      paneForButtons.getChildren().addAll(btLeft, btRight);
      paneForButtons.setAlignment(Pos.CENTER);
      paneForButtons.setStyle("-fx-border-color: green");
      
      BorderPane pane = new BorderPane();
      pane.setCenter(paneForText);
      pane.setBottom(paneForButtons);
  
      LeftHandler btLeftClick = new LeftHandler();
      btLeft.setOnAction(btLeftClick);
      
      RightHandler btRightClick = new RightHandler();      
      btRight.setOnAction(btRightClick);
      
      return pane;
   }

   
class LeftHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e){
		text.setX(text.getX() - 10);
	}	
}
		
class RightHandler implements EventHandler<ActionEvent>{
	@Override
	public void handle(ActionEvent e){
		text.setX(text.getX() + 10);
	}
}
 
}