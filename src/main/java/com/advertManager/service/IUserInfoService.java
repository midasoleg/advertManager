package com.advertManager.service;


import com.advertManager.entity.Advert;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IUserInfoService {
    @Secured ({"ROLE_ADMIN"})
    List<Advert> getAllUserAdverts();
}
