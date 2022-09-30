package com.furniture.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue
	private Integer paymentId;
	
	@NotNull(message = "Name cannot be null.")
	@Size(min = 3, message = "cardName should be of min 3 chars.")
	private String cardName;
	
	@Size(min = 10, message = "cardNumber should be of min 10 digit.")
	private String cardNumber;
	
	@Size(max = 3,message="Cvv Should be of min 3 digit")
	private String cvvNo;
	
	@Size(min = 3, message = "BankName should be of min 3 chars.")
	private String bankName;
	private String cardExpiry;
	private String status;
	
	
	public Payment() {
		super();
	}

	public Payment(Integer paymentId,
			@NotNull(message = "Name cannot be null.") @Size(min = 3, message = "cardName should be of min 3 chars.") String cardName,
			@Size(min = 10, message = "cardNumber should be of min 10 digit.") String cardNumber,
			@Size(max = 3, message = "Cvv Should be of min 3 digit") String cvvNo,
			@Size(min = 3, message = "BankName should be of min 3 chars.") String bankName, String cardExpiry,
			String status) {
		super();
		this.paymentId = paymentId;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cvvNo = cvvNo;
		this.bankName = bankName;
		this.cardExpiry = cardExpiry;
		this.status = status;
	}

	public Payment(
			@NotNull(message = "Name cannot be null.") @Size(min = 3, message = "cardName should be of min 3 chars.") String cardName,
			@Size(min = 10, message = "cardNumber should be of min 10 digit.") String cardNumber,
			@Size(max = 3, message = "Cvv Should be of min 3 digit") String cvvNo,
			@Size(min = 3, message = "BankName should be of min 3 chars.") String bankName, String cardExpiry,
			String status) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cvvNo = cvvNo;
		this.bankName = bankName;
		this.cardExpiry = cardExpiry;
		this.status = status;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
