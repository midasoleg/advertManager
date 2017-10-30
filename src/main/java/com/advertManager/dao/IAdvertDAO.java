package com.advertManager.dao;

import com.advertManager.entity.Advert;

import java.util.List;

public interface IAdvertDAO {

    void addAdvert (Advert advert);
    void updateAdvert (Advert advert);
    void deleteAdvert (long advertId);

    Advert getAdvertById(long advertId);
    List<Advert> getAllAdverts();

    boolean advertExist (long advertId);
}
