package com.SdReserve.dao;

import com.SdReserve.bean.OaBean;
import com.SdReserve.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangxz on 2017/7/26.
 */

@Repository
public interface OaDao {
    OaBean getOaAccount(String param);
    User getUserByOaId(int oaId);
}
