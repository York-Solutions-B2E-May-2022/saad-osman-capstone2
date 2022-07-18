package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ProcessListEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceT"
    )
    @SequenceGenerator(
            name = "Id_SequenceT",
            sequenceName = "sequenceT",
            allocationSize = 1
    )
    @Column(nullable = false, unique = true)
    private Long id;

    private String title;
    private Boolean finished;

    @OneToMany( cascade = CascadeType.ALL )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(referencedColumnName = "id")
    private List<ProcessEntity> processList = new ArrayList<>();

    public ProcessListEntity(ArrayList<ProcessEntity> processList, String title, Boolean finished){
        this.title = title;
        this.processList = processList;
        this.finished = finished;
    }

    public ProcessListEntity(){

    }


    public List<ProcessEntity> getProcessList() {
        return processList;
    }

    public void setProcessList(ArrayList<ProcessEntity> processList) {
        this.processList = processList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

//    public void setProcessList(List<ProcessEntity> processList) {
//        this.processList = processList;
//    }
}
