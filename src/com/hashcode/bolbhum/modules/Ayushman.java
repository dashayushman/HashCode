package com.hashcode.bolbhum.modules;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import com.hashcode.bolbhum.utility.Utils;

public class Ayushman {
	public static void main(String[] args) {
		try {
			String filecontent = Utils.getInstance().getStringFromFile("G:\\Github\\HashCode\\HashCode\\learn_and_teach.in");
			System.out.println(filecontent);
			ArrayList<String> lines = Utils.getInstance().getLineStringsFromFile("G:\\Github\\HashCode\\HashCode\\learn_and_teach.in");
			for (String string : lines) {
				System.out.println(string);
			}
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
}
