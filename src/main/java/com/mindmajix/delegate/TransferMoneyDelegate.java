package com.mindmajix.delegate;

import com.mindmajix.dto.Employee;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransferMoneyDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) throws Exception {


        execution.setVariable("employeeObject",
                Employee.builder()
                        .employeeId("A12")
                        .age(23)
                        .email("A12@mindmajix.com")
                        .expenseDescription("Bought books")
                        .amount(9999.98)
                        .build());

        log.info("Transferring {} to {}", execution.getVariable("amount"), execution.getVariable("employeeId"));
    }
}
