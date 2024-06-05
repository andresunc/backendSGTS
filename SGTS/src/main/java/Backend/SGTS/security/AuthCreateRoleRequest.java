package Backend.SGTS.security;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
public record AuthCreateRoleRequest(
        @Size(max = 1, message = "The user cannot have more than 1 rol") List<String> roleListName) {
}