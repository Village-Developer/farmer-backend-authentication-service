package village.farmer.model.request;

public class EditRoleRequest {
    private String role;
    private String changeTo;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getChangeTo() {
        return changeTo;
    }

    public void setChangeTo(String changeTo) {
        this.changeTo = changeTo;
    }
}
