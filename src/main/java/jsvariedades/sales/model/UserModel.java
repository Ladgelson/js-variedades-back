package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
public class UserModel extends BaseModel implements UserDetails {

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = false)
    private String imgLink;

    @ManyToOne
    private RoleModel role;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    public UserModel() {
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(this.role);
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserModel setActive(boolean active) {
        isActive = active;
        return this;
    }

    public String getImgLink() {
        return imgLink;
    }

    public UserModel setImgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    public RoleModel getRole() {
        return role;
    }

    public UserModel setRole(RoleModel role) {
        this.role = role;
        return this;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public UserModel setCompany(CompanyModel company) {
        this.company = company;
        return this;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                ", imgLink='" + imgLink + '\'' +
                ", role=" + role +
                '}';
    }

}
