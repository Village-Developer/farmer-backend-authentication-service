package village.farmer.statics;

public enum StaticsEnum {
    Role_User("user"),
    Role_Villager("villager");

    private String display;
    StaticsEnum(String display) {
        this.display = display;
    }
    public String displayName() {
        return display;
    }
    @Override
    public String toString() {
        return display;
    }
}
