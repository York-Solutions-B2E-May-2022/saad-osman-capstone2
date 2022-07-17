package york.soultions.yorkbackendcapstone.FollowerBackend;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import york.soultions.yorkbackendcapstone.EditorBackend.EditorPublicService;
import york.soultions.yorkbackendcapstone.EditorBackend.ProcessListEntity;

import java.util.UUID;

@CrossOrigin
@RestController
public class FollowerController {
    private final FollowerPublicService followerPublicService;

    @Autowired
    public FollowerController(@NonNull FollowerPublicService followerPublicService) {
        this.followerPublicService = followerPublicService;
    }
    @PutMapping(
            value = "/submitProcess/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void submitProcess(@RequestBody ProcessListEntity entity, @PathVariable Long id){
        followerPublicService.submitFollowerProcess(entity, id);
    }

    @GetMapping(
            value="/startToken"
    )
    public UUID startToken(@RequestParam Long id){
        System.out.println(id);
        return followerPublicService.startToken(id);
    }

    @PostMapping(
            value="/removeToken"
    )
    public void tokenRemove(@RequestBody UUID token){
        followerPublicService.tokenFollowerRemove(token);
    }

}
