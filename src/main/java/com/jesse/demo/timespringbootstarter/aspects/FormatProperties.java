package com.jesse.demo.timespringbootstarter.aspects;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
@ConfigurationProperties(prefix = "starter.time")
public class FormatProperties {
    private String format = "yyyy-MM-dd hh:mm:ss";

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
