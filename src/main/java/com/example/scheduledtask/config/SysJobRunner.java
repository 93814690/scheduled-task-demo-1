package com.example.scheduledtask.config;

import com.example.scheduledtask.dao.SysJobMapper;
import com.example.scheduledtask.domain.SysJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SysJobRunner implements CommandLineRunner {

    private final SysJobMapper sysJobMapper;
    private final CronTaskRegistrar cronTaskRegistrar;

    public SysJobRunner(SysJobMapper sysJobMapper, CronTaskRegistrar cronTaskRegistrar) {
        this.sysJobMapper = sysJobMapper;
        this.cronTaskRegistrar = cronTaskRegistrar;
    }

    @Override
    public void run(String... args) {
        List<SysJob> sysJobs = sysJobMapper.listAllByStatus(1);
        for (SysJob job : sysJobs) {
            SchedulingRunnable task = new SchedulingRunnable(job.getBeanName(), job.getMethodName(), job.getMethodParam());
            cronTaskRegistrar.addCronTask(task, job.getCron());
        }
        log.info("定时任务已加载完毕...");
    }
}
