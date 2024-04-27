package Backend.SGTS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Backend.SGTS.Entity.CategoriaEntity;
import Backend.SGTS.Entity.DependenciaEntity;
import Backend.SGTS.Repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	// Obtener todas las categorias
		public List<CategoriaEntity> getAll() {
			return categoriaRepository.findAll();
		}
		
		// Obtener una categoria por id
		public CategoriaEntity getById(Integer id) {
			return categoriaRepository.findById(id).orElse(null);
		}
		
		// Creo una categoria
		public CategoriaEntity create(CategoriaEntity categoria) {
			return categoriaRepository.save(categoria);
		}
		
		// Actualizo una categoria
		public CategoriaEntity update(CategoriaEntity categoria) {
			return categoriaRepository.save(categoria);
		}
		
		// Elimino una categoria
		public void delete(Integer id) {
			categoriaRepository.deleteById(id);
		}
}
