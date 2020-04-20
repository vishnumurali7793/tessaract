package org.tesseract.action;

import java.util.ArrayList;
import java.util.List;

import org.tesseract.entities.PurchaseBean;
import org.tesseract.entities.VendorBean;
import org.tesseract.persistance.TransactionHibernateDao;

import com.opensymphony.xwork2.ActionSupport;

public class TransactionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private TransactionHibernateDao transHibernateDao = new TransactionHibernateDao();
	private PurchaseBean purchaseBean;
	private List<PurchaseBean> purbeanList;
	
	//vendor page action 
		public String savepurchaseVendor(){
			if (purchaseBean != null) {
			Integer vendid=	transHibernateDao.getvendorDetails(purchaseBean.getVendor().getVendorCode());
			purchaseBean.setVendor(new VendorBean());
			purchaseBean.getVendor().setVendorId(vendid);
			transHibernateDao.addPurchasevendor(purchaseBean);
				return SUCCESS;
			}
			
			return INPUT;
		}
	
	@SuppressWarnings("unchecked")
	private String autovenCode(){
		ArrayList<Object> objectlist=new ArrayList();
		objectlist=(ArrayList<Object>) transHibernateDao.addvendordetails(purchaseBean.getVendor().getVendorId());
		return "sucess";
		
	}

	public PurchaseBean getPurchaseBean() {
		return purchaseBean;
	}

	public void setPurchaseBean(PurchaseBean purchaseBean) {
		this.purchaseBean = purchaseBean;
	}

	public List<PurchaseBean> getPurbeanList() {
		return purbeanList;
	}

	public void setPurbeanList(List<PurchaseBean> purbeanList) {
		this.purbeanList = purbeanList;
	}
	

}
