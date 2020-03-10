package cn.caojiantao.spider.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author caojiantao
 * @date 2018-10-24 16:03:06
 * @description
 */
@EnableCaching
@Configuration
public class MyWebConfiguration implements WebMvcConfigurer {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);
        return new CorsFilter(configSource);
    }

    @Bean
    public FilterRegistrationBean spiderFilter() {
        FilterRegistrationBean<SpiderFilter> spiderFilter = new FilterRegistrationBean<>();
        spiderFilter.setFilter(new SpiderFilter());
        spiderFilter.setName("spiderFilter");
        spiderFilter.addUrlPatterns("/*");
        spiderFilter.setOrder(1);
        return spiderFilter;
    }
}
