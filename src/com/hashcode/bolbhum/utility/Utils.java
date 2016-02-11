package com.hashcode.bolbhum.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import com.hashcode.bolbhum.beans.Drone;
import com.hashcode.bolbhum.beans.Location;
import com.hashcode.bolbhum.beans.Order;
import com.hashcode.bolbhum.beans.Params;
import com.hashcode.bolbhum.beans.ProductType;
import com.hashcode.bolbhum.beans.WareHouse;

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
		
		ArrayList<ProductType> productTypeList = new ArrayList<ProductType>();
		HashMap<Integer, ProductType> prooductTypeMap = new HashMap<Integer, ProductType>();
		
		ArrayList<WareHouse> wareHouseList = new ArrayList<WareHouse>();
		HashMap<Integer, WareHouse> wareHouseMap = new HashMap<Integer, WareHouse>();
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		HashMap<Integer, Order> orderMap = new HashMap<Integer, Order>();
		
		int lineCounter = 0;
		
		while(lineCounter <= (fileLinsList.size() - 1) ){
			
			System.out.println(fileLinsList.get(lineCounter));
			//first line
			if(lineCounter == 0){
				String[] basicParams = fileLinsList.get(lineCounter).split(" ");
				parameters.setTotalRows(Integer.parseInt(basicParams[0]));
				parameters.setTotalCols(Integer.parseInt(basicParams[1]));
				parameters.setTotalDrones(Integer.parseInt(basicParams[2]));
				parameters.setMaxDuration(Integer.parseInt(basicParams[3]));
				parameters.setMaxPayload(Integer.parseInt(basicParams[4]));
				
				for (int i = 0; i < parameters.getTotalDrones(); i++) {
					Location loc = new Location();
					loc.setColumn(0);
					loc.setRow(0);
					Drone drone = new Drone();
					drone.setDroneId(i);
					drone.setTotalWeight(parameters.getMaxPayload());
					drone.setLocation(loc);
					droneList.add(drone);
					droneMap.put(i, drone);
				}
				parameters.setDroneList(droneList);
				parameters.setDroneMap(droneMap);
				lineCounter++;
				continue;
			}
			
			//second line
			
			if(lineCounter == 1){
				parameters.setTotalNumberOfProductTypes(Integer.parseInt(fileLinsList.get(lineCounter)));
				lineCounter++;
				continue;
			}
			
			// line 3
			if(lineCounter == 2){
				String[] prodTypeWeights = fileLinsList.get(lineCounter).split(" ");
				for (int i = 0; i < parameters.getTotalNumberOfProductTypes(); i++) {
					ProductType pt = new ProductType();
					pt.setProductTypeId(i);
					pt.setProductTypeWeight(Integer.parseInt(prodTypeWeights[i]));
					productTypeList.add(pt);
					prooductTypeMap.put(i, pt);
				}
				parameters.setProductTypeList(productTypeList);
				parameters.setProductTypeMap(prooductTypeMap);
				lineCounter++;
				continue;
			}
			
			//4
			if(lineCounter == 3){
				parameters.setTotalWareHouse(Integer.parseInt(fileLinsList.get(lineCounter)));
				lineCounter++;
				continue;
			}
			
			//line 5
			if(lineCounter == 4){
				
				
				for (int i = 0; i < parameters.getTotalWareHouse(); i++) {
					WareHouse warehouse = new WareHouse();
					String[] wareHouseLocation = fileLinsList.get(lineCounter).split(" ");
					Location location = new Location();
					location.setRow(Integer.parseInt(wareHouseLocation[0]));
					location.setColumn(Integer.parseInt(wareHouseLocation[1]));
					warehouse.setLocation(location);
					
					lineCounter++;
					ArrayList<Integer> prodTypeList = new ArrayList<Integer>();
					HashMap<Integer, Integer> productMap = new HashMap<Integer, Integer>();
					String[] itemsPerProdType = fileLinsList.get(lineCounter).split(" ");
					for (int j = 0; j < parameters.getTotalNumberOfProductTypes(); j++) {
						prodTypeList.add(j);
						productMap.put(j, Integer.parseInt(itemsPerProdType[j]));
					}
					warehouse.setProductTypeList(prodTypeList);
					warehouse.setProductTypeToNumOfItemsMap(productMap);
					wareHouseList.add(warehouse);
					wareHouseMap.put(i, warehouse);
					lineCounter++;
					continue;
				}
				parameters.setWareHouseList(wareHouseList);
				parameters.setWareHouseMap(wareHouseMap);
//				lineCounter++;
				continue;
			}
			
			parameters.setTotalNumberOfCustomerOrders(Integer.parseInt(fileLinsList.get(lineCounter)));
			lineCounter++;
			
			for (int i = 0; i < parameters.getTotalNumberOfCustomerOrders(); i++) {
				Order order = new Order();
				order.setOrderId(i);
				ArrayList<Integer> productTypeOrderList = new ArrayList<Integer>();
				HashMap<Integer, Integer> productTypeToItemsMap = new HashMap<Integer, Integer>();
				
				Location location = new Location();
				String[] orderLocParam = fileLinsList.get(lineCounter).split(" ");
				location.setRow(Integer.parseInt(orderLocParam[0]));
				location.setColumn(Integer.parseInt(orderLocParam[1]));
				order.setLocation(location);
				
				lineCounter++;
				
				order.setTotalItems(Integer.parseInt(fileLinsList.get(lineCounter)));
				
				lineCounter++;
				String[] prodTypesInOrder = fileLinsList.get(lineCounter).split(" ");

				for (int k = 0; k < prodTypesInOrder.length; k++) {
					Integer prodTypeInt = Integer.parseInt(prodTypesInOrder[k]);
					productTypeOrderList.add(prodTypeInt);
					if (productTypeToItemsMap.containsKey(prodTypeInt)) {
						productTypeToItemsMap.put(prodTypeInt,
								(productTypeToItemsMap.get(prodTypeInt) + 1));
					} else {
						productTypeToItemsMap.put(prodTypeInt, 1);
					}
				}
				order.setProductTypeList(productTypeOrderList);
				order.setProductTypeIdToNumOfItemsMap(productTypeToItemsMap);
				orderList.add(order);
				orderMap.put(i, order);
				lineCounter++;
			}
			parameters.setOrdersList(orderList);
			parameters.setCustomerOrderMap(orderMap);
		}
		return 1;
	}

}
