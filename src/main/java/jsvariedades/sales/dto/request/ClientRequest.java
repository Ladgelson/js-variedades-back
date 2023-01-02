package jsvariedades.sales.dto.request;

import jakarta.validation.constraints.NotBlank;

public class ClientRequest {

    @NotBlank
    private String name;

    private String email;

    @NotBlank
    private String document;

    private String phone;

    public ClientRequest() {
    }

    public ClientRequest(String name, String email, String document, String phone) {
        this.name = name;
        this.email = email;
        this.document = document;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public ClientRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientRequest setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getDocument() {
        return document;
    }

    public ClientRequest setDocument(String document) {
        this.document = document;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientRequest setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "ClientRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", document='" + document + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
