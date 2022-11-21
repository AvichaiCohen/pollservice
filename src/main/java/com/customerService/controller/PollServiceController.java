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
    private InternalCustomerService internalCustomerService;


    @GetMapping(value = "/questions")
    public String getQA() {
        return "new poll";
    }
    @GetMapping(value = "/check/{customerId}")
    public InternalCustomer checkUser(@PathVariable Long customerId) throws Exception{
        InternalCustomer existingCustomer = internalCustomerService.getInternalCustomerById(customerId);
        if (existingCustomer == null) {
            throw new Error("no such customer exist");
        }else {
            return existingCustomer;
        }
    }

    @PostMapping(value = "/create")
    public String createAnswersById(@RequestBody PollQuestions pollQuestions) throws Exception {
        InternalCustomer existingCustomer = internalCustomerService.getInternalCustomerById(pollQuestions.getCustomerId());
        if (existingCustomer == null) {
            throw new Exception("no customer with this id is found");
        }
        else {
            pollService.createAnswersById(pollQuestions.getCustomerId(), pollQuestions);
            return "Created a submission to the Poll Service";
        }
    }

    @PutMapping(value = "/update")
    public String updateAnswersById(@RequestBody PollQuestions pollQuestions) throws Exception {
        InternalCustomer existingCustomer = internalCustomerService.getInternalCustomerById(pollQuestions.getCustomerId());
        if (existingCustomer == null) {
            throw new Exception("no customer with this id is found");
        } else {
            pollService.updateAnswersById(pollQuestions.getCustomerId(), pollQuestions);
            return "Answers Updated";
        }
    }

    @DeleteMapping(value = "/delete/{customerId}")
    public String deleteAnswersById(@PathVariable Long customerId){
        InternalCustomer existingCustomer = internalCustomerService.getInternalCustomerById(customerId);
        if (existingCustomer == null) {
            return "no user found";
        } else {
            pollService.deleteAnswersById(customerId);
            return "Deleted Answers of " + existingCustomer.getFirstName() + " " + existingCustomer.getLastName();
        }
    }
}

