package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {
	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnCalcola;

	@FXML
	private TextArea txtResult1;

	@FXML
	private TextArea txtResult2;

	@FXML
	private Button btnReset;

	@FXML
	void doCalcola(ActionEvent event) {
		txtResult1.clear();
		txtResult2.clear();
		
		String inserita = txtParola.getText();
		List<String> permutations = model.findPermutations(inserita);
		for (String str : permutations) {
			if (model.isCorrect(str)) {
				txtResult1.appendText(str + "\n");
			} else {
				txtResult2.appendText(str + "\n");
			}
		}
		

	}

	@FXML
	void doReset(ActionEvent event) {
		txtParola.clear();
		txtResult1.clear();
		txtResult2.clear();
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtResult1 != null : "fx:id=\"txtResult1\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtResult2 != null : "fx:id=\"txtResult2\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}
}
