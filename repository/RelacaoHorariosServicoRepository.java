import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.Recepcionista;
import java.util.List;
import java.util.Optional;

public interface RelacaoHorariosServicoRepository extends JpaRepository<RelacaoHorariosServico, Long> {

}