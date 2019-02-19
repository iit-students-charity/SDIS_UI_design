package formLayout;

import javafx.scene.layout.GridPane;

public class Form {
    final int FULL_PERCENTS_NUMBER = 100;
    static final String WFL_NULL_EXP_TEXT = "Form is null";

    int columnWidthPercents;
    int rowsHeightPercents;
    int numberOfColumns;
    int numberOfRows;

    GridPane root_GridPane;


    public Form() {
        root_GridPane = new GridPane();

        columnWidthPercents = 1;
        rowsHeightPercents = 1;
        numberOfColumns = 1;
        numberOfRows = 1;
    }

    public Form(int cwp, int rhp, int noc, int nor) {
        this();

        columnWidthPercents = cwp;
        rowsHeightPercents = rhp;
        numberOfColumns = noc;
        numberOfRows = nor;
    }

    public GridPane getRoot_GridPane() {
        return root_GridPane;
    }
}
