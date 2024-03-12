import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}