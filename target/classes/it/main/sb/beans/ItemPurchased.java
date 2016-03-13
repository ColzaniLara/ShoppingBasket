package it.main.sb.beans;

import org.apache.log4j.Logger;

public class ItemPurchased {

	private static final Logger logger = Logger.getLogger("loggerSB");
	
	private String itemName="";
	private Double price=0.0;
	private int qty=0;
	private boolean flagImport=false;
	private boolean flagExempt=false;
	
	public boolean isFlagExempt() {
		return flagExempt;
	}
	public void setFlagExempt(boolean flagExempt) {
		this.flagExempt = flagExempt;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public boolean isFlagImport() {
		return flagImport;
	}
	public void setFlagImport(boolean flagImport) {
		this.flagImport = flagImport;
	}
		
	public String getItemName() {
		logger.info("itemName "+itemName);
		return itemName;
	}
	public void setItemName(String itemName) {
		logger.info("itemName "+itemName);
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString(ItemPurchased itemP){
		String riepilogo="";
		if(itemP.isFlagImport()){
			riepilogo= qty +" imported "+"name: "+itemP.getItemName()+" at "+price;
		}else{
			riepilogo= qty +"name: "+itemP.getItemName()+" at "+price;
		}
		return riepilogo;
	}
	
}
