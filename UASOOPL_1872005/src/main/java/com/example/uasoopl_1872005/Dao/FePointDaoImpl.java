package com.example.uasoopl_1872005.Dao;


import com.example.uasoopl_1872005.Model.FePointEntity;
import com.example.uasoopl_1872005.Utility.DaoService;
import com.example.uasoopl_1872005.Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**Michael Sebastian Gunadi-1872005*/
public class FePointDaoImpl implements DaoService<FePointEntity> {
    @Override
    public List<FePointEntity> fetchall() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FePointEntity> criteriaQuery = criteriaBuilder.createQuery(FePointEntity.class);
        criteriaQuery.from(FePointEntity.class);
        List<FePointEntity> point = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return point;
    }

    @Override
    public int addData(FePointEntity object){
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(object);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int updateData(FePointEntity object){
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(object);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }



    @Override
    public int deleteData(FePointEntity object){
        int result = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(object);
            transaction.commit();
            result = 1;
        }catch (HibernateException ex){
            transaction.rollback();
        }
        session.close();
        return result;
    }
}

