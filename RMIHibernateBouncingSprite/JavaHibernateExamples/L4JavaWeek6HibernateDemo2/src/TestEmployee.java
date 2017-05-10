import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder; // deprecated
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; // use this instead
//import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestEmployee {

    public static void main(String[] args) {
        Configuration config = new Configuration()
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Location.class)
                .configure("hibernate.cfg.xml");
        //config.addAnnotatedClass(Employee.class);
        //config.configure("hibernate.cfg.xml");

        //new SchemaExport(config).create(true, true);
        StandardServiceRegistryBuilder sRBuilder = 
                new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        ServiceRegistry sR = sRBuilder.build();
        SessionFactory factory = config.buildSessionFactory(sR);  // we create a factory only once
        Session s = factory.getCurrentSession();
        try{
            s.beginTransaction();		
            Employee todd = new Employee();
            s.load(todd,1);
            if(todd.getLocation() != null){
                System.out.println("Todd's current location is " + todd.getLocation().getXLoc()
                        + ", " + todd.getLocation().getYLoc());
            }
            else{
                System.out.println("Todd's current location is unknown (null)");
            }
            todd.setEmpEmail("kelleyt@algonquincollege.com");
            todd.setEmpAddress("Algonquin College, Information and Communications Technology");
            todd.setEmpName("Todd Kelley");
            todd.setLocation(new Location(new Point(77,24)));
            s.save(todd);
            s.getTransaction().commit();
        }
        catch(Exception ex){
            if(s.getTransaction().getStatus() != TransactionStatus.COMMITTED){s.getTransaction().rollback();}
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }

        ArrayList<Employee> emps = new ArrayList<Employee>();
        Session s2 = factory.getCurrentSession();
        try{
            s2.beginTransaction();
            Query q = s2.createQuery("from Employee E where E.empId = :id"); // use Entity class name, not database table name
            // see http://stackoverflow.com/questions/9954590/hibernate-error-querysyntaxexception-users-is-not-mapped-from-users
            q.setParameter("id",1);
            emps = (ArrayList<Employee>) q.list();
            s2.getTransaction().commit();
            for (Employee e: emps){
                Location l = e.getLocation();
                System.out.println(e.getEmpName() + "'s current location is " + l.getXLoc() + ", " + l.getYLoc());
            }
        }
        catch(Exception ex){
            if(s.getTransaction().getStatus() != TransactionStatus.COMMITTED){s.getTransaction().rollback();}
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        /*
		s.beginTransaction();		

		Todd.setEmpId(10001);
		Todd.setEmpEmail("kelleyt@algonquincollege.com");
		Todd.setEmpAddress("Algonquin College, Information and Communications Technology");
		Todd.setEmpName("Todd Kelley");
		Todd.setLocation(new Location(new Point(43,24)));
		s.save(Todd);


		s.getTransaction().commit();

		ArrayList<Employee> emps = new ArrayList<Employee>();
		Session s2 = factory.getCurrentSession();
		s2.beginTransaction();
        emps = (ArrayList<Employee>) s2.createQuery("from Employee").list();
		s2.getTransaction().commit();
		for (Employee e: emps){
		    Location l = e.getLocation();
		    System.out.println(e.getEmpName() + "'s location is " + l.getXLoc() + ", " + l.getYLoc());
		}
         */	
    }

}
