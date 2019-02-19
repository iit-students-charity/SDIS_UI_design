package formLayout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class FirstForm extends Form {
    private final int INSETS_MARGIN_SIZE = 20;
    private final String ADD_ITEM_BUTTON_TEXT = "Add item";
    private final String DIALOG_TITLE = "Error";
    private final String DIALOG_TEXT = "There is the same item";

    private TextField nameTxtFld;
    private Button addItemBtn;
    private ComboBox<String> comboBox;

    private ObservableList<String> comboBoxItems;

    public FirstForm() {
        super(100, 35, 1, 3);

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);

        nameTxtFld = new TextField();
        addItemBtn = new Button(ADD_ITEM_BUTTON_TEXT);
        comboBox = new ComboBox<>();

        root_GridPane.add(nameTxtFld, 0,0);
        root_GridPane.add(addItemBtn, 0,1);
        root_GridPane.add(comboBox, 0,2);

        GridPane.setHalignment(nameTxtFld, HPos.CENTER);
        GridPane.setHalignment(addItemBtn, HPos.CENTER);
        GridPane.setHalignment(comboBox, HPos.CENTER);

        GridPane.setMargin(nameTxtFld, new Insets(INSETS_MARGIN_SIZE));

        comboBoxItems = FXCollections.observableArrayList();
        comboBox.setItems(comboBoxItems);

        addItemBtn.setOnAction((ActionEvent e) -> {
            String text = nameTxtFld.getText();
            boolean isThereSameItem = false;

            if (text.length() > 0) {
                for (int i = 0; i < comboBoxItems.size(); i++) {
                    if (comboBoxItems.get(i).equals(text)) {
                        isThereSameItem = true;
                        break;
                    }
                }

                if (!isThereSameItem) {
                    comboBoxItems.add(text);
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle(DIALOG_TITLE);
                    alert.setHeaderText(null);
                    alert.setContentText(DIALOG_TEXT);

                    alert.showAndWait();
                }
            }
        });
    }
}
