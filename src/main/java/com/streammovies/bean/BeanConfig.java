package com.streammovies.bean;

import com.streammovies.controller.util.IRedirectRequest;
import com.streammovies.controller.util.RedirectToSubPath;
import com.streammovies.dao.api.IConnection;
import com.streammovies.dao.api.MySqlConnection;
import com.streammovies.security.BCryptPassword;
import com.streammovies.security.ICryptorPassword;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.io.InputStreamReader;

@Configuration
public class BeanConfig {

   @Bean("mysqlConnection")
   public IConnection beanIConnection(){
       return new MySqlConnection();
   }

   @Bean
   public ICryptorPassword getCryptor(){
       return new BCryptPassword();
   }


}
