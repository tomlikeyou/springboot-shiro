package com.dy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//表明该类是一个配置类
@Configuration
public class DruidConfig {

    //将druid数据源组件加入到springboot容器中
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }


    //配置druid的监控
    //1.配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean stateViewServlet() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置一些初始化参数
        Map<String, String> initParams = new HashMap<>();
        initParams.put("loginUsername", "root");
        initParams.put("loginPassword", "123456");
        initParams.put("allow", "127.0.0.1");//只允许本机访问
        initParams.put("deny", "192.168.2.134");
        bean.setInitParameters(initParams);
        return bean;
    }


    //2.配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> initMap = new HashMap<>();
        //设置不需要拦截的请求
        initMap.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initMap);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }
}
