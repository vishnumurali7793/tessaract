package org.tesseract.persistance;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.tesseract.entities.PurchaseBean;
import org.tesseract.entities.VendorBean;

public class TransactionHibernateDao {

	public Integer getvendorDetails(String ss) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			String qr = "SELECT * FROM VendorBean where vendorCode=:vencode";
			StringBuilder sbs = new StringBuilder();
			sbs.append(qr);
			Query q = sessionFactory.getCurrentSession().createQuery(qr.toString()).setParameter("vencode", ss);
			return (Integer) q.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}

	}

	// save purchasevendor data
	public void addPurchasevendor(PurchaseBean purBean) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.saveOrUpdate(purBean);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public Collection<Object> getVendorListByVendorCode(String vendorCode) throws Exception {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		try {
			return session.createQuery("SELECT vendorId, vendorName, vendorCode FROM VendorBean WHERE vendorCode LIKE '%"+ vendorCode +"%'").list();
		} catch (Exception e) {
			return null;
		}
	}

}
