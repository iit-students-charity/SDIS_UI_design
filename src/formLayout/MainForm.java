package formLayout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class MainForm extends Form {

    public MainForm(FirstForm firstF, SecondForm secondF, ThirdForm thirdF,
                    FourthForm fourthF, FifthForm fifthF) {

        super(50, 35, 2,3);

        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);

        root_GridPane.add(firstF.getRoot_GridPane(), 0,0);
        root_GridPane.add(secondF.getRoot_GridPane(), 1,0);
        root_GridPane.add(thirdF.getRoot_GridPane(), 0,1);
        root_GridPane.add(fourthF.getRoot_GridPane(), 1,1);
        root_GridPane.add(fifthF.getRoot_GridPane(), 0,2);


        root_GridPane.setGridLinesVisible(true);
    }


}
