package com.hashcode.bolbhum.beans;

public class Drone {
	private Integer droneId;
	private Integer totalWeight;
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getDroneId() {
		return droneId;
	}

	public void setDroneId(Integer droneId) {
		this.droneId = droneId;
	}

	public Integer getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(Integer totalWeight) {
		this.totalWeight = totalWeight;
	}

}
