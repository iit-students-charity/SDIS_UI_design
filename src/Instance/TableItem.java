package Instance;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableItem {

    private final String EMPTY_STRING = "";

    private StringProperty mainName;
    private StringProperty emptyName;


    public TableItem(String name) {
        this.mainName = new SimpleStringProperty(name);
        emptyName = new SimpleStringProperty(EMPTY_STRING);
    }


    public TableItem() {
        this(null);
    }


    public String getMainName() {
        return mainName.get();
    }


    public void setMainName(String mainName) {
        this.mainName.set(mainName);
    }


    public StringProperty mainNameProperty() {
        if (mainName == null) mainName = new SimpleStringProperty(this, EMPTY_STRING);
        return mainName;
    }


    public StringProperty emptyNameProperty() {
        if (emptyName == null) emptyName = new SimpleStringProperty(this, EMPTY_STRING);
        return emptyName;
    }


    public void mainToEmpty() {
        if (emptyName.get() == EMPTY_STRING) {
            emptyName.set(mainName.get());
            mainName.set(EMPTY_STRING);
        }
    }


    public void emptyToMain() {
        if (emptyName.get() != EMPTY_STRING) {
            mainName.set(emptyName.get());
            emptyName.set(EMPTY_STRING);
        }
    }
}
