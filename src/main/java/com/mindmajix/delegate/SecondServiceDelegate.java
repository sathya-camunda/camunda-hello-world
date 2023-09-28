package com.mindmajix.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SecondServiceDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        try {
            log.info("Calling second service");
            Boolean isErrorFixed = (Boolean) delegateExecution.getVariable("isErrorFixed");
            if (isErrorFixed == null) {
                throw new RuntimeException("Test");
            }
        } catch (Exception e) {
            throw new BpmnError("Test");
        }

    }

}
