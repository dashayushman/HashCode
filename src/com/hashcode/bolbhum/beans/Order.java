package com.hashcode.bolbhum.beans;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
	private Integer orderId;
	private Location location;
	private HashMap<Integer, Integer> productTypeIdToNumOfItemsMap;
	private ArrayList<Integer> productTypeList;

	public ArrayList<Integer> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(ArrayList<Integer> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public HashMap<Integer, Integer> getProductTypeIdToNumOfItemsMap() {
		return productTypeIdToNumOfItemsMap;
	}

	public void setProductTypeIdToNumOfItemsMap(
			HashMap<Integer, Integer> productTypeIdToNumOfItemsMap) {
		this.productTypeIdToNumOfItemsMap = productTypeIdToNumOfItemsMap;
	}

}
