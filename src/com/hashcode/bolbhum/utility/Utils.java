package com.hashcode.bolbhum.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.hashcode.bolbhum.beans.Drone;
import com.hashcode.bolbhum.beans.Params;

public class Utils {
	
	//101 : getStringFromFile file read error
	//102 : File closing error 
	//103 :
	//104 : 
	//105 : 

	private Params parameters;
	
	
	public Params getParameters() {
		return parameters;
	}

	public void setParameters(Params parameters) {
		this.parameters = parameters;
	}

	public static Utils getUtils() {
		return utils;
	}

	public static void setUtils(Utils utils) {
		Utils.utils = utils;
	}

	private static Utils utils = new Utils();

	private Utils() {
	}

	public static Utils getInstance() {
		return utils;
	}
	
	public void writeStringToFile(String filePath,String fileContent) throws IOException{
		File file = new File(filePath);
		String content =fileContent;

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
			throw new IOException("105");
		}
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
			System.out.println("number of lines in file = " + fileContent.size());
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
	
	public ArrayList<ArrayList<String>> create2DStringMatrix(){
		return new ArrayList<ArrayList<String>>();
	}
	
	public int loadParams(ArrayList<String> fileLinsList){
		if(parameters == null){
			parameters = new Params();
		}
		ArrayList<Drone> droneList = new ArrayList<Drone>();
		HashMap<Integer, Drone> droneMap = new HashMap<Integer, Drone>();
		int lineCounter = 0;
		
		while(lineCounter <= (fileLinsList.size() - 1) ){
			
			System.out.println(fileLinsList.get(lineCounter));
			
			if(lineCounter == 0){
				String[] basicParams = fileLinsList.get(lineCounter).split(" ");
				parameters.setTotalRows(Integer.parseInt(basicParams[0]));
				parameters.setTotalCols(Integer.parseInt(basicParams[1]));
				parameters.setTotalDrones(Integer.parseInt(basicParams[2]));
				parameters.setMaxDuration(Integer.parseInt(basicParams[3]));
				parameters.setMaxPayload(Integer.parseInt(basicParams[4]));
				
				for (int i = 0; i < parameters.getTotalDrones(); i++) {
					Drone drone = new Drone();
					drone.setDroneId(i);
					drone.setTotalWeight(parameters.getMaxPayload());
					droneList.add(drone);
					droneMap.put(i, drone);
				}
				parameters.setDroneList(droneList);
				parameters.setDroneMap(droneMap);
				lineCounter++;
				continue;
			}
			if(lineCounter == 2){
				parameters.setTotalNumberOfProductTypes();
			}
		}
		return 0;
	}

}
