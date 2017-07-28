package com.SdReserve.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangxz on 2017/7/18.
 */

@Repository
public interface TestDao {

    int testConn(@Param("param1") int param1, @Param("param2") String param2);

}
