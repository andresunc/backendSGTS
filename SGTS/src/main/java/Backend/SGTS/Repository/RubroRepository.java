package Backend.SGTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.RubroEntity;

@Repository
public interface RubroRepository extends JpaRepository<RubroEntity, Integer> {

}
