package org.tesseract.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "tesseract", name = "purchasereturnamount")
public class PurchaseReturnAmountBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchase_return_amount_id")
	private Integer purchaseReturnAmountId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="purchaseId")
	private PurchaseBean purchaseId;
	
	@Column(name = "grossamount")
	private Double grossamount;
	
	@Column(name = "roundoff")
	private Double roundoff;
	
	@Column(name = "netamount")
	private Double netamount;

	public Integer getPurchaseReturnAmountId() {
		return purchaseReturnAmountId;
	}

	public void setPurchaseReturnAmountId(Integer purchaseReturnAmountId) {
		this.purchaseReturnAmountId = purchaseReturnAmountId;
	}

	public PurchaseBean getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(PurchaseBean purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Double getGrossamount() {
		return grossamount;
	}

	public void setGrossamount(Double grossamount) {
		this.grossamount = grossamount;
	}

	public Double getRoundoff() {
		return roundoff;
	}

	public void setRoundoff(Double roundoff) {
		this.roundoff = roundoff;
	}

	public Double getNetamount() {
		return netamount;
	}

	public void setNetamount(Double netamount) {
		this.netamount = netamount;
	}

	
	
}
