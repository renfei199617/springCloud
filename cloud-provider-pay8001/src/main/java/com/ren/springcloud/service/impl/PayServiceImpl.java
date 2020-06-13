package com.ren.springcloud.service.impl;

import com.ren.springcloud.dao.PayDao;
import com.ren.springcloud.entities.Pay;
import com.ren.springcloud.service.PayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayServiceImpl implements PayService {
    @Resource
    private PayDao payDao;

    @Override
    public int create(Pay pay) {
        return payDao.create(pay);
    }
    @Override
    public Pay getPayById(Long id) {
        return payDao.getPayById(id);
    }
}
