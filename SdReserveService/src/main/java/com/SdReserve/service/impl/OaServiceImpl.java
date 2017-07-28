package com.SdReserve.service.impl;

import com.SdReserve.bean.OaBean;
import com.SdReserve.bean.User;
import com.SdReserve.dao.OaDao;
import com.SdReserve.service.OaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxz on 2017/7/26.
 */

@Service
public class OaServiceImpl implements OaService {

    @Autowired
    OaDao oaDao;

    public OaBean getOaAccount(OaBean oaBean) {
        return oaDao.getOaAccount(oaBean.getOaAccount());
    }

    public User getUserByOaId(int oaId) {
        return oaDao.getUserByOaId(oaId);
    }
}
