package formLayout;

import javafx.event.ActionEvent;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class SecondForm extends Form {
    private final int INSETS_MARGIN_SIZE = 20;
    private final String APPLY_NAME_BUTTON_TEXT = "Apply name";
    private final String CHANGE_NAMES_BUTTON_TEXT = "Change names";

    private TextField nameTxtFld;
    private Button applyNameButton;
    private Button changeNamesButton;

    public SecondForm() {
        super(50, 50, 2, 2);

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);

        nameTxtFld = new TextField();
        applyNameButton = new Button(APPLY_NAME_BUTTON_TEXT);
        changeNamesButton = new Button(CHANGE_NAMES_BUTTON_TEXT);

        root_GridPane.add(nameTxtFld, 0,0, 2,1);
        root_GridPane.add(applyNameButton, 0,1);
        root_GridPane.add(changeNamesButton, 1,1);

        GridPane.setHalignment(nameTxtFld, HPos.CENTER);
        GridPane.setHalignment(applyNameButton, HPos.CENTER);
        GridPane.setHalignment(changeNamesButton, HPos.CENTER);

        GridPane.setMargin(nameTxtFld, new Insets(INSETS_MARGIN_SIZE));


        applyNameButton.setOnAction((ActionEvent e) -> {
            String text = nameTxtFld.getText();

            if (text.length() > 0) {
                applyNameButton.setText(text);
            }
        });

        changeNamesButton.setOnAction((ActionEvent e) -> {
            String applyNameButtonTxt = applyNameButton.getText();
            applyNameButton.setText(changeNamesButton.getText());
            changeNamesButton.setText(applyNameButtonTxt);
        });
    }
}
