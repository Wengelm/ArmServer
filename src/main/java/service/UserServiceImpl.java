package service;

import Conf.HibernateSessionFactoryUtil;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService{
    @Override
    public User findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }


    @Override
    public void save(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();

    }

    @Override
    public User findByLogin(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from User where login = :login", User.class);
        q.setParameter("login", login);
        if(!q.getResultList().isEmpty()) {
        User user = (User) q.getResultList().get(0);
        tx1.commit();
        session.close();
        return user; }

        return new User();

    }

    @Override
    public List<User> getAllUsers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from User", User.class);
        List<User> allUsers = new ArrayList<>();
        User user = (User) q.getResultList().get(0);
        allUsers.addAll(q.getResultList());
        tx1.commit();
        session.close();
        return allUsers;

    }

}

