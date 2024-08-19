package programmerzamannow.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


@Configuration
public class AsyncConfiguration {

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

  // belajar Menambah Executor
  @Bean
  public Executor singleTaskExecutor(){
    return Executors.newSingleThreadExecutor();
  }
}
