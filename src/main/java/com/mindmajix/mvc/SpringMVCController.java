package com.mindmajix.mvc;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SpringMVCController {

    private final TaskService taskService;

    @GetMapping("external-form")
    public String externalForm(Model model, @RequestParam(name = "taskId") String taskId) {
        model.addAttribute("processVariables", taskService.getVariables(taskId));
        return "external-form";
    }


    @PostMapping("external-form-complete")
    public String externalFormComplete(Model model, @RequestParam(name = "taskId") String taskId) {
        taskService.complete(taskId);
        return "redirect:/camunda/app/tasklist/default/#/";
    }

}
