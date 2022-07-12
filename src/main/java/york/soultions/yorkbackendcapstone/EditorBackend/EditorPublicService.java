package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class EditorPublicService {

    private ProcessListRepository processListRepository;
    private HashMap<UUID, Long> tokenMap;

    @Autowired
    public EditorPublicService(@NonNull ProcessListRepository processListRepository){
        this.processListRepository = processListRepository;
        this.tokenMap = new HashMap<>();
    }

    public void addProcess(ProcessListEntity processListEntity){
        processListRepository.save(processListEntity);
    }
}
