package com.SdReserve.shiro;

import com.SdReserve.bean.OaBean;
import com.SdReserve.dao.OaDao;
import com.sun.org.apache.xerces.internal.xs.StringList;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 继承自AuthorizingRealm的自定义Realm,即指定Shiro验证用户登录的类为自定义的
 * Created by 41942 on 2017/6/1.
 */
@Component("myShiro")
public class MyShiro extends AuthorizingRealm {
    @Autowired
    OaDao oaDao;

    @Override
    public String getName(){
        return "myShiro";
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String oaAccount = principalCollection.getPrimaryPrincipal().toString();
        System.out.println("========1" + oaAccount);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<String>();
        info.addStringPermissions(permissions);
        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String oaAccount = authenticationToken.getPrincipal().toString();
        OaBean oaAccount1 = oaDao.getOaAccount(oaAccount);
        if(oaAccount1==null){
            throw new UnknownAccountException();
        }
        String oaPwd = oaAccount1.getOaPwd();
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(oaAccount, oaPwd, getName());
        return info;
    }
}
