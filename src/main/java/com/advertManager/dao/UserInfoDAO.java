package com.advertManager.dao;


import com.advertManager.entity.Advert;
import com.advertManager.entity.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
        short enabled = 1;
        List<?> list= entityManager.createQuery("select u from UserInfo u where userName = ? and enabled = ?")
                .setParameter(1,userName)
                .setParameter(2, enabled)
                .getResultList();
        if (!list.isEmpty()){
            activeUserInfo = (UserInfo) list.get(0);
        }
        return activeUserInfo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Advert> getAllUserAdverts() {
        String hql = "from Advert as adv order by adv.advertId";
        return (List<Advert>) entityManager.createQuery(hql).getResultList();
    }
}
