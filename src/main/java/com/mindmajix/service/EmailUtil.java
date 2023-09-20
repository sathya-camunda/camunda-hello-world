package com.mindmajix.service;

import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

    public String getRejectionText() {
        return "Sorry! Your application gas been declined.";
    }

    public String getResubmissionText() {
        return "Your application is inactive. Please submit again.";
    }

    public String getInprogressText() {
        return "Your application is inprogress. We will update the outcome.";
    }
}
