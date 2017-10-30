package com.advertManager.service;

import com.advertManager.dao.IAdvertDAO;
import com.advertManager.entity.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertService implements IAdvertService {

    @Autowired
    private IAdvertDAO advertDAO;

    @Override
    public synchronized boolean createAdvert(Advert advert) {
        if (advertDAO.advertExist(advert.getAdvertId())){
            return false;
        } else {
            advertDAO.addAdvert(advert);
            return true;
        }
    }

    @Override
    public void updateAdvert(Advert advert) {
        advertDAO.updateAdvert(advert);
    }

    @Override
    public void deleteAdvert(long advertId) {
        advertDAO.deleteAdvert(advertId);
    }

    @Override
    public Advert getAdvertById(long advertId) {
        Advert obj = advertDAO.getAdvertById(advertId);
        return obj;
    }

    @Override
    public List<Advert> getAllAdverts() {
        return advertDAO.getAllAdverts();
    }
}
