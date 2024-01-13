package Backend.SGTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer>{

}
