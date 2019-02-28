package formLayout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class MainForm {

    GridPane root_GridPane;
    int columnWidthPercents = 20;
    int rowsHeightPercents = 100;

    public MainForm(FirstForm firstF, SecondForm secondF, ThirdForm thirdF,
                    FourthForm fourthF, FifthForm fifthF) {
        root_GridPane = new GridPane();

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);

        root_GridPane.add(firstF.getRoot_GridPane(), 0,0);
        root_GridPane.add(secondF.getRoot_GridPane(), 1,0);
        root_GridPane.add(thirdF.getRoot_GridPane(), 2,0);
        root_GridPane.add(fourthF.getRoot_GridPane(), 3,0);
        root_GridPane.add(fifthF.getRoot_GridPane(), 4,0);


        root_GridPane.setGridLinesVisible(true);
    }

    public GridPane getRoot_GridPane() {
        return root_GridPane;
    }
}
