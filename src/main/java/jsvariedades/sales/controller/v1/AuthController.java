package jsvariedades.sales.controller.v1;

import io.swagger.v3.oas.annotations.tags.Tag;
import jsvariedades.sales.dto.request.LoginRequest;
import jsvariedades.sales.dto.response.JwtResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Resource to authenticate in the system")
@RequestMapping("/api/v1/auth")
public interface AuthController {
    @PostMapping("/login")
    ResponseEntity<JwtResponse> login(@RequestBody LoginRequest authRequest);

    @GetMapping("/logout")
    ResponseEntity<Void> logout();
}
