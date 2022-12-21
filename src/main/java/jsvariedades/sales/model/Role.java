package jsvariedades.sales.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role extends BaseModel{

    @Column(nullable = false, name = "role_name")
    private String roleName;

    public Role(){}

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public Role setRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + roleName + '\'' +
                '}';
    }
}