package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
public class EditorController {

   private final EditorPublicService editorPublicService;

   @Autowired
   public EditorController(@NonNull EditorPublicService editorPublicService){
       this.editorPublicService = editorPublicService;
   }
    @PostMapping(
            value= "/here"
    )
    public void d(@RequestBody ProcessListEntity ii){
        ProcessListEntity j = new ProcessListEntity((ArrayList<ProcessEntity>) ii.getProcessList(),ii.getTitle(), ii.getFinished());
        System.out.println(j.getTitle());
        editorPublicService.addProcess(j);
    }
    @GetMapping("/all")
    public List<ProcessListEntity> fun(){
       return editorPublicService.sendAll();
    }

    @DeleteMapping("/deleteProcess/{id}")
    public void deleteProcess(@PathVariable Long id){
       System.out.println(id);
        editorPublicService.deleteProcess(id);
    }

    @PutMapping(
            value = "/editTitle/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void editTitle(@RequestBody String title, @PathVariable Long id){
       editorPublicService.editTitleText(title, id);
    }
    @DeleteMapping(value = "/deleteAction/{id}")
    public void deleteAction(@RequestBody ProcessEntity entity, @PathVariable Long id){
       editorPublicService.deleteBackendAction(entity, id);
    }
    @PostMapping(
            value = "/addAdditonalAction/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void addAdditonalAction(@RequestBody ProcessEntity entity, @PathVariable Long id){
       editorPublicService.addAdditonalActionBC(entity , id);
    }
    @PutMapping(
            value = "/editStage/{objId}/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void editStage(@RequestBody ProcessEntity entity, @PathVariable Long objId, @PathVariable Long id){
       editorPublicService.editStageAction(entity, objId, id);
    }
}
