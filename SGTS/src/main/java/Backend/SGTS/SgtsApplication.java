package Backend.SGTS;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgtsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgtsApplication.class, args);
		LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        System.out.println("\n> Servidor iniciado correctamente a las: " + formattedNow);
	}

//	@Bean
//	CommandLineRunner init(UsuarioRepository userRepository) {
//		return args -> {
//			/* Create PERMISSIONS */
//			PermisoEntity createPermiso = PermisoEntity.builder()
//					.nombre("CREATE")
//					.build();
//
//			PermisoEntity readPermiso = PermisoEntity.builder()
//					.nombre("READ")
//					.build();
//
//			PermisoEntity updatePermiso = PermisoEntity.builder()
//					.nombre("UPDATE")
//					.build();
//
//			PermisoEntity deletePermiso = PermisoEntity.builder()
//					.nombre("DELETE")
//					.build();
//
//			PermisoEntity refactorPermission = PermisoEntity.builder()
//					.nombre("REFACTOR")
//					.build();
//
//			/* Create ROLES */
//			RolEntity roleAdmin = RolEntity.builder()
//					.roleEnum(RoleEnum.ADMIN)
//					.permisoList(Set.of(createPermiso, readPermiso, updatePermiso, deletePermiso))
//					.build();
//
//			RolEntity roleUser = RolEntity.builder()
//					.roleEnum(RoleEnum.OPE_INT)
//					.permisoList(Set.of(createPermiso, readPermiso, updatePermiso))
//					.build();
//
//			RolEntity roleInvited = RolEntity.builder()
//					.roleEnum(RoleEnum.OPE_EXT)
//					.permisoList(Set.of(readPermiso, updatePermiso))
//					.build();
//
//			RolEntity roleDeveloper = RolEntity.builder()
//					.roleEnum(RoleEnum.RRHH)
//					.permisoList(Set.of(readPermiso, deletePermiso))
//					.build();
//
//			/* CREATE USERS */
//			UsuarioEntity userSantiago = UsuarioEntity.builder()
//					.username("santiago")
//					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//												.roles(Set.of(roleAdmin))
//					.build();
//
//			UsuarioEntity userDaniel = UsuarioEntity.builder()
//					.username("daniel")
//					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleUser))
//					.build();
//
//			UsuarioEntity userAndrea = UsuarioEntity.builder()
//					.username("andrea")
//					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleInvited))
//					.build();
//
//			UsuarioEntity userAnyi = UsuarioEntity.builder()
//					.username("anyi")
//					.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
//					.isEnabled(true)
//					.accountNoExpired(true)
//					.accountNoLocked(true)
//					.credentialNoExpired(true)
//					.roles(Set.of(roleDeveloper))
//					.build();
//
//			userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi));
//		};
//	}
//
// superplayer
// grupogreen.2024!!
}

