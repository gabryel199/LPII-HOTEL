import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.TipoServico;
import java.util.List;
import java.util.Optional;

public interface TipoServicoRepository extends JpaRepository<TipoServico, Long> {

}