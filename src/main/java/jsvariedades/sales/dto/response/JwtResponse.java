package jsvariedades.sales.dto.response;

import java.util.ArrayList;
import java.util.List;

public class JwtResponse {

    private String jwt;

    private String username;

    private List<String> roles = new ArrayList<>();

    public JwtResponse(String jwt, String username, List<String> roles) {
        this.jwt = jwt;
        this.username = username;
        this.roles = roles;
    }

    public String getJwt() {
        return jwt;
    }

    public JwtResponse setJwt(String jwt) {
        this.jwt = jwt;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public JwtResponse setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public JwtResponse setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    @Override
    public String toString() {
        return "JwtResponse{" +
                "jwt='" + jwt + '\'' +
                ", username='" + username + '\'' +
                ", roles=" + roles +
                '}';
    }
}
