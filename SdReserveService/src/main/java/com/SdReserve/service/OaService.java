package com.SdReserve.service;

import com.SdReserve.bean.OaBean;
import com.SdReserve.bean.User;

/**
 * Created by zhangxz on 2017/7/26.
 */

public interface OaService {
    OaBean getOaAccount(OaBean oaBean);
    User getUserByOaId(int oaId);
}
