package main.sb.purchase;

import java.util.HashMap;

import main.sb.beans.ItemPurchased;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class Calculator {

	private static final Logger logger = Logger.getLogger(Logger.class);
	
	
	public static void calculateReceipt(JSONArray obj) {
	
		ShoppingBasket shoppingBasket= new ShoppingBasket();
		logger.info("INPUT");
		//System.out.println("INPUT");
		
		for(int i=0; i<obj.length(); i++){
			//logger.info("Input: "+(i+1));
			JSONObject inputParams = obj.getJSONObject(i);
			String itemName=inputParams.getString("ItemName");
			double price=inputParams.getDouble("Price");
			boolean flagExempt=inputParams.getBoolean("FlagExempt");
			boolean flagImport=inputParams.getBoolean("FlagImport");
			
			ItemPurchased itemP=new ItemPurchased();
			itemP.setItemName(itemName);
			itemP.setQty(1);
			itemP.setPrice(price);
			itemP.setFlagImport(flagImport);
			itemP.setFlagExempt(flagExempt);
			shoppingBasket.addToBasket(itemP);
			
		}
		
		
		
		
		
		logger.info("OUTPUT");
		for(int i=0; i<shoppingBasket.getItemPurchased().size(); i++)
		{
			//logger.info("Output "+(i+1)+":");
			shoppingBasket.getItemPurchased().get(i).getItemTotPrice();
		}
		
		
		logger.info("Sales Taxes: "+shoppingBasket.totTaxes());
		logger.info("Total: "+shoppingBasket.totBasket());
		
	}
}
