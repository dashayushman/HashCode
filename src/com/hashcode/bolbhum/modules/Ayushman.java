package com.hashcode.bolbhum.modules;

import java.util.ArrayList;
import java.util.HashMap;

import com.hashcode.bolbhum.beans.Drone;
import com.hashcode.bolbhum.beans.Order;
import com.hashcode.bolbhum.beans.WareHouse;
import com.hashcode.bolbhum.utility.Utils;

public class Ayushman {
	public static void main(String[] args) {
		try {
//			String filecontent = Utils.getInstance().getStringFromFile("G:\\Github\\HashCode\\HashCode\\learn_and_teach.in");
//			System.out.println(filecontent);
			ArrayList<String> lines = Utils.getInstance().getLineStringsFromFile("G:\\Github\\HashCode\\HashCode\\sample.in");
			
			int paramsLoad = Utils.getInstance().loadParams(lines);
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			switch (message) {
			case "101":
				break;
			case "102":
				break;
			case "103":
				break;
			case "104":
				break;
			case "105":
				break;
			default:
				break;
			}
		}
	}
	
	public static ArrayList<WareHouse> getNavgList(Order order, Drone drone){
		ArrayList<WareHouse> tempWarehouses = new ArrayList<WareHouse>();
		ArrayList<WareHouse> Warehouses = Utils.getInstance().getParameters().getWareHouseList();

		for(int i = 0; i < Warehouses.size(); i++) {
		WareHouse tempWarehouse =
		Warehouses.get(i);
		WareHouse w = new WareHouse();
		w.setLocation(tempWarehouse.getLocation());
		w.setProductTypeToNumOfItemsMap(tempWarehouse.getProductTypeToNumOfItemsMap());
		w.setWareHouseId(tempWarehouse.getWareHouseId());

		HashMap<Integer, Integer> ptypeitemOrder = order.getProductTypeIdToNumOfItemsMap();
		HashMap<Integer, Integer> ptypeitemwarehous = w.getProductTypeToNumOfItemsMap();

		ArrayList<Integer> orderProducts = order.getProductTypeList();
		ArrayList<Integer> warehouseProducts = w.getProductTypeList();
		for (int k = 0; k < order.getProductTypeList().size(); k++) {
			for (int j = 0; j < w.getProductTypeList().size(); j++) {
				int opw = ptypeitemOrder.get(k);
				int wpw = ptypeitemwarehous.get(j);
				
				int opid = orderProducts.get(k);
				int wpid = warehouseProducts.get(j);
				
				if(wpid == opid && opw != 0 && wpw != 0){
					tempWarehouses.add(w);
					break;
				}
				
				
			}
		}
			
		}
		return tempWarehouses;
		}
}
