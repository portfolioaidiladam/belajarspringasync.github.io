package programmerzamannow.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component

public class Job {


   //scheduled
  private AtomicLong atomicLong = new AtomicLong(0);

  @Scheduled(initialDelay = 2000, fixedDelay = 2000)
  public void runJob() {
    Long value = atomicLong.incrementAndGet();
    log.info("{} run job {}", value, Thread.currentThread());
  }

  public Long getValue(){
    return atomicLong.get();
  }
  // Cron job
  @Scheduled(cron = "*/2 * * * * *")
  public void cron(){
    log.info("run cron job");
  }
}
