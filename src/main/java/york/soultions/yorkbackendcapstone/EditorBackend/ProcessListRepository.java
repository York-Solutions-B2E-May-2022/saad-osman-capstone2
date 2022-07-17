package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProcessListRepository extends JpaRepository<ProcessListEntity, Long> {
    Optional<ProcessListEntity> findByTitle(String title);
}
