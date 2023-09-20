package com.mindmajix.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogFeedbackDelegate implements JavaDelegate {

    private final Logger log = LoggerFactory.getLogger(LogFeedbackDelegate.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println(delegateExecution.getVariable("name"));
        System.out.println(delegateExecution.getVariable("message"));
    }


}

