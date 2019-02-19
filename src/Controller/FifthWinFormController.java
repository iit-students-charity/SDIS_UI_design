package Controller;

import FormLayout.FifthWinFormLayout;
import Instance.TableItem;

import javafx.event.ActionEvent;


public class FifthWinFormController {

    private final String EXP_MWFL_NULL = "FifthWinFormLayout is null";
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "Data required";

    private FifthWinFormLayout mainWFL;


    public FifthWinFormController(FifthWinFormLayout mainWFL) throws NullPointerException {
        if (mainWFL == null) {
            throw new NullPointerException(EXP_MWFL_NULL);
        }

        this.mainWFL = mainWFL;

        this.mainWFL.getCreateItemBtn().setOnAction((ActionEvent event) -> {

            String text = this.mainWFL.getItemNameTxtFld().getText();

            if (text.length() > 0) {
                TableItem item = new TableItem(text);

                this.mainWFL.getItemList().add(item);
            }
            /*else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(DIALOG_TITLE);
                alert.setHeaderText(null);
                alert.setContentText(DIALOG_TEXT);

                alert.showAndWait();
            }*/

            this.mainWFL.getItemNameTxtFld().clear();
        });

        this.mainWFL.getToRightBtn().setOnAction((ActionEvent event) -> {
            TableItem item = this.mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.mainToEmpty();
            }
        });

        this.mainWFL.getToLeftBtn().setOnAction((ActionEvent event) -> {
            TableItem item = this.mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.emptyToMain();
            }
        });
    }
}
