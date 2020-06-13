package com.ren.springcloud.dao;

import com.ren.springcloud.entities.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PayDao {

    public int create(Pay pay);

    public Pay getPayById(@Param("id") Long id);
}
