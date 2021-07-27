package com.luzhikun.service;

import com.luzhikun.dao.UserDao;
import com.luzhikun.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Rookie Coder
 * @Description
 * @Date
 **/
@Service("userService")
@Transactional(readOnly = true)
public class UserService {

    @Autowired
    private UserDao userDao;

    public void accountMoney(int money){
        // 转账
        userDao.reduceMoney(money,"luzhikun");
        // 模拟异常
        int a =10 /0;
        // 获得money
        userDao.addMoney(money,"wujie");
    }
}
