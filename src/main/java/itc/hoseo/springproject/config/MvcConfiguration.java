package itc.hoseo.springproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Autowired
    Environment env;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:///" + env.getProperty("app.uploaddir.photo"));
    }
    //    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        //WebMvcConfigurer.super.addResourceHandlers(registry);
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/tamplete/")
//                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES));
//    }
}
