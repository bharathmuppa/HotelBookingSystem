package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoomType {
	private int typeId;
	private String size;
	private String ac;
	private String kitchen;
	private int price;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ac == null) ? 0 : ac.hashCode());
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
		result = prime * result + price;
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		result = prime * result + typeId;
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
		RoomType other = (RoomType) obj;
		if (ac == null) {
			if (other.ac != null)
				return false;
		} else if (!ac.equals(other.ac))
			return false;
		if (kitchen == null) {
			if (other.kitchen != null)
				return false;
		} else if (!kitchen.equals(other.kitchen))
			return false;
		if (price != other.price)
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		if (typeId != other.typeId)
			return false;
		return true;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

	@Override
	public String toString() {
		return "RoomType [typeId=" + typeId + ", size=" + size + ", ac=" + ac + ", kitchen=" + kitchen + ", price="
				+ price + "]";
	}

}
