package york.soultions.yorkbackendcapstone.EditorBackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.*;

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

    public void addProcess(ProcessListEntity j){
        if(processListRepository.findByTitle(j.getTitle()).isPresent()) {
            System.out.println("not on my watch");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        processListRepository.save(j);
    }
    public List<ProcessListEntity> sendAll () {
        return processListRepository.findAll();
    }
    public void deleteProcess(Long id){
        Optional<ProcessListEntity> process = processListRepository.findById(id);
        if(process.isPresent()){
            processListRepository.deleteById(id);
        }else
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
    }
    public void editTitleText(String title, Long id){
        Optional<ProcessListEntity> obj = processListRepository.findById(id);
        if(obj.isPresent()){
            obj.map(e->{
                e.setTitle(title);
                return processListRepository.save(e);
            });
        }
    }
    @Transactional
    public void deleteBackendAction(ProcessEntity entity, Long id){
        Optional<ProcessListEntity> obj = processListRepository.findById(id);
        processEntityRepository.deleteById(entity.getId());
        return;
    }
    public void addAdditonalActionBC(ProcessEntity entity, Long id){
        Optional<ProcessListEntity> obj = processListRepository.findById(id);
        System.out.println(obj.get().getId());
        if(obj.isPresent()){
            System.out.println("skldfj");
            obj.get().getProcessList().add(entity);
            processListRepository.save(obj.get());
        }
    }

    public void editStageAction(ProcessEntity entity,Long objId, Long id){
        Optional<ProcessListEntity> obj = processListRepository.findById(objId);
        if(obj.isPresent()){
            List<ProcessEntity> listObj = obj.get().getProcessList();
            for(int i = 0; i<listObj.size() ; i++){
                if(Objects.equals(listObj.get(i).getId(), id)){
                    processEntityRepository.findById(id).map(e->{
                        e.setAction(entity.getAction());
                        e.setStep(entity.getStep());
                        e.setMutipleChoiceEmbedd(new MutipleChoiceEmbedd(entity.getMutipleChoiceEmbedd()));
                        e.setResponseEmbedd(new ResponseEmbedd(entity.getResponseEmbedd()));
                        return processEntityRepository.save(e);
                    });
                }
            }
        }
    }
}
