package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessEntityRepository extends JpaRepository<ProcessEntity, Long> {

    @Query(
            value = "SELECT * FROM process_entity",
            nativeQuery = true)
    List<ProcessEntity> findAllFromProcessEntity();
    @Query(
            value = "SELECT process_list_id FROM process_entity Where process_list_id> 0 ",
            nativeQuery = true)
    List<ProcessEntity> findGreater();
}
