package com.SdReserve.service.impl;

import com.SdReserve.dao.TestDao;
import com.SdReserve.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxz on 2017/7/18.
 */

@Service
public class TestServiceImpl implements TestService{

    @Autowired
    TestDao testDao;

    public int testConn(int param1, String param2) {
        return testDao.testConn(param1, param2);
    }
}
