import com.sun.xml.internal.ws.util.CompletedFuture;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-09-16 16:43
 */
public class CompletableFutureTest {
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello").thenApply(s -> s + "world!");
        System.out.println(future.get());
        future.thenApply(s -> s+"world!");
        System.out.println(future.get());
    }

    @Test
    public void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.completedFuture("hello,").thenApply(s -> s + "world!").thenApply(s -> s + "nice!");
        System.out.println(future.get());
        future.thenApply(s -> s+"!!!");
        System.out.println(future.get());
    }

    @Test
    public void test3()
    {
        CompletableFuture.completedFuture("hello!").thenApply(s -> s + "world!").thenApply(s -> s+ ",nice!")
                .thenAccept(System.out :: println);
        CompletableFuture.completedFuture("hello!").thenApply(s -> s +"world!")
                .thenRun( () -> System.out.println("hello!"));
    }

    @Test
    public void test4() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
                .whenComplete((res, ex) -> {
                    System.out.println(res);
                });
        System.out.println(future.get());
    }

    @Test
    public void test5() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + ",world"));
        System.out.println(future.get());

    }

    @Test
    public void test6() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "hello")
                .thenCombine(CompletableFuture.supplyAsync(() -> ",world!"), (s1, s2) -> s1 + s2);
        System.out.println(future.get());
    }

}
