import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.ServicoSolicitado;
import java.util.List;
import java.util.Optional;

public interface ServicoSolicitadoRepository extends JpaRepository<ServicoSolicitado, Long> {

}