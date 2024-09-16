package programmerzamannow.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Configuration
public class AsyncConfiguration {


  // Custome Scheduled Executor
  @Bean
  public ScheduledExecutorService taskScheduler(){
    return Executors.newScheduledThreadPool(10);
  }

  // belajar Custom Executor
  /*@Bean
  public Executor taskExecutor(){
    //ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    return Executors.newVirtualThreadPerTaskExecutor();
  }*/

  @Bean
  public Executor taskExecutor(){
    return Executors.newFixedThreadPool(10);  // Gantikan sesuai kebutuhan
  }

  // belajar Dyanamic Executor
  @Bean
  public Executor singleTaskExecutor(){
    return Executors.newSingleThreadExecutor();
  }
}
