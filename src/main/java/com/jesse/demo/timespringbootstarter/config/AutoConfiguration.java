package com.jesse.demo.timespringbootstarter.config;

import com.jesse.demo.timespringbootstarter.aspects.FormatProperties;
import com.jesse.demo.timespringbootstarter.aspects.TimeAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 省略 @EnableAspectJAutoProxy
@ConditionalOnWebApplication
@EnableConfigurationProperties({FormatProperties.class})
@Configuration
@Import(TimeAspect.class)
public class AutoConfiguration  {

}

