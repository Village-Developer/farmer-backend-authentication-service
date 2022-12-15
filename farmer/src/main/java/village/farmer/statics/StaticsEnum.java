package village.farmer.statics;

public enum StaticsEnum {
    Role_User("user", 1),
    Role_Other("other", 2),

    Role_Admin("admin", 3),
    Role_Villager("villager", 4);

    private String display;
    private Integer level;
    StaticsEnum(String display, int level) {
        this.display = display;
        this.level = level;
    }
    public String displayName() {
        return display;
    }
    public Integer displayLevel() {
        return level;
    }
    @Override
    public String toString() {
        return display;
    }
}
