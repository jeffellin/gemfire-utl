package hello;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: jellin
 * Date: 7/5/14
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class HSQLDBServer {


    public static void main(String[] args){


        try {
            HsqlProperties props = new HsqlProperties();
            props.setProperty("server.database.0","file:.\\testdb\testdb");
            props.setProperty("server.dbname.0","testdb");
            Server server = new Server();
            server.setProperties(props);
            server.start();

            System.out.println("Server Started  - Press Enter to Stop");

            //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            //reader.readLine();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }

            server.shutdown();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ServerAcl.AclFormatException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

}
