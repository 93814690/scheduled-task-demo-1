package com.example.scheduledtask.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SysJob implements Serializable {
    private Long id;

    private String beanName;

    private String methodName;

    private String methodParam;

    private String cron;

    private String remark;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}