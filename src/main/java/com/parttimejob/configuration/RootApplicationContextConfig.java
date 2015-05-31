package com.parttimejob.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by on 2015. 5. 10..
 */
@Configuration
@Import(RepositoryConfig.class)
@ComponentScan(basePackages = { "com.parttimejob" })
public class RootApplicationContextConfig {
}
