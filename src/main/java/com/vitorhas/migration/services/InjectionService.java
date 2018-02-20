package com.vitorhas.migration.services;

import com.vitorhas.migration.model.DocProcess;
import com.vitorhas.migration.model.DocViewStaging;
import com.vitorhas.migration.model.ProcessLifecycle;
import com.vitorhas.migration.repository.DocProcessRepository;
import com.vitorhas.migration.repository.DocViewStagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InjectionService {

    @Autowired(required = true)
    DocProcessRepository docProcessRepository;

    @Autowired
    DocViewStagingRepository docViewStagingRepository;

    public String InjectionPass(){
        List<DocViewStaging> list = docViewStagingRepository.findAll();
        for(DocViewStaging docViewStaging : list){
            DocProcess docProcess = new DocProcess();
            docProcess.setIdStatus(docViewStaging.getIdDoc());
            docProcess.setDsStatus(ProcessLifecycle.PENDING.name());
            docProcess.setDsMessage("");
            docProcessRepository.save(docProcess);
        }
        return "Done";
    }
}
