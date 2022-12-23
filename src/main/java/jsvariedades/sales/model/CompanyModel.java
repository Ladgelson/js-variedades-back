package jsvariedades.sales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Company")
public class CompanyModel extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 20)
    private String cnpj;

    public CompanyModel() {
    }

    public String getName() {
        return name;
    }

    public CompanyModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public CompanyModel setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    @Override
    public String toString() {
        return "CompanyModel{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                '}';
    }
}
