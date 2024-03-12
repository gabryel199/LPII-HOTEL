import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.TipoQuartosReserva;
import java.util.List;
import java.util.Optional;

public interface TipoQuartosReservaRepository extends JpaRepository<TipoQuartosReserva, Long> {

}