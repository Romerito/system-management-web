package util;

import org.hibernate.Session;

public class teste {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Session session;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("Conectou");
					
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
