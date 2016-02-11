package com.hashcode.bolbhum.beans;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Params {

	// main params
	private Integer totalRows;
	private Integer totalCols;

	private Integer maxDuration;
	private Integer maxPayload;

	// drones
	private Integer totalDrones;
	private HashMap<Integer, Drone> droneMap;
	private ArrayList<Drone> droneList;

	// products

	private Integer totalNumberOfProductTypes;
	private HashMap<Integer, ProductType> productTypeMap;
	private ArrayList<ProductType> productTypeList;

	// warehouse
	private Integer totalWareHouse;
	private HashMap<Integer, WareHouse> wareHouseMap;
	private ArrayList<WareHouse> wareHouseList;

	// cust orders
	private Integer totalNumberOfCustomerOrders;
	private HashMap<Integer, Order> customerOrderMap;
	private ArrayList<Order> ordersList;

	public Integer getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	public Integer getTotalCols() {
		return totalCols;
	}

	public void setTotalCols(Integer totalCols) {
		this.totalCols = totalCols;
	}

	public Integer getMaxDuration() {
		return maxDuration;
	}

	public void setMaxDuration(Integer maxDuration) {
		this.maxDuration = maxDuration;
	}

	public Integer getTotalDrones() {
		return totalDrones;
	}

	public void setTotalDrones(Integer totalDrones) {
		this.totalDrones = totalDrones;
	}

	public HashMap<Integer, Drone> getDroneMap() {
		return droneMap;
	}

	public void setDroneMap(HashMap<Integer, Drone> droneMap) {
		this.droneMap = droneMap;
	}

	public ArrayList<Drone> getDroneList() {
		return droneList;
	}

	public void setDroneList(ArrayList<Drone> droneList) {
		this.droneList = droneList;
	}

	public Integer getTotalNumberOfProductTypes() {
		return totalNumberOfProductTypes;
	}

	public void setTotalNumberOfProductTupes(Integer totalNumberOfProducts) {
		this.totalNumberOfProductTypes = totalNumberOfProducts;
	}

	public HashMap<Integer, ProductType> getProductTypeMap() {
		return productTypeMap;
	}

	public void setProductTypeMap(HashMap<Integer, ProductType> productTypeMap) {
		this.productTypeMap = productTypeMap;
	}

	public ArrayList<ProductType> getProductTypeList() {
		return productTypeList;
	}

	public void setProductTypeList(ArrayList<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}

	public Integer getTotalWareHouse() {
		return totalWareHouse;
	}

	public void setTotalWareHouse(Integer totalWareHouse) {
		this.totalWareHouse = totalWareHouse;
	}

	public HashMap<Integer, WareHouse> getWareHouseMap() {
		return wareHouseMap;
	}

	public void setWareHouseMap(HashMap<Integer, WareHouse> wareHouseMap) {
		this.wareHouseMap = wareHouseMap;
	}

	public ArrayList<WareHouse> getWareHouseList() {
		return wareHouseList;
	}

	public void setWareHouseList(ArrayList<WareHouse> wareHouseList) {
		this.wareHouseList = wareHouseList;
	}

	public Integer getTotalNumberOfCustomerOrders() {
		return totalNumberOfCustomerOrders;
	}

	public void setTotalNumberOfCustomerOrders(
			Integer totalNumberOfCustomerOrders) {
		this.totalNumberOfCustomerOrders = totalNumberOfCustomerOrders;
	}

	public HashMap<Integer, Order> getCustomerOrderMap() {
		return customerOrderMap;
	}

	public void setCustomerOrderMap(HashMap<Integer, Order> customerOrderMap) {
		this.customerOrderMap = customerOrderMap;
	}

	public ArrayList<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(ArrayList<Order> ordersList) {
		this.ordersList = ordersList;
	}

	public Integer getMaxPayload() {
		return maxPayload;
	}

	public void setMaxPayload(Integer maxPayload) {
		this.maxPayload = maxPayload;
	}

}
