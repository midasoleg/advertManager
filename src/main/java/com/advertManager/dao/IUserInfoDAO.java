package com.advertManager.dao;


import com.advertManager.entity.Advert;
import com.advertManager.entity.UserInfo;

import java.util.List;

public interface IUserInfoDAO {
    UserInfo getActiveUser (String userName);
    List<Advert> getAllUserAdverts();
}
