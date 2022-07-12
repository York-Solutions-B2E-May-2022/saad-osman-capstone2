package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="process_entity_list")
public class ProcessListEntity {
    @Id
    @SequenceGenerator(
            name = "Id_Sequence",
            sequenceName = "Id_Sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_Sequence"
    )
    @Column( insertable = false, updatable = false)
    private Long id;


    @OneToMany(cascade = {CascadeType.ALL})
    private List<ProcessEntity> processEntityList = new ArrayList<>();

    public ProcessListEntity(ArrayList<ProcessEntity> processEntityList) {
        this.processEntityList = processEntityList;
    }
    public ProcessListEntity(){

    }


}
