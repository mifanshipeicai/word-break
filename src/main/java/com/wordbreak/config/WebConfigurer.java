package com.wordbreak.config;

import com.wordbreak.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yanchao
 * @project word-break
 * @package com.wordbreak.config
 * @create 2020-02-23
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**").excludePathPatterns("/**");
        //super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**","templates/**","/upload/**").addResourceLocations(
                ResourceUtils.CLASSPATH_URL_PREFIX+"/static/", ResourceUtils.CLASSPATH_URL_PREFIX+"/templates/", ResourceUtils.CLASSPATH_URL_PREFIX+"/upload/");
    }








}
