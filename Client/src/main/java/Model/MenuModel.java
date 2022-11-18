package Model;

public class MenuModel {
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public MenuModel(String name, MenuType type) {
        this.name = name;
        this.type = type;
    }
    
    public MenuModel() {
        
    }
    
    private String name;
    private MenuType type;
    
    public static enum MenuType {
        MENU, EMPTY;

    }
}
