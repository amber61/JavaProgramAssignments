/* 
 * File Name: ATM.java
 * Course Name: CST8284_300 Object-Oriented Programming(Java)
 * Lab	Section: 303
 * Author: Dave Houtman, modified by ZHE HUANG
 * Date: Monday, December 7, 2015
 */
import java.util.Scanner;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class ATM {

	private static final String EXIT = "Exit";
	private static final String ENTER = "Enter";
	private static final String CORRECTION = "Correction";
	private static final String DEPOSIT = "Deposit";
	private static final String WITHDRAWAL = "Withdrawal";
	private static final String VIEW_AMOUNT = "View Amount";

	public String currentLine = "", currentText = "";
	TextArea txtDisplay;
	Label lblTransaction;
	/*
	 * Field that holds a bank
	 */
	Bank bank;
	/*
	 * Field that holds a transaction with uninitialized transaction type
	 */
	TransactionResult transactionResult = new TransactionResult(false,
			"Initialized", TransactionType.NONE);

	public ATM(Stage stage) {
		// set up bank
		setupBank();

		VBox ATMPanel = new VBox(30);
		Insets spacing = new Insets(12, 12, 12, 12);

		lblTransaction = new Label(
				"Welcome to the Polymorphic Bank.  Please select one of the buttons below.");

		HBox buttons = new HBox(30);
		buttons.getChildren().addAll(buildKeyPad(spacing),
				buildOptions(spacing));

		txtDisplay = new TextArea();
		txtDisplay.setPrefHeight(200);
		txtDisplay.cursorProperty();
		txtDisplay.setEditable(false);

		ATMPanel.setPadding(spacing);
		ATMPanel.getChildren().addAll(lblTransaction, txtDisplay, buttons);

		Scene scene = new Scene(ATMPanel, 450, 500);

		stage.setTitle("ATM");
		stage.setScene(scene);
		stage.show();
	}

	/*
	 * Build a bank
	 */
	public void setupBank() {
		this.bank = new Bank();
		this.bank.addCustomer("", "");
		this.bank.addAccount(0, AccountType.CHEQUING_ACCOUNT);
	}

	private GridPane buildKeyPad(Insets ins) {

		GridPane keypad = new GridPane();
		keypad.setPrefWidth(300);
		keypad.setAlignment(Pos.TOP_CENTER);
		keypad.setPadding(ins);
		keypad.setHgap(6.5);
		keypad.setVgap(6.5);

		for (int buttonNumber = 1, row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++, buttonNumber++) {
				Button bt = makeClickableButton(Integer.toString(buttonNumber),
						keypad);
				bt.setMaxWidth(keypad.getMaxWidth() / 2);
				keypad.add(bt, col, row);
			}
		}

		Button bt0 = makeClickableButton("0", keypad);
		keypad.add(bt0, 1, 3);

		Button btdecimal = makeClickableButton(".", keypad);
		keypad.add(btdecimal, 2, 3);

		return keypad;
	}

	private VBox buildOptions(Insets ins) {

		VBox vb = new VBox(10);
		vb.setPadding(ins);
		vb.setMaxWidth(400);
		vb.setPrefWidth(400);

		vb.getChildren().add(makeClickableButton(ATM.ENTER, vb));
		vb.getChildren().add(makeClickableButton(ATM.CORRECTION, vb));
		vb.getChildren().add(makeClickableButton(ATM.DEPOSIT, vb));
		vb.getChildren().add(makeClickableButton(ATM.WITHDRAWAL, vb));
		vb.getChildren().add(makeClickableButton(ATM.VIEW_AMOUNT, vb));
		vb.getChildren().add(makeClickableButton(ATM.EXIT, vb));

		return vb;
	}

	private void handleButtonClick(String label) {

		switch (label) {

		case ATM.ENTER:

			// something entered already before entering 'Enter' button
			if (currentLine != "") {
				double amount = Double.valueOf(currentLine);
				if (transactionResult.getTransactionType().equals(
						TransactionType.DEPOSIT)) {
					bank.deposit(0, 0, amount);
					lblTransaction.setText("Deposit " + amount + " was made");
				} else if (transactionResult.getTransactionType().equals(
						TransactionType.WITHDRAWAL)) {
					bank.withdraw(0, 0, amount);
					lblTransaction.setText("Withdraw " + amount + " was made");
				} else {
					lblTransaction.setText("Enter a transaction type below");
				}
			}
			// Nothing entered before entering 'Enter' button
			else {
				if (transactionResult.getTransactionType() == TransactionType.NONE) {
					lblTransaction.setText("Enter a transaction type below");
				}
			}
			txtDisplay.setText("\n" + txtDisplay.getText());
			currentText = txtDisplay.getText();
			// retrieve to TransactionType.NONE after each transaction
			transactionResult.finish();
			currentLine = "";
			break;

		case ATM.CORRECTION:
			if (currentLine.length() > 0) {
				currentLine = currentLine
						.substring(0, currentLine.length() - 1);
				txtDisplay.setText(currentLine + currentText);
			}
			break;

		case ATM.DEPOSIT:
			lblTransaction.setText("Enter the amount to deposit");
			transactionResult = new TransactionResult(false, "Deposit",
					TransactionType.DEPOSIT);
			break;

		case ATM.WITHDRAWAL:
			lblTransaction.setText("Enter the amount to withdrawal");
			transactionResult = new TransactionResult(false, "Withdrawal",
					TransactionType.WITHDRAWAL);
			break;

		case ATM.VIEW_AMOUNT:
			// TODO: view the current amount available in this account

			// user if-else to reduce unnecessary empty line depends different
			// conditions
			lblTransaction.setText("The balance is: ");
			String balan = bank.customerDetails(0);
			for (int i = 0; i < balan.length(); i++) {
				if (balan.charAt(i) == '$') {
					balan = balan.substring(i + 1).trim();
					break;
				}
			}
			if (currentLine.length() == 0 || currentLine.charAt(0) == '\n') {
				txtDisplay.setText('\n' + balan + txtDisplay.getText());
			} else {
				txtDisplay.setText('\n' + balan + "\n" + txtDisplay.getText());
			}
			currentText = txtDisplay.getText();
			currentLine = "";
			break;

		case ATM.EXIT:
			Platform.exit();
			break;

		default:
			txtDisplay.appendText(currentLine += label);
			txtDisplay.setText(currentLine + currentText);
			break;
		}
	}

	private Button makeClickableButton(String btnLabel, Pane p) {

		Button btn = new Button(btnLabel);
		btn.setMaxWidth(p.getMaxWidth());

		btnClickEventHandler btnClick = new btnClickEventHandler();
		btn.setOnAction(btnClick);

		return btn;
	}

	/*
	 * inner class that extract the button to be entered
	 */
	class btnClickEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			Button btn = (Button) (e.getSource());
			String labelInfo = btn.toString();
			// using loop to find ' to extract button we want
			int i, j;
			for (i = 0; i < labelInfo.length(); i++) {
				if (labelInfo.charAt(i) == '\'')
					break;
			}
			labelInfo = labelInfo.substring(i + 1).trim();
			for (j = 0; j < labelInfo.length(); j++) {
				if (labelInfo.charAt(j) == '\'')
					break;
			}
			labelInfo = labelInfo.substring(0, j).trim();
			handleButtonClick(labelInfo);
		}
	}

}
