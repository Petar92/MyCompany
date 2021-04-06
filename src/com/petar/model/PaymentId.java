package com.petar.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PaymentId implements Serializable {
	
	private Integer customerNumber;
	
	private String checkNumber;
	
	public PaymentId() {}

	public PaymentId(Integer customerNumber, String checkNumber) {
		this.customerNumber = customerNumber;
		this.checkNumber = checkNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkNumber == null) ? 0 : checkNumber.hashCode());
		result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
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
		if (customerNumber == null) {
			if (other.customerNumber != null)
				return false;
		} else if (!customerNumber.equals(other.customerNumber))
			return false;
		return true;
	}
}
