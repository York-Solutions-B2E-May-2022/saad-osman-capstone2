package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class EditorController {

    @GetMapping("/")
    public String j(){
        return "hello";
    }
}
