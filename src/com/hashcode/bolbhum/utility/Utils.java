package com.hashcode.bolbhum.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Utils {

	private static Utils utils = new Utils();

	private Utils() {
	}

	public static Utils getInstance() {
		return utils;
	}

	public String getStringFromFile(String fileName) throws Exception {

		File file = new File(fileName);
		InputStream fis = null;
		String fileContent = "";

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			fileContent = getStringFromInputStream(fis);
			return fileContent;

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("101");//error x
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new Exception("102");
			}
		}

	}

	public ArrayList<String> getLineStringsFromFile(String fileName)
			throws Exception {

		File file = new File(fileName);
		InputStream fis = null;
		ArrayList<String> fileContent = new ArrayList<String>();

		try {
			fis = new FileInputStream(file);

			System.out.println("Total file size to read (in bytes) : "
					+ fis.available());

			fileContent = getLineStringsFromInputStream(fis);
			return fileContent;

		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("103");
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
				throw new Exception("104");
			}
		}

	}

	public ArrayList<String> getLineStringsFromInputStream(InputStream is) {

		BufferedReader br = null;
		ArrayList<String> sb = new ArrayList<String>();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb;

	}

	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
