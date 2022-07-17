package york.soultions.yorkbackendcapstone.FollowerBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import york.soultions.yorkbackendcapstone.EditorBackend.ProcessEntity;
import york.soultions.yorkbackendcapstone.EditorBackend.ProcessEntityRepository;
import york.soultions.yorkbackendcapstone.EditorBackend.ProcessListEntity;
import york.soultions.yorkbackendcapstone.EditorBackend.ProcessListRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class FollowerPublicService {
    private ProcessListRepository processListRepository;
    private ProcessEntityRepository processEntityRepository;
    private HashMap<UUID, Long> tokenMap;

    @Autowired
    public FollowerPublicService(@NonNull ProcessListRepository processListRepository, @NonNull ProcessEntityRepository processEntityRepository){
        this.processListRepository = processListRepository;
        this.processEntityRepository = processEntityRepository;
        this.tokenMap = new HashMap<>();
    }

    public void submitFollowerProcess(ProcessListEntity entity, Long id){
        Optional<ProcessListEntity> obj = processListRepository.findById(id);
        if(obj.isPresent()){
            obj.map(e->{
                e.setFinished(true);
                e.setProcessList((ArrayList<ProcessEntity>) entity.getProcessList());
                return processListRepository.save(e);
            });
        }else
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    public UUID startToken(Long id){
        final UUID token = UUID.randomUUID();
        tokenMap.put(token, id);
        return token;
    }

    public void tokenFollowerRemove(UUID token){
        if(tokenMap.containsKey(token)){
            tokenMap.remove(token);
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
