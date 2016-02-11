package com.hashcode.bolbhum.beans;

import java.util.ArrayList;

public class Response {
	private Integer totalCommands;
	private ArrayList<String> commandList;

	public Integer getTotalCommands() {
		return totalCommands;
	}

	public void setTotalCommands(Integer totalCommands) {
		this.totalCommands = totalCommands;
	}

	public ArrayList<String> getCommandList() {
		return commandList;
	}

	public void setCommandList(ArrayList<String> commandList) {
		this.commandList = commandList;
	}

}
