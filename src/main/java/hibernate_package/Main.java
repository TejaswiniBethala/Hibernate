package hibernate_package;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {

	public static void main(String[] args) {
		StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("Hibernate.config.xml").build();
		Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();
		
		SessionFactory sfactory=meta.buildSessionFactory();
		Session session=sfactory.openSession();
		
		Transaction t=session.beginTransaction();
		
		try {
			States s = new States();
			s.setStateName("Telangana");
			
			States s1 = new States();
			s1.setStateName("Andhra Pradesh");
			
			States s2 = new States();
			s2.setStateName("Karnataka");
			
			States s3 = new States();
			s3.setStateName("Kerala");
			
			States s4 = new States();
			s4.setStateName("Tamil Nadu");
			
			Country c = new Country();
			c.setCountryCode(91);
			c.setCountryName("India");
			
			s.setCountry(c);
			s1.setCountry(c);
			s2.setCountry(c);
			s3.setCountry(c);
			s4.setCountry(c);
			
			
			c.getStates().add(s);
			c.getStates().add(s1);
			c.getStates().add(s2);
			c.getStates().add(s3);
			c.getStates().add(s4);
			
			session.save(c);
			session.save(s);
			session.save(s1);
			session.save(s2);
			session.save(s3);
			session.save(s4);
			
			t.commit();
			
		}finally {
			sfactory.close();
			session.close();
			
		}

	}

}
