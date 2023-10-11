package com.mindmajix.mvc;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.migration.MigrationPlan;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ModifyMigrateController {

    private final RuntimeService runtimeService;

    @GetMapping("modifyProcess")
    public String modifyProcess() {
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
                        .processDefinitionKey("loan_application")
                                .list();
        runtimeService.createProcessInstanceModification(processInstances.get(0).getProcessInstanceId())
                .startBeforeActivity("Activity_0hu0etm")
                .setVariables(Map.of("var1", "value1", "var2", "value2"))
                .cancelAllForActivity("Activity_0ftzbp2")
                .execute();
        return "redirect:/camunda/app/cockpit/default/#/processes";
    }

    @GetMapping("migrateProcess")
    public String migrateProcess() {

        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery()
                .processDefinitionKey("loan_apllication_migration")
                .list();
        //TODO Specify correct source and target process definition ids
        MigrationPlan migrationPlan = runtimeService.createMigrationPlan("120ffb4a-6855-11ee-ade7-1e5bf8b5f6ed", "296508ed-6855-11ee-ade7-1e5bf8b5f6ed")
                .mapEqualActivities()
                .mapActivities("validate_address", "validate_postal_address")
                .setVariables(Map.of("var1", "value1", "var2", "value2"))
                .build();

        runtimeService.newMigration(migrationPlan)
                .processInstanceIds(processInstances.get(0).getProcessInstanceId())
                .execute();

        return "redirect:/camunda/app/cockpit/default/#/processes";
    }
}
