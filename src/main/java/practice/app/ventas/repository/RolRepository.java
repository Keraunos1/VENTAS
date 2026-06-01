package practice.app.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.app.ventas.model.bd.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
    Rol  findByNomrol(String nombrerol);
}
