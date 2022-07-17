package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


//@AllArgsConstructor
//@Data
//@Entity
//@Table(name="response")
@Embeddable
public class ResponseEmbedd {
    private Boolean text;
    private Boolean multipleChoice;
    private Boolean trueOrFalse;
    private String val;

    public ResponseEmbedd(Boolean text, Boolean multipleChoice, Boolean trueOrFalse, String val) {
        this.text = text;
        this.multipleChoice = multipleChoice;
        this.trueOrFalse = trueOrFalse;
        this.val = val;
    }
    public ResponseEmbedd(){

    }

    public ResponseEmbedd(ResponseEmbedd responseEmbedd) {
        this.multipleChoice = responseEmbedd.getMultipleChoice();
        this.trueOrFalse = responseEmbedd.getTrueOrFalse();
        this.text = responseEmbedd.getText();
        this.val = responseEmbedd.getVal();
    }

    public Boolean getText() {
        return text;
    }

    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(Boolean multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public Boolean getTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
