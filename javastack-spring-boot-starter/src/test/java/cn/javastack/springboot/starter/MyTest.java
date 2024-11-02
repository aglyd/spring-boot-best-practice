package cn.javastack.springboot.starter;

import cn.javastack.springboot.starter.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private TestService testService;

    @Test
    public void test1() throws ExecutionException, InterruptedException {
        System.out.println("test1----start");
        testService.getAscUnre("Ascunret");
        System.out.println("接收异步返回："+testService.getAscRetre("Ascret"));
        testService.getAscUnre2("Ascunret22");
        System.out.println("接收异步返回2："+testService.getAscRetre2("Ascret22"));
        System.out.println("-------------------");
        System.out.println("接收异步返回3："+testService.getAscRetre3("Ascret33").get());
        System.out.println("接收异步返回4："+testService.getAscRetre4("Ascret44").get());
        System.out.println("test1----end");
//        final Callable<Object> objectCallable = new Callable<>();
    }

    @Test
    public void test2(){

//        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
//        // 获取对应的平方数
//        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> strings = Arrays.asList("1", "2", "3", "4");
        List<Integer> collect = integers.stream().map(i -> ++i).collect(Collectors.toList());
        System.out.println(collect);
         IntStream intStream = integers.stream().mapToInt(i -> ++i);
        System.out.println(intStream.sum());
    }
}
