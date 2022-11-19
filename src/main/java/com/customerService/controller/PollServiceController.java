package com.customerService.controller;

import com.customerService.model.InternalCustomer;
import com.customerService.model.PollQuestions;
import com.customerService.repository.PollServiceRepository;
import com.customerService.service.InternalCustomerService;
import com.customerService.service.PollService;
import org.apache.tomcat.jni.Poll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
@RequestMapping("/pollService")

@RestController
public class PollServiceController {

    @Autowired
    private PollService pollService;
    @Autowired
    PollServiceRepository pollServiceRepository;

    @Autowired
    private InternalCustomerService internalCustomerService;


    @GetMapping (value = "/questions")
    public String  getQA(){
        return "new poll";
    }

    @PostMapping(value = "/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PollQuestions createAnswersById(@RequestBody PollQuestions pollQuestions) throws Exception {
       try{
           internalCustomerService.getInternalCustomerById(pollQuestions.getCustomerId());
           }
       catch (Exception exception){
           throw new Exception("no customer with this id is found");
       }
        pollServiceRepository.createPollAnswersById(pollQuestions.getCustomerId(),pollQuestions);
       return pollQuestions;
    }

    @PutMapping(value = "/{customerId}/update")
    public void updateAnswersById(@PathVariable Long customerId,
                                   @RequestBody PollQuestions pollQuestions) throws Exception {
        pollService.updateAnswersById(customerId, pollQuestions);
    }

    @DeleteMapping(value = "/{customerId}/delete")
    public void deleteAnswersById(@PathVariable Long customerId) throws Exception {
        pollService.deleteAnswersById(customerId);
    }

    @GetMapping(value = "/{customerId}")
    public InternalCustomer getInternalCustomerById(@PathVariable Long customerId) {
        return internalCustomerService.getInternalCustomerById(customerId);
    }
}

