package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_user")
public class UserModel extends BaseModel {

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

    public UserModel(String username, String email, String password, boolean isActive, String imgLink, RoleModel role, CompanyModel company) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.imgLink = imgLink;
        this.role = role;
        this.company = company;
    }

    public String getUsername() {
        return username;
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
