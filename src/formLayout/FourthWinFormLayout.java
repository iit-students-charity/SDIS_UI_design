package formLayout;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import java.util.ArrayList;
import java.util.List;

public class FourthWinFormLayout extends WinFormLayout {
    private final int INSETS_MARGIN_SIZE = 10;
    private final String FIND_CHECK_BOX_BUTTON_TEXT = "Find check box";
    private final String CHECK_BOX_1_TEXT = "One";
    private final String CHECK_BOX_2_TEXT = "Two";
    private final String CHECK_BOX_3_TEXT = "Three";

    private TextField checkBoxNameTxtFld;
    private Button findCheckBoxBtn;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;

    private List<CheckBox> checkBoxes;

    public FourthWinFormLayout() {
        super(50, 25, 2, 2);

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

        checkBoxNameTxtFld = new TextField();
        findCheckBoxBtn = new Button(FIND_CHECK_BOX_BUTTON_TEXT);
        checkBox1 = new CheckBox(CHECK_BOX_1_TEXT);
        checkBox2 = new CheckBox(CHECK_BOX_2_TEXT);
        checkBox3 = new CheckBox(CHECK_BOX_3_TEXT);

        checkBoxes = new ArrayList<>();

        checkBoxes.add(checkBox1);
        checkBoxes.add(checkBox2);
        checkBoxes.add(checkBox3);

        GridPane.setHalignment(checkBoxNameTxtFld, HPos.LEFT);
        GridPane.setHalignment(findCheckBoxBtn, HPos.RIGHT);
        GridPane.setHalignment(checkBox1, HPos.CENTER);
        GridPane.setHalignment(checkBox2, HPos.CENTER);
        GridPane.setHalignment(checkBox3, HPos.CENTER);
        GridPane.setMargin(checkBoxNameTxtFld, new Insets(INSETS_MARGIN_SIZE));
        GridPane.setMargin(findCheckBoxBtn, new Insets(INSETS_MARGIN_SIZE));

        root_GridPane.add(checkBoxNameTxtFld, 0, 0);
        root_GridPane.add(findCheckBoxBtn, 1, 0);
        root_GridPane.add(checkBox1, 0, 1, 2,1);
        root_GridPane.add(checkBox2, 0, 2, 2,1);
        root_GridPane.add(checkBox3, 0, 3, 2,1);
    }



    public TextField getCheckBoxNameTxtFld() {
        return checkBoxNameTxtFld;
    }

    public Button getFindCheckBoxBtn() {
        return findCheckBoxBtn;
    }

    public List<CheckBox> getCheckBoxes() {
        return checkBoxes;
    }
}
