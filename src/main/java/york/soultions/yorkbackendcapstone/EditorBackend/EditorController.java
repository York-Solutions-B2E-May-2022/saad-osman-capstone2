package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class EditorController {

   private EditorPublicService editorPublicService;

   @Autowired
   public EditorController(@NonNull EditorPublicService editorPublicService){
       this.editorPublicService = editorPublicService;
   }
    @PostMapping(
            value= "/here"
    )
    public void d(@RequestBody ArrayList<ProcessEntity> ii){
//        return new ProcessEntity(ii.getAction(), ii.getStep(), new ResponseEmbedd(ii.getResponse().getText(), ii.getResponse().getMultipleChoice(), ii.getResponse().getTrueOrFalse(), ii.getResponse().getVal()),new MutipleChoiceEmbedd(ii.getMultipleChoice().getOne(), ii.getMultipleChoice().getTwo(), ii.getMultipleChoice().getThree(), ii.getMultipleChoice().getFour()));

        ProcessListEntity j = new ProcessListEntity(ii);
//        System.out.println(ii.get(0).getAction());
//        System.out.println(ii.get(0).getStep());
//        System.out.println(ii.get(0).getResponse().getVal());
//        System.out.println(ii.get(0).getResponse().getText());
//        System.out.println(ii.get(0).getResponse().getTrueOrFalse());

        editorPublicService.addProcess(j);
    }
    @GetMapping("/all")
    public List<ProcessEntity> fun(){
       return editorPublicService.sendAll();
    }
}
