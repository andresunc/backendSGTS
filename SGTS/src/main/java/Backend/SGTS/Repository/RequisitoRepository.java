package Backend.SGTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.RequisitoEntity;

@Repository
public interface RequisitoRepository extends JpaRepository<RequisitoEntity, Integer> {

}