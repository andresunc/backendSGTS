package Backend.SGTS.Repository;

import org.springframework.stereotype.Repository;
import Backend.SGTS.Entity.CategoriaEntity;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {

}