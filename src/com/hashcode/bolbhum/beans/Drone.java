package com.hashcode.bolbhum.beans;

public class Drone {
	private Integer droneId;

	private Integer totalWeight;

	private Location location;
	private Integer startTime;
	private Integer endTime;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	private Integer currentOrderId;

	public Integer getDroneId() {
		return droneId;
	}

	public void setDroneId(Integer droneId) {
		this.droneId = droneId;
	}

	public Integer getTotalWeight() {
		return this.totalWeight;
	}

	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}

	public void setcurrentOrderId(Integer OrderId) {
		this.currentOrderId = OrderId;
	}

	public Integer getcurrentOrderId() {
		return this.currentOrderId;
	}

}
