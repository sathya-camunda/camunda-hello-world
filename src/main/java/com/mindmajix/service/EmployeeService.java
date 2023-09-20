package com.mindmajix.service;

import com.mindmajix.dto.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class EmployeeService {

    public boolean validate(String employeeId) {
        log.info("validate 1");
        return StringUtils.isAlphanumeric(employeeId);
    }

    public boolean validate(Employee employee) {
        log.info("validate 2");
        return StringUtils.isAlphanumeric(employee.getEmployeeId());
    }
}
