package com.mindmajix.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

    private String employeeId;
    private String email;
    private int age;
    private String expenseDescription;
    private Double amount;

}
