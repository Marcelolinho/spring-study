package com.passtime.study.cronJobs;

import org.springframework.scheduling.annotation.Scheduled;

public class MailerService {

    @Scheduled(cron = "0 */1 * * * *")
    public void sendEmail() {
        System.out.println("OI!");
    }
}
