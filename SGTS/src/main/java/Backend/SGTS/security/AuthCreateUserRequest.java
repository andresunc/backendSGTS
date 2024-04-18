package Backend.SGTS.security;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record AuthCreateUserRequest(@NotBlank String username,
                                    @NotBlank String password,
                                    Integer id_recurso,
                                    @Valid AuthCreateRoleRequest roleRequest) {
}