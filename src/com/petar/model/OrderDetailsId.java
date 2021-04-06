package com.petar.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class OrderDetailsId implements Serializable {
	
	private Integer orderNumber;
	
	private String productCode;

	public OrderDetailsId() {}
	
	public OrderDetailsId(Integer orderNumber, String productCode) {
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((productCode == null) ? 0 : productCode.hashCode());
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
		OrderDetailsId other = (OrderDetailsId) obj;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (productCode == null) {
			if (other.productCode != null)
				return false;
		} else if (!productCode.equals(other.productCode))
			return false;
		return true;
	}

	
}
