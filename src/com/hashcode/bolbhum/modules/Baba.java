package com.hashcode.bolbhum.modules;

import java.util.ArrayList;

import com.hashcode.bolbhum.beans.Drone;
import com.hashcode.bolbhum.beans.Order;
import com.hashcode.bolbhum.beans.Params;
import com.hashcode.bolbhum.utility.Utils;

public class Baba {
	public static void main(String[] args) {
		try {
			Utils utils = Utils.getInstance();
			Params params = utils.getParameters();
			ArrayList<Order> ordersList = params.getOrdersList();

		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			switch (message) {
			case "101":
				break;
			case "102":
				break;
			default:
				break;
			}
		}
	}

	public static Drone getDrone(Order tempOrder) {
		Utils utils = Utils.getInstance();
		Params params = utils.getParameters();
		ArrayList<Order> ordersList = params.getOrdersList();
		int bestOrder;
		int bestOrderWeight = 1000000;
		int orderWeight = 10000;
		Order tempOrder1;
		Drone tempDrone;
		int pos1i, pos1j, pos2i, pos2j;

		ArrayList<Drone> droneList = params.getDroneList();
		for (int i = 0; i < droneList.size(); i++) {
			tempDrone = droneList.get(i);
			pos1i = tempOrder1.getLocation().getRow();
			pos1j = tempOrder1.getLocation().getColumn();

			pos2i = tempDrone.getLocation().getRow();
			pos2j = tempDrone.getLocation().getColumn();

			orderWeight = euclidDistance(pos1i, pos1j, pos2i, pos2j)
					+ tempDrone.getEnd();
			if (orderWeight < bestOrderWeight) {
				bestOrderWeight = orderWeight;
				bestOrder = i;
			}
		}
		droneList.get(bestOrder).setStart(droneList.get(bestOrder).getEnd());
		return droneList.get(bestOrder);
	}

	public static int euclidDistance(int pos1i, int pos1j, int pos2i, int pos2j) {
		double temp = Math.pow(pos1i - pos2i, 2) + Math.pow(pos1j - pos2j, 2);
		temp = Math.sqrt(temp);
		temp = Math.ceil(temp);
		return (int) temp;
	}

	public static Order getOrder() {
		Utils utils = Utils.getInstance();
		Params params = utils.getParameters();
		ArrayList<Order> ordersList = params.getOrdersList();
		int bestOrder;
		int bestOrderWeight = 1000000;
		int orderWeight = 10000;
		Order tempOrder;
		Drone tempDrone;
		int pos1i, pos1j, pos2i, pos2j;

		ArrayList<Drone> droneList = params.getDroneList();
		for (int i = 0; i < ordersList.size(); i++) {
			for (int j = 0; j < droneList.size(); j++) {
				tempOrder = ordersList.get(i);
				tempDrone = droneList.get(j);
				pos1i = tempOrder.getLocation().getRow();
				pos1j = tempOrder.getLocation().getColumn();

				pos2i = tempDrone.getLocation().getRow();
				pos2j = tempDrone.getLocation().getColumn();

				orderWeight = euclidDistance(pos1i, pos1j, pos2i, pos2j)
						+ tempDrone.getEnd();
				if (orderWeight < bestOrderWeight) {
					bestOrderWeight = orderWeight;
					bestOrder = i;
				}
			}
		}
		return ordersList.get(bestOrder);
	}
}
