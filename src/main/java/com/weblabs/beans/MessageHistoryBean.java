package com.weblabs.beans;

public class MessageHistoryBean {

	private String mssghistory_id;
	private String  phone_number;
	private String  otp;
	private String  deliveryStatus;
	private String  current_date;
	
	public String getMssghistory_id() {
		return mssghistory_id;
	}
	public void setMssghistory_id(String mssghistory_id) {
		this.mssghistory_id = mssghistory_id;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}

}
