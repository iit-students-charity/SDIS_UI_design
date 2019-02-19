package controller;

import formLayout.WinFormLayout;

class WinFormController {
    final String EXP_WFL_NULL = "WinFormLayout is null";

    WinFormLayout mainWFL;

    public void setMainWFL(WinFormLayout mainWFL) {
        if (mainWFL == null) {
            throw new NullPointerException(EXP_WFL_NULL);
        }

        this.mainWFL = mainWFL;
    }
}
