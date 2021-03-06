package com.dongnaoedu.cas.client.springboot.config;

import org.jasig.cas.client.session.SingleSignOutFilter;
import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.unicon.cas.client.configuration.CasClientConfiguration;
import net.unicon.cas.client.configuration.CasClientConfigurationProperties;

/**
 * 单点登出配置
 * 
 * @author 动脑学院.Tony老师
 * @see 专注在职IT人员能力提升，咨询顾问QQ: 2729 772 006
 */
@Configuration
@EnableConfigurationProperties(value = { CasClientConfigurationProperties.class })
@AutoConfigureBefore(value = { CasClientConfiguration.class })
public class CasClientSLOConfiguration {
    @Autowired
    CasClientConfigurationProperties configProps;

    @Bean
    public FilterRegistrationBean<SingleSignOutFilter> casSingleSignOutFilter() {
        final FilterRegistrationBean<SingleSignOutFilter> casSingleSignOutFilter = new FilterRegistrationBean<SingleSignOutFilter>();
        SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
        casSingleSignOutFilter.setFilter(singleSignOutFilter);
        casSingleSignOutFilter.setOrder(0);
        return casSingleSignOutFilter;
    }

    @Bean
    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> serssionListenerBean() {
        ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> sessionListener = new ServletListenerRegistrationBean<>(
                new SingleSignOutHttpSessionListener());
        return sessionListener;
    }

}
