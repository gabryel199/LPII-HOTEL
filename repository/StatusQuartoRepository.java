import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.StatusQuarto;
import java.util.List;
import java.util.Optional;

public interface StatusQuartoRepository extends JpaRepository<StatusQuarto, Long> {

}