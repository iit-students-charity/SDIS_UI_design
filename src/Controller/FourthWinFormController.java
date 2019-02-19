package Controller;

import FormLayout.FourthWinFormLayout;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert;

import java.util.List;

public class FourthWinFormController {
    private final String EXP_MWFL_NULL = "FourthWinFormLayout is null";
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "No such checkbox";

    private FourthWinFormLayout mainWFL;


    public FourthWinFormController(FourthWinFormLayout mainWFL) throws NullPointerException {
        setMainWFL(mainWFL);

        this.mainWFL.getFindCheckBoxBtn().setOnAction((ActionEvent event) -> {

            TextField textField = this.mainWFL.getCheckBoxNameTxtFld();
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

            this.mainWFL.getCheckBoxNameTxtFld().clear();
        });

    }

    public void setMainWFL(FourthWinFormLayout mainWFL) {
        if (mainWFL == null) {
            throw new NullPointerException(EXP_MWFL_NULL);
        }

        this.mainWFL = mainWFL;
    }
}
