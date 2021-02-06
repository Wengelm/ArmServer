package service;

import Conf.HibernateSessionFactoryUtil;
import entity.CodeAmortization;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CodeServiceImpl implements CodeService {
    @Override
    public CodeAmortization findById(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(CodeAmortization.class, id);
    }


    @Override
    public void save(CodeAmortization code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void update(CodeAmortization code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(code);
        tx1.commit();
        session.close();
    }
    @Override
    public void delete(CodeAmortization code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(code);
        tx1.commit();
        session.close();

    }

    @Override
    public CodeAmortization findByCode(String code) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from CodeAmortization where code = :code", CodeAmortization.class);
        q.setParameter("code", code);
        if(!q.getResultList().isEmpty()) {
            CodeAmortization codeAmortization = (CodeAmortization) q.getResultList().get(0);
            tx1.commit();
            session.close();
            return codeAmortization; }

        return new CodeAmortization();

    }

    @Override
    public List<CodeAmortization> getAllCodes() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        Query q = session.createQuery("from CodeAmortization ", CodeAmortization.class);

        List<CodeAmortization> allCodes = new ArrayList<>(q.getResultList());
        tx1.commit();
        session.close();
        return allCodes;

    }
}
