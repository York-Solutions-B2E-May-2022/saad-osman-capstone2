package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@Table(name = "process_entity")
@Data
public class ProcessEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceF"
    )
    @SequenceGenerator(
            name = "Id_SequenceFour",
            sequenceName = "sequenceF",
            allocationSize = 1
    )
    @Column(nullable = false, unique = true)
    private Long id;

    private String action;
    private Integer step;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private ProcessListEntity j = new ProcessListEntity( new ArrayList<ProcessEntity>());

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Long getListId() {
        return ListId;
    }

    public void setListId(Long listId) {
        ListId = listId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setResponse(ResponseEmbedd response) {
        this.response = response;
    }

    public void setMultipleChoice(MutipleChoiceEmbedd multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    private Long ListId;
    private String title;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(referencedColumnName = "id")
//    private ProcessListEntity listi;

    @OneToOne( cascade = {CascadeType.ALL})
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
