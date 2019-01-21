package com.stackroute.dao;

import com.stackroute.model.UserInformation;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class UserDaoImp implements  UserDao{

    @Autowired
    private SessionFactory session;

    public UserDaoImp(SessionFactory sessionFactory){
        session=sessionFactory;
    }

    @Override
    public void saveData(UserInformation userInformation) {
        try {
            session.getCurrentSession().save(userInformation);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
