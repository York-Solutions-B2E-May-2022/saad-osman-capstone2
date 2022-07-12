package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Table(name = "process_entity")
@Data
public class ProcessEntity {
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
    @Column( insertable = false, updatable = false, name="entity_id")
    private Long id;

    private String action;
    private Integer step;

    @OneToOne( cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private ResponseEmbedd response;

    @OneToOne(cascade = {CascadeType.ALL})
    private MutipleChoiceEmbedd multipleChoice;

    public String getAction() {
        return action;
    }

    public Integer getStep() {
        return step;
    }

    public ResponseEmbedd getResponse() {
        return response;
    }

    public MutipleChoiceEmbedd getMultipleChoice() {
        return multipleChoice;
    }

    public ProcessEntity(String action, Integer step, ResponseEmbedd response, MutipleChoiceEmbedd multipleChoice){
        this.action = action;
        this.step = step;
        this.response = response;
        this.multipleChoice = multipleChoice;
    }
    public ProcessEntity(){

    }

}
