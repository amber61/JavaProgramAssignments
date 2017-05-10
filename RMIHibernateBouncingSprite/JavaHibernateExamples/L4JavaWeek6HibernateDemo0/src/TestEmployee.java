import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Calendar;

public class TestEmployee {

	public static void main(String[] args) {
		Configuration config = new Configuration()
		    .addAnnotatedClass(Employee.class)
		    .configure("hibernate.cfg.xml");
		
		// new SchemaExport(config).create(true, true);    // remove and recreate all tables!!! (Hibernate 4.7)
		
		StandardServiceRegistryBuilder sRBuilder = 
		        new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		ServiceRegistry sR = sRBuilder.build();
		SessionFactory factory = config.buildSessionFactory(sR);  // we create a factory only once

		Session s = factory.getCurrentSession();		  // we use factory to get a session whenever needed
		s.beginTransaction();		
		Employee todd = new Employee();		                  // at this instant, todd is transient 
		todd.setEmpId(10001); // if @GeneratedValue this is quietly ignored
		todd.setEmpEmail("e@temp.com");
		todd.setEmpAddress("temp address");
		todd.setEmpName("temp employee");
		todd.setAge(42);
		// see: https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.Builder.html
		todd.setEmpStartDate(new Calendar.Builder().setDate(2016, 9, 01).build());
		s.save(todd);                                             // todd becomes persistent
		
		s.getTransaction().commit();                             // todd becomes detached
		
		Session s2 = factory.getCurrentSession();
		s2.beginTransaction();

		todd.setEmpEmail("email_2@email.com");   // change todd's state
		s2.update(todd);                                        // todd is persitent again
		s2.getTransaction().commit();
		
		factory.close();                                        // shutting program down
		StandardServiceRegistryBuilder.destroy(sR);
	}
}
