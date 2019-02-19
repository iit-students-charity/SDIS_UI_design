package formLayout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import instance.TableItem;


public class FifthWinFormLayout extends WinFormLayout {

    private final String CREATE_ITEM_BUTTON_TEXT = "Create item";
    private final String TO_LEFT_BUTTON_TEXT = "To left";
    private final String TO_RIGHT_BUTTON_TEXT = "To right";
    private final String FIRST_COLUMN_NAME = "1";
    private final String SECOND_COLUMN_NAME = "2";
    private final String ITEM_MAIN_NAME_PROPERTY_NAME = "mainName";
    private final String ITEM_EMPTY_NAME_PROPERTY_NAME = "emptyName";

    private final int INSETS_MARGIN_SIZE = 10;

    private TextField itemNameTxtFld;
    private Button createItemBtn;

    private TableView<TableItem> itemTable;

    private TableColumn<TableItem, String> firstColumn;
    private TableColumn<TableItem, String> secondColumn;

    private Button toLeftBtn;
    private Button toRightBtn;


    private ObservableList<TableItem> itemList = FXCollections.observableArrayList();


    public FifthWinFormLayout() {
        super(50, 20, 2, 3);

        createItemBtn = new Button(CREATE_ITEM_BUTTON_TEXT);
        toLeftBtn = new Button(TO_LEFT_BUTTON_TEXT);
        toRightBtn = new Button(TO_RIGHT_BUTTON_TEXT);
        itemNameTxtFld = new TextField();

        itemTable = new TableView<>();
        itemTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        firstColumn = new TableColumn<>(FIRST_COLUMN_NAME);
        secondColumn = new TableColumn<>(SECOND_COLUMN_NAME);

        firstColumn.setCellValueFactory(new PropertyValueFactory<>(ITEM_MAIN_NAME_PROPERTY_NAME));
        secondColumn.setCellValueFactory(new PropertyValueFactory<>(ITEM_EMPTY_NAME_PROPERTY_NAME));
        firstColumn.setSortable(false);
        secondColumn.setSortable(false);

        itemTable.getColumns().add(firstColumn);
        itemTable.getColumns().add(secondColumn);

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);

        RowConstraints row_2 = new RowConstraints();
        row_2.setPercentHeight(FULL_PERCENTS_NUMBER - (numberOfRows - 1) * rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_2);

        root_GridPane.getRowConstraints().add(row_1);


        GridPane.setHalignment(createItemBtn, HPos.CENTER);
        GridPane.setHalignment(toLeftBtn, HPos.CENTER);
        GridPane.setHalignment(toRightBtn, HPos.CENTER);
        GridPane.setMargin(itemNameTxtFld, new Insets(INSETS_MARGIN_SIZE));


        root_GridPane.add(itemNameTxtFld, 0, 0);
        root_GridPane.add(createItemBtn, 1, 0);
        root_GridPane.add(itemTable, 0, 1, 2,1);
        root_GridPane.add(toLeftBtn, 0, 2);
        root_GridPane.add(toRightBtn, 1, 2);

        itemTable.setItems(itemList);
    }

    public TextField getItemNameTxtFld() {
        return itemNameTxtFld;
    }

    public Button getCreateItemBtn() {
        return createItemBtn;
    }

    public TableView<TableItem> getItemTable() {
        return itemTable;
    }

    public TableColumn<TableItem, String> getFirstColumn() {
        return firstColumn;
    }

    public TableColumn<TableItem, String> getSecondColumn() {
        return secondColumn;
    }

    public Button getToLeftBtn() {
        return toLeftBtn;
    }

    public Button getToRightBtn() {
        return toRightBtn;
    }

    public ObservableList<TableItem> getItemList() {
        return itemList;
    }
}
