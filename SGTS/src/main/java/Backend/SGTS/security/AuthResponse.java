package Backend.SGTS.security;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import Backend.SGTS.Entity.Dto.RolDto;

@JsonPropertyOrder({"username", "id_usuario", "id_recurso", "roles",  "message", "status", "jwt"})
public record AuthResponse(
        String username,
         Integer id_usuario,
         Integer id_recurso,
         List<RolDto> roles,
         String message,
        String jwt,
        Boolean status) {
}
