package com.crm.base.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ReadDemo<T> extends FlatFileItemReader<T> {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath*:/spring.xml");
		JobLauncher launcher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("dbJob1");

		try {

			// JOB执行，设置参数添加读取文件的路径
			JobExecution result = launcher.run(job,
					// 添加job参数时，将读取的文件目录加入到job的参数中
					new JobParametersBuilder().addString("inputFile", "D:/batchfile/imputFile*.csv").toJobParameters());
			// 运行结果输出
			System.out.println(result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
