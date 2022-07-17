package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProcessEntityRepository extends JpaRepository<ProcessEntity, Long> {

//    @Query(
//            value = "SELECT process_list_id  FROM process_entity ",
//            nativeQuery = true)
//    List<ProcessEntity> findAllFromProcessEntity();
//    @Query(
//            value = "SELECT process_list_id FROM process_entity Where process_list_id> 0 ",
//            nativeQuery = true)
//    List<ProcessEntity> findGreater();
//    Optional<ProcessEntity> findByTitle(String title);
}
