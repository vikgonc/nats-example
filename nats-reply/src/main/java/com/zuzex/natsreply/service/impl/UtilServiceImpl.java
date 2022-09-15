package com.zuzex.natsreply.service.impl;

import com.zuzex.natsreply.service.UtilService;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

    @Override
    public String revertString(String str) {
        return new StringBuilder(str)
                .reverse()
                .toString();
    }
}
