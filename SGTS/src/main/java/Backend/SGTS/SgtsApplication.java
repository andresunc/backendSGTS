package Backend.SGTS;

import Backend.SGTS.Entity.PermisoEntity;
import Backend.SGTS.Entity.RolEntity;
import Backend.SGTS.Entity.RoleEnum;
import Backend.SGTS.Entity.UsuarioEntity;
import Backend.SGTS.Repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SgtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgtsApplication.class, args);
		System.out.println("\n> Servidor iniciado correctamente.");
	}

	@Bean
	CommandLineRunner init(UsuarioRepository userRepository) {
		return args -> {
			/* Create PERMISSIONS */
			PermisoEntity createPermiso = PermisoEntity.builder()
					.nombre("CREATE")
					.build();

			PermisoEntity readPermiso = PermisoEntity.builder()
					.nombre("READ")
					.build();

			PermisoEntity updatePermiso = PermisoEntity.builder()
					.nombre("UPDATE")
					.build();

			PermisoEntity deletePermiso = PermisoEntity.builder()
					.nombre("DELETE")
					.build();

//			PermisoEntity refactorPermission = PermisoEntity.builder()
//					.nombre("REFACTOR")
//					.build();

			/* Create ROLES */
			RolEntity roleAdmin = RolEntity.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permisoList(Set.of(createPermiso, readPermiso, updatePermiso, deletePermiso))
					.build();

			RolEntity roleUser = RolEntity.builder()
					.roleEnum(RoleEnum.OPE_INT)
					.permisoList(Set.of(createPermiso, readPermiso, updatePermiso))
					.build();

			RolEntity roleInvited = RolEntity.builder()
					.roleEnum(RoleEnum.OPE_EXT)
					.permisoList(Set.of(readPermiso, updatePermiso))
					.build();

			RolEntity roleDeveloper = RolEntity.builder()
					.roleEnum(RoleEnum.RRHH)
					.permisoList(Set.of(readPermiso, deletePermiso))
					.build();

			/* CREATE USERS */
			UsuarioEntity userSantiago = UsuarioEntity.builder()
					.username("santiago")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleAdmin))
					.build();

			UsuarioEntity userDaniel = UsuarioEntity.builder()
					.username("daniel")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleUser))
					.build();

			UsuarioEntity userAndrea = UsuarioEntity.builder()
					.username("andrea")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleInvited))
					.build();

			UsuarioEntity userAnyi = UsuarioEntity.builder()
					.username("anyi")
					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(roleDeveloper))
					.build();

			userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));
		};
	}
//}

}