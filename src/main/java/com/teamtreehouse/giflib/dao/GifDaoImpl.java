package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Gif;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class GifDaoImpl implements GifDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Gif> findAll() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<Gif> gifCriteriaQuery = session.getCriteriaBuilder().createQuery(Gif.class);
        Root<Gif> categoryRoot = gifCriteriaQuery.from(Gif.class);
        gifCriteriaQuery.select(categoryRoot);
        List<Gif> gifs = session.createQuery(gifCriteriaQuery).getResultList();
        session.close();
        return gifs;
    }

    @Override
    public Gif findById(Long id) {
        Session session = sessionFactory.openSession();
        Gif gif = session.get(Gif.class, id);
        session.close();
        return gif;
    }

    @Override
    public void save(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(gif);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Gif gif) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(gif);
        session.getTransaction().commit();
        session.close();
    }
}
