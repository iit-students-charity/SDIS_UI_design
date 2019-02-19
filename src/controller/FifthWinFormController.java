package controller;

import formLayout.FifthWinFormLayout;
import instance.TableItem;

import javafx.event.ActionEvent;


public class FifthWinFormController extends WinFormController {

    public FifthWinFormController(FifthWinFormLayout mainWFL) throws NullPointerException {
        setMainWFL(mainWFL);

        this.mainWFL = mainWFL;

        mainWFL.getCreateItemBtn().setOnAction((ActionEvent event) -> {

            String text = mainWFL.getItemNameTxtFld().getText();

            if (text.length() > 0) {
                TableItem item = new TableItem(text);

                mainWFL.getItemList().add(item);
            }

            mainWFL.getItemNameTxtFld().clear();
        });

        mainWFL.getToRightBtn().setOnAction((ActionEvent event) -> {
            TableItem item = mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.mainToEmpty();
            }
        });

        mainWFL.getToLeftBtn().setOnAction((ActionEvent event) -> {
            TableItem item = mainWFL.getItemTable().getSelectionModel().getSelectedItem();

            if (item != null) {
                item.emptyToMain();
            }
        });
    }
}
