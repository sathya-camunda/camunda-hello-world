package com.mindmajix.delegate;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class CheckDataDelegate implements JavaDelegate {


    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        SpinJsonNode response = Spin.JSON(delegateExecution.getVariable("apiResponse"));
        log.info("Employee Id {} ", response.prop("employeeId").stringValue());
        log.info("Amount {} ", response.prop("amount").stringValue());

    }

}
