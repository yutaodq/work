package zy.cy6.zyxt.web.config;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.shiro.event.EventBus;
import org.apache.shiro.event.support.DefaultEventBus;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.ShiroEventBusBeanPostProcessor;
import org.apache.shiro.spring.config.AbstractShiroBeanConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zy.cy6.zyxt.query.users.shiro.AccountRealm;
import zy.cy6.zyxt.query.users.shiro.service.UserRoleQueryService;
import zy.cy6.zyxt.query.users.shiro.service.UserQueryService;
import zy.cy6.zyxt.web.shiro.AccountSubjectFactory;
import zy.cy6.zyxt.web.shiro.AuthenticatedFilter;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @since 1.4.0
 */
@Configuration
public class ShiroConfig extends AbstractShiroBeanConfiguration {
    @Autowired
    private UserQueryService userQueryService;
    @Autowired
    private UserRoleQueryService userRoleQueryService;

    @Bean(name = "eventBusShiro")
    @Override
    protected EventBus eventBus() {
        return new DefaultEventBus();
    }

    @Bean
    @ConditionalOnMissingBean
    @Override
    public ShiroEventBusBeanPostProcessor shiroEventBusAwareBeanPostProcessor() {
        return super.shiroEventBusAwareBeanPostProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    @Override
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return super.lifecycleBeanPostProcessor();
    }

    @Bean
    public SubjectFactory subjectFactory() {
        return new AccountSubjectFactory();
    }

    @Bean
    public Realm accountRealm() {
        return new AccountRealm();
    }

    /**
     * ShiroFilterFactoryBean 处理拦截资源文件问题。
     * Filter Chain定义说明 1、一个URL可以配置多个Filter，使用逗号分隔
     * 2、当设置多个过滤器时，全部验证通过，才视为通过
     * 3、部分过滤器可指定参数，如perms，roles
     */

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login"); //没有登录的用户请求需要登录的页面时自动跳转到登录页面，可配置也可不配置
        shiroFilter.setSuccessUrl("/");  //登录成功默认跳转页面，不配置则跳转至”/”，一般可以不配置，直接通过代码进行处理
        shiroFilter.setUnauthorizedUrl("/error/reject.html");  //没有权限默认跳转的页面

        HashMap<String, Filter> filters = new HashMap<>();
        filters.put("authc", new AuthenticatedFilter());
        shiroFilter.setFilters(filters);

        /**
         * 配置shiro拦截器链
         *
         * anon  不需要认证
         * authc 需要认证
         * user  验证通过或RememberMe登录的都可以
         *
         * 顺序从上到下,优先级依次降低
         *
         */
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("/**", "anon");
//        hashMap.put("/dist/**", "anon");
//        hashMap.put("/admin/channel/list", "authc,perms[channel:list]");

        shiroFilter.setFilterChainDefinitionMap(hashMap);
        return shiroFilter;
    }

}
