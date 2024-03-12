
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.Quarto;
import java.util.List;
import java.util.Optional;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

}