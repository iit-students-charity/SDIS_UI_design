package Controller;

import FormLayout.FourthWinFormLayout;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;

import java.util.List;

public class FourthWinFormController extends WinFormController {
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "No such checkbox";


    public FourthWinFormController(FourthWinFormLayout mainWFL) throws NullPointerException {
        setMainWFL(mainWFL);

        mainWFL.getFindCheckBoxBtn().setOnAction((ActionEvent event) -> {

            TextField textField = mainWFL.getCheckBoxNameTxtFld();
            List<CheckBox> checkBoxes = mainWFL.getCheckBoxes();

            if (textField.getText().length() > 0) {
                boolean isThereSameCB = false;

                for(int i = 0; i < checkBoxes.size(); i++) {
                    CheckBox thisCheckBox = checkBoxes.get(i);
                    isThereSameCB = (thisCheckBox.getText().equals(textField.getText()));

                    if (isThereSameCB) {
                        thisCheckBox.setSelected(!thisCheckBox.isSelected());
                        break;
                    }
                }

                if (!isThereSameCB) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(DIALOG_TITLE);
                    alert.setHeaderText(null);
                    alert.setContentText(DIALOG_TEXT);

                    alert.showAndWait();
                }
            }

            mainWFL.getCheckBoxNameTxtFld().clear();
        });

    }
}
