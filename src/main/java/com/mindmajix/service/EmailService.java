package com.mindmajix.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    public void send(String from, String to, String subject, String body) {
        log.info("From: {}", from);
        log.info("To: {}", to);
        log.info("Subject: {}", subject);
        log.info("Body: {}", body);
    }
}
