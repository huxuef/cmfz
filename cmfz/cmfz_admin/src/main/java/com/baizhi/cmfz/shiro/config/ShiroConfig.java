package com.baizhi.cmfz.shiro.config;

import com.baizhi.cmfz.shiro.MyRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * shiro的配置类
 */
@Configuration
public class ShiroConfig {

   /**
     * shiroFilterFactoryBean
     */
   /* @Bean
    public ShiroFilterFactoryBean createShiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        // 定制访问规则的过滤器链
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("/back/login/login.jsp","anon");
        map.put("/back/login/img/**","anon");
        map.put("/back/login/css/**","anon");
        map.put("/back/login/script/**","anon");
        map.put("/back/carousel/shouye/**","anon");
        map.put("/back/main/themes/**","anon");
        map.put("/back/main/js/**","anon");
        map.put("/back/main/main/image/**","anon");
        map.put("/index.jsp","anon");
        map.put("/back/user/**","anon");
        map.put("/upload/**","anon");
        map.put("/image/getImage.jpg","anon");
        map.put("/manager/login","anon");
        map.put("/back/main/main.jsp","user");

        map.put("/**","user");

        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/back/login/login.jsp");  // /login.jsp
        //factoryBean.setSuccessUrl("/back/main/main/main.jsp");
        factoryBean.setUnauthorizedUrl("/unauthorized.jsp");
        return factoryBean;
    }*/

    /*@Bean
    public SecurityManager createSecurityManager(Realm realm,RememberMeManager rememberMeManager,CacheManager cacheManager){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setRememberMeManager(rememberMeManager);
        securityManager.setCacheManager(cacheManager);
        return securityManager;
    }*/

    /**
     * 缓存管理器
     *      Ehcache 缓存框架 构建本地缓存
     * @return
     */
   /* @Bean
    public CacheManager createCacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml"); // ehcache框架的配置文件
        return cacheManager;
    }*/

    /**
     * 注解式授权相关
     */
    /*@Bean
    public DefaultAdvisorAutoProxyCreator createDefaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }*/

   /* @Bean
    public AuthorizationAttributeSourceAdvisor createAuthorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }*/

    /**
     * 记住我相关
     * @param cookie
     * @return
     */
    /*@Bean
    public RememberMeManager createRememberMeManager(Cookie cookie){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCookie(cookie);
        return rememberMeManager;
    }

    @Bean
    public Cookie createCookie(){
        SimpleCookie cookie = new SimpleCookie();
        cookie.setMaxAge(60*60*7*24);
        cookie.setPath("/");
        cookie.setName("rm");
        return cookie;
    }*/

    /**
     * 声明自定义的数据源类
     * @param credentialsMatcher
     * @return
     */
   /* @Bean
    public Realm createRealm(CredentialsMatcher credentialsMatcher){
        MyRealm realm = new MyRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }*/

    /**
     * 声明复杂的凭证匹配器
     * @return
     */
   /* @Bean
    public CredentialsMatcher createCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        return credentialsMatcher;
    }*/
}
