package service;

import Conf.HibernateSessionFactoryUtil;
import entity.CodeAmortization;
import entity.RespPerson;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class RespPersonServiceImpl implements RespPersonService {


    @Override
    public RespPerson findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RespPerson.class, id);
    }


    @Override
    public void save(RespPerson code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(RespPerson code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(RespPerson code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(code);
        tx1.commit();
        session.close();

    }

    @Override
    public RespPerson findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from RespPerson where name = :name", RespPerson.class);
        q.setParameter("name", name);
        if(!q.getResultList().isEmpty()) {
            RespPerson respPerson = (RespPerson) q.getResultList().get(0);
            tx1.commit();
            session.close();
            return respPerson; }

        return new RespPerson();

    }

    @Override
    public List<RespPerson> getAllPersons() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from RespPerson ", RespPerson.class);

        List<RespPerson> allCodes = new ArrayList<>(q.getResultList());
        tx1.commit();
        session.close();
        return allCodes;

    }
}
