package Backend.SGTS.security;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.criteria.CriteriaBuilder;

@JsonPropertyOrder({"username",  "message", "status", "jwt"})
public record AuthResponse(
        String username,
//        Integer id_usuario,
      String message,
        String jwt,
        Boolean status) {
}
