package jsvariedades.sales.dto.response;

import jsvariedades.sales.enums.ClientStatus;

public class ClientResponse {
    private String name;
    private String email;
    private String document;
    private String phone;
    private ClientStatus clientStatus;

    public ClientResponse() {
    }

    public String getName() {
        return name;
    }

    public ClientResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public ClientResponse setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientResponse setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ClientStatus getClientStatus() {
        return clientStatus;
    }

    public ClientResponse setClientStatus(ClientStatus clientStatus) {
        this.clientStatus = clientStatus;
        return this;
    }

    @Override
    public String toString() {
        return "ClientResponse{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                ", clientStatus=" + clientStatus +
                '}';
    }
}
