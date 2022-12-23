package jsvariedades.sales.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Store")
public class StoreModel extends BaseModel{

    @Column(nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "company_id")
    private CompanyModel company;

    public StoreModel(){}

    public StoreModel(String name, CompanyModel company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public StoreModel setName(String name) {
        this.name = name;
        return this;
    }

    public CompanyModel getCompany() {
        return company;
    }

    public StoreModel setCompany(CompanyModel company) {
        this.company = company;
        return this;
    }

    @Override
    public String toString() {
        return "StoreModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
