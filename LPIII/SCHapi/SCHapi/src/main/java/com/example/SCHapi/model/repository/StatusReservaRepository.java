import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.StatusReserva;
import java.util.List;
import java.util.Optional;

public interface StatusReservaRepository extends JpaRepository<StatusReserva, Long> {

}