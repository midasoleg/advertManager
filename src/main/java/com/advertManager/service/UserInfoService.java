package com.advertManager.service;


import com.advertManager.dao.IUserInfoDAO;
import com.advertManager.entity.Advert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserInfoService implements IUserInfoService{

    @Autowired
    private IUserInfoDAO userInfoDAO;

    @Override
    public List<Advert> getAllUserAdverts() {
        return userInfoDAO.getAllUserAdverts();
    }
}
