package org.tesseract.action;


import java.util.List;

import org.tesseract.entities.CaratBean;
import org.tesseract.entities.CategoryBean;
import org.tesseract.entities.CustomerBean;
import org.tesseract.entities.ProductBean;
import org.tesseract.entities.PurchaseBean;
import org.tesseract.entities.RateBean;
import org.tesseract.entities.TaxBean;
import org.tesseract.entities.VendorBean;
import org.tesseract.entities.modelBean;
import org.tesseract.persistance.MasterHibernateDao;

import com.opensymphony.xwork2.ActionSupport;

public class MasterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private TaxBean taxBean;
	private CategoryBean categoryBean;
	private ProductBean productBean;
	private modelBean modelBean;
	private CaratBean caratBean;
	private RateBean rateBean;
	private CustomerBean customerBean;
	private VendorBean vendorBean;
	private PurchaseBean purchaseBean;
	private List<TaxBean> taxList;
	private List<CategoryBean> catList;
	private List<ProductBean> prodList;
	private List<modelBean> modelList;
	private List<CaratBean> caratList;
	private List<RateBean> rateList;
	private List<CustomerBean> customerList;
	private List<VendorBean> vendorList;
	private List<PurchaseBean> purbeanList;

	private MasterHibernateDao masterHibernateDao = new MasterHibernateDao();

	public String addTax() {
		if (taxBean != null) {
			if ((taxBean.getSgst() > 0 && taxBean.getCgst() > 0) || taxBean.getIgst() > 0) {
				masterHibernateDao.addTax(taxBean);
				return SUCCESS;
			}
		}
		return INPUT;
	}
	
	public String deleteTax() {
		if(taxBean!=null && taxBean.getTaxId()!=null) {
			masterHibernateDao.deleteTaxById(taxBean);
		}
		setTaxList(masterHibernateDao.getTaxList());
		return SUCCESS;
	}
	
	//category page action
	public String saveCategory(){
		if (categoryBean != null) {
			masterHibernateDao.addCategorydata(categoryBean);
			return SUCCESS;
		}
		
		return INPUT;
	}
	
	public String deleteCategory() {
		if(categoryBean!=null && categoryBean.getCategoryId()!=null) {
			masterHibernateDao.deleteCategoryById(categoryBean);
		}
		setCatList(masterHibernateDao.getCategryList());
		return SUCCESS;
	}
	
	public String editCategory() {
		if(categoryBean!=null && categoryBean.getCategoryId()!=null) {
			setCategoryBean(masterHibernateDao.getCatEditById(categoryBean));
		}
		catList = masterHibernateDao.getCategryList();
		return SUCCESS;
	}
	
	//Product page action 
		public String saveProduct(){
			if (productBean != null) {
				masterHibernateDao.addProductdata(productBean);
				return SUCCESS;
			}
			
			return INPUT;
		}
		
		public String deleteProduct() {
			if(productBean!=null && productBean.getProductId()!=null) {
				masterHibernateDao.deleteProductById(productBean);
			}
			setProdList(masterHibernateDao.getProductList());
			return SUCCESS;
		}
		
		public String editProduct() {
			if(productBean!=null && productBean.getProductId()!=null) {
				setProductBean(masterHibernateDao.getProdEditById(productBean));
			}
			prodList = masterHibernateDao.getProductList();
			catList = masterHibernateDao.getCategryList();
			return SUCCESS;
		}
	
		//add modeldata
		public String saveModel() {
			if (modelBean != null) {
					masterHibernateDao.saveModell(modelBean);
					return SUCCESS;
			}
			return INPUT;
		}
		//deleteModel
		public String deleteModel() {
			if(modelBean!=null && modelBean.getModelId()!=null) {
				masterHibernateDao.deleteModelById(modelBean);
			}
			setProdList(masterHibernateDao.getProductList());
			return SUCCESS;
		}
		
		//edit model
		public String editModel() {
			if(modelBean!=null && modelBean.getModelId()!=null) {
				setModelBean(masterHibernateDao.getModelEditById(modelBean));
			}
			modelList = masterHibernateDao.getModelList();
			return SUCCESS;
		}
		
		//carat page action
		public String saveCarat(){
			if (caratBean != null) {
				masterHibernateDao.addCaratdata(caratBean);
				return SUCCESS;
			}
			
			return INPUT;
		}
		
		public String deleteCarat() {
			if(caratBean!=null && caratBean.getCaratId()!=null) {
				masterHibernateDao.deleteCaratById(caratBean);
			}
			setCaratList(masterHibernateDao.getCaratList());
			return SUCCESS;
		}
		
		public String editCarat() {
			if(caratBean!=null && caratBean.getCaratId()!=null) {
				setCaratBean(masterHibernateDao.getCaratEditById(caratBean));
			}
			caratList = masterHibernateDao.getCaratList();
			return SUCCESS;
		}
		
		//Rate page action
				public String saveRate(){
					if (rateBean != null) {
						masterHibernateDao.addRatedata(rateBean);
						return SUCCESS;
					}
					
					return INPUT;
				}
				
				public String deleteRate() {
					if(rateBean!=null && rateBean.getRateId()!=null) {
						masterHibernateDao.deleteRateById(rateBean);
					}
					setRateList(masterHibernateDao.getRateList());
					return SUCCESS;
				}
		
				public String editRate() {
					if(rateBean!=null && rateBean.getRateId()!=null) {
						setRateBean(masterHibernateDao.getRateEditById(rateBean));
					}
					rateList = masterHibernateDao.getRateList();
					return SUCCESS;
				}
				
				//Customer page action 
				public String saveCustomer(){
					if (customerBean != null) {
						masterHibernateDao.addCustomerdata(customerBean);
						return SUCCESS;
					}
					
					return INPUT;
				}
				
				//delete customer
				public String deleteCustomer() {
					if(customerBean!=null && customerBean.getCustomerId() !=null) {
						masterHibernateDao.deleteCustomerById(customerBean);
					}
					setCustomerList(masterHibernateDao.getCustomerList());
					return SUCCESS;
				}
				
				//edit customer
				public String editCustomer() {
					if(customerBean!=null && customerBean.getCustomerId()!=null) {
						setCustomerBean(masterHibernateDao.getCustomerEditById(customerBean));
					}
					customerList = masterHibernateDao.getCustomerList();
					return SUCCESS;
				}
				
				//vendor page action 
				public String saveVendor(){
					if (vendorBean != null) {
						masterHibernateDao.addVendordata(vendorBean);
						return SUCCESS;
					}
					
					return INPUT;
				}
				
				//delete vendor
				public String deleteVendor() {
					if(vendorBean!=null && vendorBean.getVendorId() !=null) {
						masterHibernateDao.deleteVendorById(vendorBean);
					}
					setVendorList(masterHibernateDao.getVendorList());
					return SUCCESS;
				}
				
				//edit vendor
				public String editVendor() {
					if(vendorBean!=null && vendorBean.getVendorId()!=null) {
						setVendorBean(masterHibernateDao.getVendorEditById(vendorBean));
					}
					vendorList = masterHibernateDao.getVendorList();
					return SUCCESS;
				}
				
				//purchse list
				public String getProductListForPurchase() {
					prodList = masterHibernateDao.getProductList();
					return SUCCESS;
				}
				
				public String getmodalForPurchase() {
					return SUCCESS;
				}
				
				//vendor page action 
				public String savepurchaseVendor(){
					if (purchaseBean != null) {
					Integer vendid=	masterHibernateDao.getvendorDetails(purchaseBean.getVendor().getVendorCode());
					purchaseBean.setVendor(new VendorBean());
					purchaseBean.getVendor().setVendorId(vendid);
						masterHibernateDao.addPurchasevendor(purchaseBean);
						return SUCCESS;
					}
					
					return INPUT;
				}
				
	public TaxBean getTaxBean() {
		return taxBean;
	}

	public void setTaxBean(TaxBean taxBean) {
		this.taxBean = taxBean;
	}

	public List<TaxBean> getTaxList() {
		return taxList;
	}

	public void setTaxList(List<TaxBean> taxList) {
		this.taxList = taxList;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public List<CategoryBean> getCatList() {
		return catList;
	}

	public void setCatList(List<CategoryBean> catList) {
		this.catList = catList;
	}

	public ProductBean getProductBean() {
		return productBean;
	}

	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}

	public List<ProductBean> getProdList() {
		return prodList;
	}

	public void setProdList(List<ProductBean> prodList) {
		this.prodList = prodList;
	}

	public modelBean getModelBean() {
		return modelBean;
	}

	public void setModelBean(modelBean modelBean) {
		this.modelBean = modelBean;
	}

	public List<modelBean> getModelList() {
		return modelList;
	}

	public void setModelList(List<modelBean> modelList) {
		this.modelList = modelList;
	}

	public CaratBean getCaratBean() {
		return caratBean;
	}

	public void setCaratBean(CaratBean caratBean) {
		this.caratBean = caratBean;
	}

	public List<CaratBean> getCaratList() {
		return caratList;
	}

	public void setCaratList(List<CaratBean> caratList) {
		this.caratList = caratList;
	}

	public RateBean getRateBean() {
		return rateBean;
	}

	public void setRateBean(RateBean rateBean) {
		this.rateBean = rateBean;
	}

	public List<RateBean> getRateList() {
		return rateList;
	}

	public void setRateList(List<RateBean> rateList) {
		this.rateList = rateList;
	}

	public CustomerBean getCustomerBean() {
		return customerBean;
	}

	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}

	public List<CustomerBean> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerBean> customerList) {
		this.customerList = customerList;
	}

	public VendorBean getVendorBean() {
		return vendorBean;
	}

	public void setVendorBean(VendorBean vendorBean) {
		this.vendorBean = vendorBean;
	}

	public List<VendorBean> getVendorList() {
		return vendorList;
	}

	public void setVendorList(List<VendorBean> vendorList) {
		this.vendorList = vendorList;
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
