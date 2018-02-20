package com.vitorhas.migration.controller;

import com.vitorhas.migration.model.DocProcess;
import com.vitorhas.migration.model.DocViewStaging;
import com.vitorhas.migration.model.ProcessLifecycle;
import com.vitorhas.migration.repository.DocViewStagingRepository;
import com.vitorhas.migration.repository.DocProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Future;

@RestController
public class MigrationController {
    @Autowired(required = true)
    DocProcessRepository docProcessRepository;

    @Autowired
    DocViewStagingRepository docViewStagingRepository;

    @RequestMapping("/docstatus")
    public ResponseEntity<List<DocProcess>> getAllDocStatus() {
        return ResponseEntity.ok(docProcessRepository.findAll());
    }

    @RequestMapping("/getsqlserver")
    public ResponseEntity<String> getsqlserver() {
        List<DocViewStaging> list = docViewStagingRepository.findAll();
        for (DocViewStaging docViewStaging : list) {
            DocProcess docProcess = new DocProcess();
            docProcess.setIdStatus(docViewStaging.getIdDoc());
            docProcess.setDsStatus(ProcessLifecycle.PENDING.name());
            docProcess.setDsMessage("");
            docProcessRepository.save(docProcess);
        }
        return ResponseEntity.ok("Included");
    }

    @RequestMapping("/")
    public String index() {
        return "Migration ECM Tool";
    }


    @Async
    @RequestMapping("/testThread")
    public Future<String> testThread(){
        System.out.println("Execute method async" + Thread.currentThread().getName());
        try{
            Thread.sleep(10000);
            System.out.println("HELLOOOOOO" + Thread.currentThread().getName());
            return new AsyncResult<String>("Hello!");
        }catch (InterruptedException e){
            System.out.print(e);
        }
        return null;
    }
}
