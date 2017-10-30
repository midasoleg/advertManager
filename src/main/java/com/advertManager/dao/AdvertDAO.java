package com.advertManager.dao;

import com.advertManager.entity.Advert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AdvertDAO implements IAdvertDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addAdvert(Advert advert) {
        entityManager.persist(advert);
    }

    @Override
    public void updateAdvert(Advert advert) {
        Advert advrt = getAdvertById(advert.getAdvertId());
        advrt.setTitle(advert.getTitle());
        advrt.setDescription(advert.getDescription());
        advrt.setDateOfPost(advert.getDateOfPost());
        entityManager.flush();
    }

    @Override
    public void deleteAdvert(long advertId) {
        entityManager.remove(getAdvertById(advertId));
    }

    @Override
    public Advert getAdvertById(long advertId) {
        return entityManager.find(Advert.class, advertId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Advert> getAllAdverts() {
        String hql = "from Advert as adv order by adv.advertId";
        return (List<Advert>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public boolean advertExist(long advertId) {
        String hql = "from Advert as adv where adv.advertId = ?";
        int size = entityManager.createQuery(hql).setParameter(1, advertId).getResultList().size();
        return size > 0 ? true : false;
    }
}
