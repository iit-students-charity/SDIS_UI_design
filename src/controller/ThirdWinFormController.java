package controller;

import formLayout.ThirdWinFormLayout;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.util.List;

public class ThirdWinFormController extends WinFormController {
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "No such radio button";

    public ThirdWinFormController(ThirdWinFormLayout mainWFL) {
        setMainWFL(mainWFL);

        mainWFL.getFindRadioButtonBtn().setOnAction((ActionEvent event) -> {

            TextField textField = mainWFL.getRadioButtonNameTxtFld();
            List<RadioButton> radioButtons = mainWFL.getRadioButtons();

            if (textField.getText().length() > 0) {
                boolean isThereSameRB = false;

                for(int i = 0; i < radioButtons.size(); i++) {
                    RadioButton thisCheckBox = radioButtons.get(i);
                    isThereSameRB = (thisCheckBox.getText().equals(textField.getText()));

                    if (isThereSameRB) {
                        thisCheckBox.setSelected(!thisCheckBox.isSelected());
                        break;
                    }
                }

                if (!isThereSameRB) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(DIALOG_TITLE);
                    alert.setHeaderText(null);
                    alert.setContentText(DIALOG_TEXT);

                    alert.showAndWait();
                }
            }

            mainWFL.getRadioButtonNameTxtFld().clear();
        });
    }
}
