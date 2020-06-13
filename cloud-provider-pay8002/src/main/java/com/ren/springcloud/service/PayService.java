package com.ren.springcloud.service;

import com.ren.springcloud.entities.Pay;
import org.apache.ibatis.annotations.Param;


public interface PayService {
    public int create(Pay pay);

    public Pay getPayById(@Param("id") Long id);
}
