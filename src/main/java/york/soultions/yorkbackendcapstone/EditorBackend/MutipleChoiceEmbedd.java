package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

//@Data
//@Entity
//@Table(name="multiple_choice")
@Embeddable
public class MutipleChoiceEmbedd {

    private String one;
    private String two;
    private String three;
    private String four;


    public MutipleChoiceEmbedd() {

    }

    public MutipleChoiceEmbedd(String one, String two, String three, String four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }

    public MutipleChoiceEmbedd(MutipleChoiceEmbedd mutipleChoiceEmbedd) {
        this.one = mutipleChoiceEmbedd.getOne();
        this.two = mutipleChoiceEmbedd.getTwo();
        this.three = mutipleChoiceEmbedd.getThree();
        this.four = mutipleChoiceEmbedd.getFour();
    }

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    public String getFour() {
        return four;
    }

    public void setFour(String four) {
        this.four = four;
    }
}
