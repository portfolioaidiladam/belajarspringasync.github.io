package programmerzamannow.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

  @Autowired
  private HelloAsync helloAsync;


  // Belajar Async
  @Test
  void hello() throws InterruptedException {
    for (int i = 0; i < 16; i++) {
      helloAsync.hello();
    }
    log.info("after call hello()");
    Duration duration = Duration.ofSeconds(10);
    long seconds = duration.getSeconds();
    Thread.sleep(seconds);
  }
  // belajar future
  @Test
  void helloName() throws ExecutionException, InterruptedException {
    Future<String> future = helloAsync.hello("Aidil");
    log.info("after call hello(Aidil)");
    String response = future.get();
    log.info(response);
  }
}
