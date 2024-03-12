import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.TipoCama;
import java.util.List;
import java.util.Optional;

public interface TipoCamaRepository extends JpaRepository<TipoCama, Long> {

}