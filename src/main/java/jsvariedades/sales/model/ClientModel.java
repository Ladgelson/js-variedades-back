package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.ClientStatus;
import jsvariedades.sales.model.base.BaseModel;

import java.util.List;

@Entity
@Table(name = "tb_client")
public class ClientModel extends BaseModel {

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(nullable = false)
    private String document;

    private String phone;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ClientStatus status;

    @OneToMany
    private List<SaleModel> sales;

    public ClientModel() {
    }

    public ClientModel(String name, String email, String document, ClientStatus status, List<SaleModel> sales) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.status = status;
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public ClientModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public ClientModel setDocument(String document) {
        this.document = document;
        return this;
    }

    public ClientStatus getStatus() {
        return status;
    }

    public ClientModel setStatus(ClientStatus status) {
        this.status = status;
        return this;
    }

    public List<SaleModel> getSales() {
        return sales;
    }

    public ClientModel setSales(List<SaleModel> sales) {
        this.sales = sales;
        return this;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", status=" + status +
                ", sales=" + sales +
                '}';
    }
}
