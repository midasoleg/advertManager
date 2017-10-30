package com.advertManager.service;


import com.advertManager.entity.Advert;

import java.util.List;

public interface IAdvertService {

    boolean createAdvert (Advert advert);
    void updateAdvert (Advert advert);
    void deleteAdvert (long advertId);

    Advert getAdvertById(long advertId);
    List<Advert> getAllAdverts();

}
