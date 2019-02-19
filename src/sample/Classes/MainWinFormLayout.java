package sample.Classes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.geometry.HPos;
import javafx.geometry.Insets;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class MainWinFormLayout {

    private final String CREATE_ITEM_BUTTON_TEXT = "Create item";
    private final String TO_LEFT_BUTTON_TEXT = "To left";
    private final String TO_RIGHT_BUTTON_TEXT = "To right";
    private final String FIRST_COLUMN_NAME = "1";
    private final String SECOND_COLUMN_NAME = "2";
    private final String ITEM_MAIN_NAME_PROPERTY_NAME = "mainName";
    private final String ITEM_EMPTY_NAME_PROPERTY_NAME = "emptyName";

    private final int FIRST_COLUMN_NUMBER = 0;
    private final int SECOND_COLUMN_NUMBER = 1;
    private final int GRID_PANE_NUMBER_OF_COLUMNS = 2;
    private final int GRID_PANE_NUMBER_OF_ROWS = 3;
    private final int GRID_PANE_COLUMN_WIDTH_PERCENTS = 50;
    private final int GRID_PANE_ROW_HEIGHT_PERCENTS = 20;
    private final int INSETS_MARGIN_SIZE = 10;
    private final int FULL_PERCENTS_NUMBER = 100;


    private GridPane root;

    private TextField itemNameTxtFld;
    private Button createItemBtn;

    private TableView<Item> itemTable;

    private TableColumn<Item, String> firstColumn;
    private TableColumn<Item, String> secondColumn;

    private Button toLeftBtn;
    private Button toRightBtn;


    ObservableList<Item> itemList = FXCollections.observableArrayList();


    public MainWinFormLayout() {
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


        root = new GridPane();

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(GRID_PANE_COLUMN_WIDTH_PERCENTS);
        root.getColumnConstraints().add(column_1);

        ColumnConstraints column_2 = new ColumnConstraints();
        column_2.setPercentWidth(GRID_PANE_COLUMN_WIDTH_PERCENTS);
        root.getColumnConstraints().add(column_2);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(GRID_PANE_ROW_HEIGHT_PERCENTS);
        root.getRowConstraints().add(row_1);

        RowConstraints row_2 = new RowConstraints();
        row_2.setPercentHeight(FULL_PERCENTS_NUMBER - (GRID_PANE_NUMBER_OF_ROWS - 1) * GRID_PANE_ROW_HEIGHT_PERCENTS);
        root.getRowConstraints().add(row_2);

        RowConstraints row_3 = new RowConstraints();
        row_3.setPercentHeight(GRID_PANE_ROW_HEIGHT_PERCENTS);
        root.getRowConstraints().add(row_3);


        GridPane.setHalignment(createItemBtn, HPos.CENTER);
        GridPane.setHalignment(toLeftBtn, HPos.CENTER);
        GridPane.setHalignment(toRightBtn, HPos.CENTER);
        GridPane.setMargin(itemNameTxtFld, new Insets(INSETS_MARGIN_SIZE));


        root.add(itemNameTxtFld, 0, 0);
        root.add(createItemBtn, 1, 0);
        root.add(itemTable, 0, 1, 2,1);
        root.add(toLeftBtn, 0, 2);
        root.add(toRightBtn, 1, 2);

        itemTable.setItems(itemList);
    }


    public GridPane getRoot() {
        return root;
    }


    public TextField getItemNameTxtFld() {
        return itemNameTxtFld;
    }


    public Button getCreateItemBtn() {
        return createItemBtn;
    }


    public TableView<Item> getItemTable() {
        return itemTable;
    }

    public TableColumn<Item, String> getFirstColumn() {
        return firstColumn;
    }


    public TableColumn<Item, String> getSecondColumn() {
        return secondColumn;
    }


    public Button getToLeftBtn() {
        return toLeftBtn;
    }


    public Button getToRightBtn() {
        return toRightBtn;
    }


    public ObservableList<Item> getItemList() {
        return itemList;
    }
}
