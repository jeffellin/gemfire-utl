package hello;

import dao.CustomerDao;
import com.ellin.gemfire.model.Customer;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.NonTransientDataAccessException;

import java.io.IOException;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 7/4/14
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class RunApp {

    public static void main(String[] args) throws IOException, ServerAcl.AclFormatException, InterruptedException {
        //HSQLDBServer.main(null);

        HsqlProperties props = new HsqlProperties();
        props.setProperty("server.database.0","file:.\\testdb\testdb");
        props.setProperty("server.dbname.0","testdb");
        Server server = new Server();
        server.setProperties(props);
        server.start();

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        server.stop();


        Thread.sleep(4000);

        CustomerDao dao = ctx.getBean(CustomerDao.class);
        Customer c = new Customer();
        c.setFirstName("jeff");
        c.setLastName("ellin");
        c.setId(UUID.randomUUID().toString());
        try {
            dao.save(c);
        } catch (Exception e) {

            Class claz = null;
            Class claz2 = null;

            try {
                 claz = Class.forName("java.sql.SQLTransientException");
                 claz2 = com.mchange.v2.resourcepool.CannotAcquireResourceException.class;


            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            System.out.println(ExceptionUtils.getThrowableList(e));
            int index = ExceptionUtils.indexOfType(e, claz2);

            System.out.println("index is "+ index);

            if(index >= 0){
                System.out.println("***********WE HAVE A WINNER *******");
            }


           Throwable cause =  e.getCause().getCause();



            System.out.println(cause.getClass().getSimpleName());

            if(e instanceof NonTransientDataAccessException){
                System.out.println("Its a NonTransientDataException");
            }

           // e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        System.out.println("Hello, world");
    }
}
