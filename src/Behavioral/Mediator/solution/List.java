package Behavioral.Mediator.solution;

import java.util.ArrayList;

public class List {
    private java.util.List<String> items = new ArrayList<>();

    private ScreenDirector screenDirector;

    public void selectItem(int itemNumber){
        String item = items.get(itemNumber);
        if (screenDirector!=null){
            screenDirector.itemSelected(item);
        }
    }

    public java.util.List<String> getItems() {
        return items;
    }

    public void setInputText(ScreenDirector screenDirector) {
        this.screenDirector = screenDirector;
    }

    public void setScreenDirector(ScreenDirector screenDirector) {
        this.screenDirector = screenDirector;
    }
}
