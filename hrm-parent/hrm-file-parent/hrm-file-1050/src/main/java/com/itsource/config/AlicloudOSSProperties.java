package com.itsource.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@ConfigurationProperties(prefix = "file.alicloud")
@Component
public class AlicloudOSSProperties {

    private String bucketName;

    private String accessKey;

    private String secretKey;

    private String endpoint;
}
