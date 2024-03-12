import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}