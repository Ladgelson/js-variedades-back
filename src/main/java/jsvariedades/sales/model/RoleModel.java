package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.RoleType;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_role")
public class RoleModel extends BaseModel {
    @Enumerated(value = EnumType.STRING)
    private RoleType name;

    public RoleModel(){}

    public RoleModel(RoleType name) {
        this.name = name;
    }

    public RoleType getRoleName() {
        return name;
    }

    public RoleModel setRoleName(RoleType name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleName='" + name + '\'' +
                '}';
    }
}
