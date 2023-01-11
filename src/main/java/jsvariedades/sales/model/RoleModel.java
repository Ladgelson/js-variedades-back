package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.RoleType;
import jsvariedades.sales.model.base.BaseModel;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "tb_role")
public class RoleModel extends BaseModel implements GrantedAuthority {
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

    @Override
    public String getAuthority() {
        return name.toString();
    }
}
