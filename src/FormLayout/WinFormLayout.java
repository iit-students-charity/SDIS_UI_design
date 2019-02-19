package FormLayout;

import javafx.scene.layout.GridPane;

public class WinFormLayout {
    protected final int FULL_PERCENTS_NUMBER = 100;
    protected final String WFL_NULL_EXP_TEXT = "WinFormLayout is null";

    protected int columnWidthPercents;
    protected int rowsHeightPercents;
    protected int numberOfColumns;
    protected int numberOfRows;

    protected GridPane root_GridPane;


    public WinFormLayout() {
        root_GridPane = new GridPane();

        columnWidthPercents = 1;
        rowsHeightPercents = 1;
        numberOfColumns = 1;
        numberOfRows = 1;
    }

    public WinFormLayout(int cwp, int rhp, int noc, int nor) {
        this();

        columnWidthPercents = cwp;
        rowsHeightPercents = rhp;
        numberOfColumns = noc;
        numberOfRows = nor;
    } ;

    public void setColumnWidthPercents(int columnWidthPercents) {
        this.columnWidthPercents = columnWidthPercents;
    }

    public void setRowsHeightPercents(int rowsHeightPercents) {
        this.rowsHeightPercents = rowsHeightPercents;
    }

    public void setNumberOfColumns(int numberOfColumns) {
        this.numberOfColumns = numberOfColumns;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }


    public GridPane getRoot_GridPane() {
        return root_GridPane;
    }

    public int getColumnWidthPercents() {
       return columnWidthPercents;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public int getRowsHeightPercents() {
        return rowsHeightPercents;
    }
}
