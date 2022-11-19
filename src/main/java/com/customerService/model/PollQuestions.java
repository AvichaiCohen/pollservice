package com.customerService.model;


public class PollQuestions {
    private Long customerId;
    private Long firstQuestion;
    private Long secondQuestion;
    private Long thirdQuestion;
    private Long fourthQuestion;

    public PollQuestions(Long customerId, Long firstQuestion, Long secondQuestion, Long thirdQuestion, Long fourthQuestion) {
        this.customerId = customerId;
        this.firstQuestion = firstQuestion;
        this.secondQuestion = secondQuestion;
        this.thirdQuestion = thirdQuestion;
        this.fourthQuestion = fourthQuestion;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getFirstQuestion() {
        return firstQuestion;
    }

    public Long getSecondQuestion() {
        return secondQuestion;
    }

    public Long getThirdQuestion() {
        return thirdQuestion;
    }

    public Long getFourthQuestion() {
        return fourthQuestion;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setFirstQuestion(Long firstQuestion) {
        this.firstQuestion = firstQuestion;
    }

    public void setSecondQuestion(Long secondQuestion) {
        this.secondQuestion = secondQuestion;
    }

    public void setThirdQuestion(Long thirdQuestion) {
        this.thirdQuestion = thirdQuestion;
    }

    public void setFourthQuestion(Long fourthQuestion) {
        this.fourthQuestion = fourthQuestion;
    }
}