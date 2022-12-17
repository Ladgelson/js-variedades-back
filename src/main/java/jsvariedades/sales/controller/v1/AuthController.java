package jsvariedades.sales.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/auth")
public interface AuthController {
    @PostMapping("/login")
    ResponseEntity<?> login(Object authRequest);

    @GetMapping("/logout")
    ResponseEntity<?> logout();
}
