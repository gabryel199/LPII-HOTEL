import org.springframework.data.jpa.repository.JpaRepository;

import com.example.scaapi.model.entity.Uf;
import java.util.List;
import java.util.Optional;

public interface UfRepository extends JpaRepository<Uf, Long> {

}