/* 
 * File Name: ATMLauncher.java
 * Course Name: CST8284_300 Object-Oriented Programming(Java)
 * Lab	Section: 303
 * Author: Dave Houtman, modifier by Zhe Huang
 * Date: Monday, December 7, 2015
 */

import javafx.application.Application;
import javafx.stage.Stage;

public class ATMLauncher extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	// TODO: Override start here and call the ATM constructor
	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage) override
	 * the start method in Application
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {

		new ATM(primaryStage);

	}
}
