package com.crm.base.springbatch;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TaskletDemo implements Tasklet {

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        return RepeatStatus.FINISHED;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext context;
        JobParametersBuilder jobPara = new JobParametersBuilder(); //设置文件路径参数  
        context = new FileSystemXmlApplicationContext("classpath*:/spring.xml");
        String jobName = "ioSampleJob";
        Job job = (Job) context.getBean(jobName);
        JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
        JobExecution result = null;
        try {
            result = launcher.run(job, jobPara.toJobParameters());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
        ExitStatus es = result.getExitStatus();
        if (es.getExitCode().equals(ExitStatus.COMPLETED.getExitCode())) //任务正常完成  
        {
            System.out.println("任务正常完成");
        } else {
            System.out.println("任务失败");
        }
    }
}
