
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



/** EXERCISE FOR READER: read the code, understand it, and insert comments 
 *
 * @author Todd
 */
public class EchoServer extends RemoteServer implements EchoServerInterface  {
	private int messagenum;
    SessionFactory factory;

    
	public static void main(String[] args) {
		int portNum = 8082;
		if(args.length > 0){
			portNum = Integer.parseInt(args[0]);
		}
                // set the hostname property to the public IP of the server if the server has several IP addresses
                //System.setProperty("java.rmi.server.hostname", "10.70.176.85");
		try {
			EchoServer es = new EchoServer();
			LocateRegistry.createRegistry(portNum);
			System.out.println( "Registry created" );
			UnicastRemoteObject.exportObject(es,0);
			System.out.println( "Exported" );
			Naming.rebind("//localhost:" + portNum + "/EchoService", es);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
			e.printStackTrace();
		}		 
	}

    public EchoServer(){

    	// A SessionFactory is set up once for an application!
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    			.configure() // configures settings from hibernate.cfg.xml
    			.build();
    	try {
    		MetadataImplementor meta = (MetadataImplementor) new MetadataSources( registry ).addAnnotatedClass(Message.class).buildMetadata();
    		// new SchemaExport(meta).create(true, true);
    		factory = meta.buildSessionFactory();
    	}
    	catch (Exception e) {
    		// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
    		// so destroy it manually.
    		StandardServiceRegistryBuilder.destroy( registry );
    	}
    }

    public String processMessage(String hostName, String messageFromClient){
    	int messageNumber;
    	String clientHost = null;
    	
    	synchronized(this){
    		messageNumber = messagenum++;
    	}
    	System.out.println("From:" + hostName + ">"+messageFromClient);
    	try {
    		clientHost = getClientHost();
    	}catch (ServerNotActiveException e){
    		e.printStackTrace();
    	}
    	Session s = factory.getCurrentSession();		
      
    	s.beginTransaction();		
    	Message message = new Message();
    	message.setMessage(messageFromClient);
    	message.setClient(clientHost);
    	message.setMesNumber(messageNumber);
    	message.setMesDate(Calendar.getInstance());
    	s.save(message);
    	s.getTransaction().commit();
    	
    	
    	if (messageFromClient.equals("dumpit")){
    		s = factory.getCurrentSession();
    		s.beginTransaction();
    		List<Message> result = s.createQuery( "from Message where client = :c")
    				.setParameter("c",clientHost)
    				.list();
    		s.getTransaction().commit();
    		StringBuilder sb = new StringBuilder();
    		sb.append(messageNumber);
    		sb.append(" Output> ");
    		for ( Message mes : (List<Message>) result ) {
    			sb.append(mes.getMessage());
    			sb.append("\n");
    		}
    		return new String(sb.toString());
    	}else{
		    return new String(messageNumber + " Output> " + message.getMessage());
    	}
		
    }
}
