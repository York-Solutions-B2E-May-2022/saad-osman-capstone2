package york.soultions.yorkbackendcapstone.FollowerBackend;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class FollowerController {
    @GetMapping("/j")
    public String jd(){
        return "hi";
    }

}
