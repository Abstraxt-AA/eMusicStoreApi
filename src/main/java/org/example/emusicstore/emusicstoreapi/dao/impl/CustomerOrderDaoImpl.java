package org.example.emusicstore.emusicstoreapi.dao.impl;

import org.example.emusicstore.emusicstoreapi.dao.CustomerOrderDao;
import org.example.emusicstore.emusicstoreapi.model.CustomerOrder;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {
    // TODO: Use Spring Data

    @Autowired
    private Session session;

    @Override
    public void addCustomerOrder(CustomerOrder customerOrder) {
//        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customerOrder);
        session.flush();
    }
}
