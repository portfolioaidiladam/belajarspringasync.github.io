package programmerzamannow.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@Component
public class HelloAsync {
  // belajar future tambahkan TaskExecutor
  // Menambah Executor tambahkan singleTaskExecutor
  @Async("singleTaskExecutor")
  @SneakyThrows
  public Future<String> hello(final String name) {
    CompletableFuture<String> future = new CompletableFuture<>();
    Thread.sleep(Duration.ofSeconds(2).toMillis());
    future.complete("Hello " + name + " from Thread " + Thread.currentThread());
    return future;
  }
  // belajaar Async, tinggal panggil @Async dia langsung otomatis menjalankan menggunakan threadpool yang terpisah
  @Async
  @SneakyThrows
  public void hello() {
    Duration duration = Duration.ofSeconds(2);
    //long seconds = duration.getSeconds();
    Thread.sleep(duration.toMillis());
    log.info("hello after 2 seconds {}", Thread.currentThread());
  }

}
