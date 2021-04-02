package com.petar.model;

import java.io.Serializable;

public class PaymentId implements Serializable {
	
	private Integer customer;
	
	private String checkNumber;
	
	public PaymentId() {}

	public PaymentId(Integer customer, String checkNumber) {
		this.customer = customer;
		this.checkNumber = checkNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaymentId other = (PaymentId) obj;
		if (checkNumber == null) {
			if (other.checkNumber != null)
				return false;
		} else if (!checkNumber.equals(other.checkNumber))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
}
