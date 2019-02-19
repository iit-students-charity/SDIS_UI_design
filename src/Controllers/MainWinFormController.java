package Controllers;

import sample.Classes.Item;
import sample.Classes.MainWinFormLayout;

import javafx.event.ActionEvent;

import javafx.scene.control.*;


public class MainWinFormController {

    private final String EXP_MWFL_NULL = "MainWinFormLayout is null";
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "Data required";

    private MainWinFormLayout mainWFL;


    public MainWinFormController(MainWinFormLayout mainWFL) throws NullPointerException {
        if (mainWFL == null) {
            throw new NullPointerException(EXP_MWFL_NULL);
        }

        this.mainWFL = mainWFL;

        this.mainWFL.getCreateItemBtn().setOnAction((ActionEvent event) -> {

            String text = this.mainWFL.getItemNameTxtFld().getText();

            if (text.length() > 0) {
                Item item = new Item(text);

                this.mainWFL.getItemList().add(item);
            }
            else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(DIALOG_TITLE);
                alert.setHeaderText(null);
                alert.setContentText(DIALOG_TEXT);

                alert.showAndWait();
            }

            this.mainWFL.getItemNameTxtFld().clear();
        });

        this.mainWFL.getToRightBtn().setOnAction((ActionEvent event) -> {
            Item item = this.mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.mainToEmpty();
            }
        });

        this.mainWFL.getToLeftBtn().setOnAction((ActionEvent event) -> {
            Item item = this.mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.emptyToMain();
            }
        });
    }
}
