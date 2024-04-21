package Backend.SGTS.Service;

import java.util.List;

import Backend.SGTS.Entity.EmpresaEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.UsuarioEntity;
import Backend.SGTS.Repository.UsuarioRepository;

@Service
public class UsuarioService {

	// Inyecto repositorio
	@Autowired
	UsuarioRepository usuarioRepository;

	// Obtengo todos los usuarios
	public List<UsuarioEntity> getAll() {
		return usuarioRepository.findAll();
	}

	// Obtengo un usuario por id
	public UsuarioEntity getById(Integer id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	// Creo un usuario
	public UsuarioEntity create(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}

	// Actualizo un usuario
	public UsuarioEntity update(UsuarioEntity usuario) {
		return usuarioRepository.save(usuario);
	}


	// Elimino un usuario de manera lógica

	@Transactional
	public void deleteUsuarioLogica(Integer idUsuario) {
		UsuarioEntity usuario = usuarioRepository.findById(idUsuario).orElse(null);
		if (usuario != null && usuario.isEnabled()) {
			usuario.setEnabled(false);
			usuarioRepository.save(usuario);

		}
	}
}
