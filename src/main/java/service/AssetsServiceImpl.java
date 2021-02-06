package service;

import Conf.HibernateSessionFactoryUtil;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import entity.Assets;
import entity.CodeAmortization;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sun.misc.ASCIICaseInsensitiveComparator;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class AssetsServiceImpl implements AssetsService{

    @Override
    public Assets findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Assets.class, id);
    }


    @Override
    public void save(Assets code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(Assets code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(Assets code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(code);
        tx1.commit();
        session.close();

    }

    @Override
    public Assets findByName(String name) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from Assets where name = :name", Assets.class);
        q.setParameter("name", name);
        if(!q.getResultList().isEmpty()) {
            Assets assets = (Assets) q.getResultList().get(0);
            tx1.commit();
            session.close();
            return assets; }

        return new Assets();

    }

    @Override
    public List<Assets> getAllAssets() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from Assets n ", Assets.class);

        List<Assets> assets = new ArrayList<>(q.getResultList());
        tx1.commit();
        session.close();
        return assets;

    }
}
