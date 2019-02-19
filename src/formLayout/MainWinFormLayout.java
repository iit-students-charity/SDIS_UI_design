package formLayout;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class MainWinFormLayout extends WinFormLayout {
    private FourthWinFormLayout fourthWFL;
    private FifthWinFormLayout fifthWFL;
    private ThirdWinFormLayout thirdWFL;


    public MainWinFormLayout(ThirdWinFormLayout thirdWFL, FourthWinFormLayout fourthWFL, FifthWinFormLayout fifthWFL) {
        super(50, 35, 2,3);

        setThirdWFL(thirdWFL);
        setFourthWFL(fourthWFL);
        setFifthWFL(fifthWFL);


        ColumnConstraints column_1 = new ColumnConstraints();
        column_1.setPercentWidth(columnWidthPercents);
        root_GridPane.getColumnConstraints().add(column_1);
        root_GridPane.getColumnConstraints().add(column_1);

        RowConstraints row_1 = new RowConstraints();
        row_1.setPercentHeight(rowsHeightPercents);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);
        root_GridPane.getRowConstraints().add(row_1);

        root_GridPane.add(thirdWFL.getRoot_GridPane(), 0,1);
        root_GridPane.add(fourthWFL.getRoot_GridPane(), 1,1);
        root_GridPane.add(fifthWFL.getRoot_GridPane(), 0,2);


        root_GridPane.setGridLinesVisible(true);
    }

    private void setThirdWFL(ThirdWinFormLayout thirdWFL) throws NullPointerException {
        if (thirdWFL == null) {
            throw new NullPointerException(WFL_NULL_EXP_TEXT);
        }

        this.thirdWFL = thirdWFL;
    }

    private void setFourthWFL(FourthWinFormLayout fourthWFL) throws NullPointerException {
        if (fourthWFL == null) {
            throw new NullPointerException(WFL_NULL_EXP_TEXT);
        }

        this.fourthWFL = fourthWFL;
    }

    private void setFifthWFL(FifthWinFormLayout fifthWFL) throws NullPointerException {
        if (fifthWFL == null) {
            throw new NullPointerException(WFL_NULL_EXP_TEXT);
        }

        this.fifthWFL = fifthWFL;
    }
}
