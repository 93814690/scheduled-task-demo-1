package com.example.scheduledtask.dao;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.example.scheduledtask.domain.SysJob;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysJobMapper {
    int insert(SysJob record);

    SysJob selectByPrimaryKey(Long id);

    List<SysJob> listAllByStatus(@Param("status")Integer status);


}