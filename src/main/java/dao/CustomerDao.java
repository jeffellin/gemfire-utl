package dao;

import com.ellin.gemfire.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 7/5/14
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class CustomerDao {

    @Autowired(required = false)
    private Session session;

    @PostConstruct
    public void init(){
        System.out.println("fooooooo bar");
    }


    public void save(Customer customer){

        Transaction tx  = session.beginTransaction();

        session.merge(customer);

        tx.commit();

        session.clear();



    }
}
