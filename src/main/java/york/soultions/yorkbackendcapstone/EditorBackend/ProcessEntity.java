package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@AllArgsConstructor
@Data
public class ProcessEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceF"
    )
    @SequenceGenerator(
            name = "Id_SequenceF",
            sequenceName = "sequenceF",
            allocationSize = 1
    )
    @Column(nullable = false, unique = true)
    private Long id;

    private String action;
    private Integer step;
    private String answer;

    @Embedded
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ResponseEmbedd responseEmbedd;

    @Embedded
    @OnDelete(action = OnDeleteAction.CASCADE)
    private MutipleChoiceEmbedd mutipleChoiceEmbedd;


    public ProcessEntity(){
    }

    public ProcessEntity(String action, String answer, Integer step, ResponseEmbedd responseEmbedd, MutipleChoiceEmbedd mutipleChoiceEmbedd) {
        this.action = action;
        this.step = step;
        this.answer = answer;
        this.responseEmbedd = new ResponseEmbedd(responseEmbedd);
        this.mutipleChoiceEmbedd = new MutipleChoiceEmbedd(mutipleChoiceEmbedd);
    }

    public ProcessEntity(String action, Integer step){
        this.action = action;
        this.step = step;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ResponseEmbedd getResponseEmbedd() {
        return responseEmbedd;
    }

    public void setResponseEmbedd(ResponseEmbedd responseEmbedd) {
        this.responseEmbedd = responseEmbedd;
    }

    public MutipleChoiceEmbedd getMutipleChoiceEmbedd() {
        return mutipleChoiceEmbedd;
    }

    public void setMutipleChoiceEmbedd(MutipleChoiceEmbedd mutipleChoiceEmbedd) {
        this.mutipleChoiceEmbedd = mutipleChoiceEmbedd;
    }


}
