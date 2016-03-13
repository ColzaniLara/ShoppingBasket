package it.main.sb.purchase;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import it.main.sb.beans.ItemPurchased;

public class ShoppingBasket {
	private static final Logger logger = Logger.getLogger("loggerSB");
	private static final Double IMPORT_RATE=0.05;
	private static final Double BASIC_TAX_RATE=0.1;
	private ArrayList<ItemPurchased> items=new ArrayList<ItemPurchased>();
	private double totaltaxes=0.0;
	private double totalBasket=0.0;
	
	public void addToBasket(ItemPurchased itemP){
		logger.debug("AddItem");
		items.add(itemP);
		logger.debug("Added Item :"+itemP.toString());
		//return items;
	}
	
	public ArrayList<ItemPurchased> getItemPurchased()
	{
		return items;
	}
	
	private double importDuty(ItemPurchased itemP){
		Double duty=0.0;
		if(itemP.isFlagImport()){
				duty=itemP.getPrice()*IMPORT_RATE;
		}
		return duty;
	}
	
	private double gettaxesForItem(ItemPurchased itemP){
		Double taxes=0.0;
		if(!itemP.isFlagExempt()){
			taxes=itemP.getPrice()*BASIC_TAX_RATE;
		}
		return taxes;
	}
	
	public Double getTotTaxForItem(ItemPurchased itemP){
		return gettaxesForItem(itemP)+importDuty(itemP);
	}
	
	
	public Double getItemTotPrice(ItemPurchased itemP){
		return itemP.getPrice()+getTotTaxForItem(itemP);
	}
	
	
}
