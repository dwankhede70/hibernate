package com.cjc.model;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;


public class Test {
	public static void main(String[] args) {
	
		Map<String, Object> m=new HashMap<>();
		m.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
		m.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
		m.put(Environment.USER, "root");
		m.put(Environment.PASS, "root");
		m.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
		m.put(Environment.HBM2DDL_AUTO, "update");
		m.put(Environment.SHOW_SQL, "true");
		
		StandardServiceRegistry regisrty=new StandardServiceRegistryBuilder().applySettings(m).build();
		
		MetadataSources mds=new MetadataSources(regisrty);
		
		mds.addAnnotatedClass(Student.class);
		
		Metadata md=mds.getMetadataBuilder().build();
		
		SessionFactory sf=md.getSessionFactoryBuilder().build();
		
		Session session=sf.openSession();
		
		//Student s=new Student();
//		s.setSid(10123);
//		s.setSname("Dnyaneshwar");
//		s.setSaddress("Pune");
//		
//		session.save(s);
//		session.beginTransaction().commit();
//		System.out.println("Data Added Successfully");
//		
		// By using load first load the data then Execute The Querry 
//		
//		Student  s=session.load(Student.class, 10);
//		System.out.println(s.getSid());
//		System.out.println(s.getSname());
//		System.out.println(s.getSaddress());
//		
//		
		// Bu using get First  QuerryExecuted 
		
		Student  s=session.get(Student.class, 10);
		System.out.println(s.getSid());
		System.out.println(s.getSname());
		System.out.println(s.getSaddress());
		
		
	}

}
