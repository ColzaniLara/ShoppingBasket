package main.sb.beans;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

public class ItemPurchased {

	private static final double IMPORT_RATE=0.05;
	private static final double BASIC_TAX_RATE=0.10;

	private static final Logger logger = Logger.getLogger(Logger.class);
	
	private String itemName="";
	private double price=0.00;
	private int qty=0;
	private boolean flagImport=false;
	private boolean flagExempt=false;
	private double totPrice=0.00;
	private double totTax=0.00;
	private double taxes=0.00;
	private double duty=0.00;
	
	public ItemPurchased(){
		this.itemName="";
		this.price=0.00;
		this.qty=00;
		this.flagImport=false;
		this.flagExempt=false;
		this.totPrice=0.00;
		this.totTax=0.00;
		
	}
	
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
		//logger.info("itemName "+itemName);
		return itemName;
	}
	public void setItemName(String itemName) {
		//logger.info("itemName "+itemName);
		this.itemName = itemName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public String toString(){
		String riepilogo="";
		if(this.isFlagImport()){
			riepilogo= this.qty +" imported "+" "+this.getItemName()+" at "+this.price;
		}else{
			riepilogo= this.qty +" "+this.getItemName()+" at "+this.price;
		}
		return riepilogo;
	}

	//Questi vanno spostati sotto item o sotto calculator
		public double importDutyForItem(){
			//this.duty=0.00;
			if(this.isFlagImport()){
					this.duty=roundOne(this.getPrice()*IMPORT_RATE);
			}
			return this.duty;
		}
		
		public double gettaxesForItem(){
			//this.taxes=0.00;
			if(!this.isFlagExempt()){
				//logger.info("this.getPrice()"+this.getPrice());
				this.taxes= round(this.getPrice()*BASIC_TAX_RATE);
			}
			return this.taxes;
		}
		
		public double getTotTaxForItem(){
		this.totTax=this.gettaxesForItem()+this.importDutyForItem();
			return this.totTax;
		}
		
		
		public double getItemTotPrice(){
			//logger.debug("QUIIIIIIIIIIIIIII"+this.getPrice()+"  "+this.getTotTaxForItem());
			this.totPrice=round(this.getPrice()+this.getTotTaxForItem());
			if(this.flagImport){
				logger.debug(this.getQty()+" imported "+this.getItemName()+" "+this.totPrice);
			}else{
				logger.debug(this.getQty()+" "+this.getItemName()+" "+this.totPrice);
			}
			return this.totPrice;
		}
		
		private double round(Double toround){
		    double roundOff = (Math.round(toround*100.00))/100.00;
		    return roundOff;
		}
		
		private double roundOne(Double toround){
		    double roundOff = (Math.round(toround*10.0))/10.0;
		    //logger.debug("round"+roundOff);
		    //DecimalFormat no = new DecimalFormat("#.####");
		    //no.format(toround);
		    return roundOff;
		}
		
	
}
