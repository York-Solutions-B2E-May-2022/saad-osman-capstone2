package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EditorPublicService {

    private ProcessListRepository processListRepository;
    private ProcessEntityRepository processEntityRepository;
    private HashMap<UUID, Long> tokenMap;

    @Autowired
    public EditorPublicService(@NonNull ProcessListRepository processListRepository, @NonNull ProcessEntityRepository processEntityRepository){
        this.processListRepository = processListRepository;
        this.processEntityRepository = processEntityRepository;
        this.tokenMap = new HashMap<>();
    }

    public void addProcess(ProcessListEntity processListEntity){
        processListRepository.save(processListEntity);
    }
    public List<ProcessEntity> sendAll () {
        return processEntityRepository.findGreater();
        //return processEntityRepository.findAllFromProcessEntity();
    }

}
