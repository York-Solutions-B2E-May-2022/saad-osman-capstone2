package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessListRepository extends JpaRepository<ProcessListEntity, Long> {
}
