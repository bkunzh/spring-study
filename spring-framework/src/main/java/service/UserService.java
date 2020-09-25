package service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import util.ThreadUtil;

/**
 * @author bingkun_zhang
 * @date 2020/6/3
 */
@Service
public class UserService {
    @Autowired
    public MyService myService;
}
