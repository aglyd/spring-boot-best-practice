package cn.javastack.springboot.starter.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class TestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    public String getServiceName() {
        return "Java技术栈";
    }

    public void getUnretr(String s){
        logger.info("同步---无返回调用方法：{}",s);
    }

    public String getRetre(String s){
        logger.info("同步---返回字符串调用方法：{}",s);
        return s+"ok";
    }

    @Async
    public void getAscUnre(String s){
        logger.info("异步---无返回调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
//        logger.info("线程池名称：{}",Thread.currentThread().getThreadGroup());
    }

    @Async
    public String getAscRetre(String s){
        logger.info("异步---返回字符串调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
//        logger.info("线程池名称：{}",Thread.currentThread().getThreadGroup());
        return s+"ok";
    }

    @Async("myTaskExecutor")
    public void getAscUnre2(String s){
        logger.info("异步---自定义线程池---无返回调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
//        logger.info("线程池名称：{}",Thread.currentThread().getThreadGroup());

    }

    @Async("myTaskExecutor")
    public String getAscRetre2(String s){
        logger.info("异步---自定义线程池---返回字符串调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
        return s+"ok";
    }

    @Async("myTaskExecutor")
    public Future<String> getAscRetre3(String s){
        logger.info("异步---自定义线程池---返回async.forvalue字符串调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
        return AsyncResult.forValue(s);
    }

    @Async("myTaskExecutor")
    public Future<String> getAscRetre4(String s){
        logger.info("异步---自定义线程池---返回new async字符串调用方法：{}",s);
        logger.info("线程名称：{}",Thread.currentThread().getName()+"\t"+Thread.currentThread().getId());
        return new AsyncResult<String>(s);
    }

}
