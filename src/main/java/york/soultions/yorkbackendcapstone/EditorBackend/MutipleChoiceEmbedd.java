package york.soultions.yorkbackendcapstone.EditorBackend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="multiple_choice")
public class MutipleChoiceEmbedd {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Id_SequenceTwo"
    )
    @SequenceGenerator(
            name = "Id_SequenceTwo",
            sequenceName = "sequenceTwo",
            allocationSize = 1
    )
    private Long id;
    private String one;
    private String two;
    private String three;
    private String four;

    public String getOne() {
        return one;
    }

    public String getTwo() {
        return two;
    }

    public String getThree() {
        return three;
    }

    public String getFour() {
        return four;
    }

    public MutipleChoiceEmbedd() {

    }

    public MutipleChoiceEmbedd(String one, String two, String three, String four) {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }
}
