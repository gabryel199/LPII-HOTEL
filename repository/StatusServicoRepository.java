import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.StatusServico;
import java.util.List;
import java.util.Optional;

public interface StatusServicoRepository extends JpaRepository<StatusServico, Long> {

}