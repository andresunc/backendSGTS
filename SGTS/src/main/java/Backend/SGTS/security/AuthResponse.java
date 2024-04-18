package Backend.SGTS.security;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"username", "id_usuario", "id_recurso",  "message", "status", "jwt"})
public record AuthResponse(
        String username,
         Integer id_usuario,
         Integer id_recurso,
         String message,
        String jwt,
        Boolean status) {
}
