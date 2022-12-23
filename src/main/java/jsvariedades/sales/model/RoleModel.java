package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.RoleType;

@Entity
@Table(name = "Role")
public class RoleModel extends BaseModel{

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RoleType roleName;

    public RoleModel(){}

    public RoleModel(RoleType roleName) {
        this.roleName = roleName;
    }

    public RoleType getRoleName() {
        return roleName;
    }

    public RoleModel setRoleName(RoleType roleName) {
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
