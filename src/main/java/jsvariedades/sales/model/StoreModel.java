package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_store")
public class StoreModel extends BaseModel {

    @Column(nullable = false)
    private String name;

    @ManyToOne
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
