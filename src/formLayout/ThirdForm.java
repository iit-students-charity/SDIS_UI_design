package formLayout;

import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;


public class ThirdForm{
    GridPane root_GridPane;

    int columnWidthPercents = 50;
    int rowsHeightPercents = 25;

    private final int INSETS_MARGIN_SIZE = 10;
    private final String FIND_CHECK_BOX_BUTTON_TEXT = "Find radio button";
    private final String CHECK_BOX_1_TEXT = "One";
    private final String CHECK_BOX_2_TEXT = "Two";
    private final String CHECK_BOX_3_TEXT = "Three";
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "No such radio button";

    private TextField radioButtonNameTxtFld;
    private Button findRadioButtonBtn;

    private ToggleGroup toggleGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;

    private List<RadioButton> radioButtons;

    public ThirdForm() {
        root_GridPane = new GridPane();

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);

        radioButtonNameTxtFld = new TextField();
        findRadioButtonBtn = new Button(FIND_CHECK_BOX_BUTTON_TEXT);
        toggleGroup = new ToggleGroup();
        radioButton1 = new RadioButton(CHECK_BOX_1_TEXT);
        radioButton2 = new RadioButton(CHECK_BOX_2_TEXT);
        radioButton3 = new RadioButton(CHECK_BOX_3_TEXT);

        radioButtons = new ArrayList<>();

        radioButtons.add(radioButton1);
        radioButtons.add(radioButton2);
        radioButtons.add(radioButton3);

        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);

        GridPane.setHalignment(radioButtonNameTxtFld, HPos.LEFT);
        GridPane.setHalignment(findRadioButtonBtn, HPos.RIGHT);
        GridPane.setHalignment(radioButton1, HPos.CENTER);
        GridPane.setHalignment(radioButton2, HPos.CENTER);
        GridPane.setHalignment(radioButton3, HPos.CENTER);
        GridPane.setMargin(radioButtonNameTxtFld, new Insets(INSETS_MARGIN_SIZE));
        GridPane.setMargin(findRadioButtonBtn, new Insets(INSETS_MARGIN_SIZE));

        root_GridPane.add(radioButtonNameTxtFld, 0, 0);
        root_GridPane.add(findRadioButtonBtn, 1, 0);
        root_GridPane.add(radioButton1, 0, 1, 2,1);
        root_GridPane.add(radioButton2, 0, 2, 2,1);
        root_GridPane.add(radioButton3, 0, 3, 2,1);

        findRadioButtonBtn.setOnAction((ActionEvent event) -> {

            if (radioButtonNameTxtFld.getText().length() > 0) {
                boolean isThereSameRB = false;

                for(int i = 0; i < radioButtons.size(); i++) {
                    RadioButton thisCheckBox = radioButtons.get(i);
                    isThereSameRB = (thisCheckBox.getText().equals(radioButtonNameTxtFld.getText()));

                    if (isThereSameRB) {
                        thisCheckBox.setSelected(true);
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

            radioButtonNameTxtFld.clear();
        });
    }

    public GridPane getRoot_GridPane() {
        return root_GridPane;
    }
}
