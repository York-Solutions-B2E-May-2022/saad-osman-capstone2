package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@Data
@Entity
@Table(name="response")
public class ResponseEmbedd {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceOne"
    )
    @SequenceGenerator(
            name = "Id_SequenceOne",
            sequenceName = "sequenceOne",
            allocationSize = 1
    )
    private Long id;
    private Boolean text;
    private Boolean multipleChoice;
    private Boolean trueOrFalse;
    private String val;

    public Boolean getText() {
        return text;
    }

    public Boolean getMultipleChoice() {
        return multipleChoice;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public String getVal() {
        return val;
    }

    public ResponseEmbedd(Boolean text, Boolean multipleChoice, Boolean trueOrFalse, String val) {
        this.text = text;
        this.multipleChoice = multipleChoice;
        this.trueOrFalse = trueOrFalse;
        this.val = val;
    }
    public ResponseEmbedd(){

    }
}
