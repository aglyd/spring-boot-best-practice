package cn.javastack.springboot.test.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    Logger logger = LoggerFactory.getLogger(TestService.class);

    public String getServiceName() {
        return "Java技术栈";
    }

    public void getUnretr(String s){
        logger.info("无返回调用方法：{}",s);
    }

    public String getRetre(String s){
        logger.info("返回字符串调用方法：{}",s);
        return s+"ok";
    }

}
