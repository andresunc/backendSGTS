package Backend.SGTS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Backend.SGTS.Entity.RolEntity;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer>{
    List<RolEntity> findByRoleEnumIn(List<String> roleNames);
}
