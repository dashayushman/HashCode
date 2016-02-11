package com.hashcode.bolbhum.beans;

import java.util.HashMap;

public class WareHouse {
	private Integer wareHouseId;
	private Location location;
	private HashMap<Integer, Integer> ProductTypeToNumOfItemsMap;
	public Integer getWareHouseId() {
		return wareHouseId;
	}
	public void setWareHouseId(Integer wareHouseId) {
		this.wareHouseId = wareHouseId;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public HashMap<Integer, Integer> getProductTypeToNumOfItemsMap() {
		return ProductTypeToNumOfItemsMap;
	}
	public void setProductTypeToNumOfItemsMap(
			HashMap<Integer, Integer> productTypeToNumOfItemsMap) {
		ProductTypeToNumOfItemsMap = productTypeToNumOfItemsMap;
	}
	
}
