package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="process_list_entity")
public class ProcessListEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceT"
    )
    @SequenceGenerator(
            name = "Id_SequenceThree",
            sequenceName = "sequenceT",
            allocationSize = 1
    )
    @Column(nullable = false, unique = true)
    private Long id;



    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName ="id" )
    private List<ProcessEntity> processList = new ArrayList<>();

    private Long processListId;

    public ProcessListEntity(ArrayList<ProcessEntity> processEntityList) {
        this.processList = processEntityList;
        this.processListId = this.id;
    }
    public ProcessListEntity(){

    }


}
