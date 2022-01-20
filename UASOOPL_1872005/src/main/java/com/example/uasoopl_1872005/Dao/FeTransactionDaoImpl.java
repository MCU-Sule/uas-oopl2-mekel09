package com.example.uasoopl_1872005.Dao;

import com.example.uasoopl_1872005.Model.FeTransactionEntity;
import com.example.uasoopl_1872005.Utility.DaoService;
import com.example.uasoopl_1872005.Utility.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**Michael Sebastian Gunadi-1872005*/
public class FeTransactionDaoImpl implements DaoService<FeTransactionEntity> {
    @Override
    public List<FeTransactionEntity> fetchall() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FeTransactionEntity> criteriaQuery = criteriaBuilder.createQuery(FeTransactionEntity.class);
        criteriaQuery.from(FeTransactionEntity.class);
        List<FeTransactionEntity> transaksi = session.createQuery(criteriaQuery).getResultList();
        session.close();
        return transaksi;
    }

    @Override
    public int addData(FeTransactionEntity object){
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
    public int updateData(FeTransactionEntity object){
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
    public int deleteData(FeTransactionEntity object){
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
