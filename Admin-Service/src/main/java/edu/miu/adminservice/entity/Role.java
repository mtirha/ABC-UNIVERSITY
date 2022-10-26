package edu.miu.adminservice.entity;


public enum Role {

    STUDENT("STUDENT"), FACULTY("FACULTY"), REGISTRAR("REGISTRAR");

    private String roleName ;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
