package main.sb.purchase;

import java.util.ArrayList;
import java.util.List;

import main.sb.beans.ItemPurchased;

import org.apache.log4j.Logger;


public class ShoppingBasket {
	private static final Logger logger = Logger.getLogger(Logger.class);
	
	private ArrayList<ItemPurchased> items=new ArrayList<ItemPurchased>();
	private double totaltaxes=0.00;
	private double totalBasket=0.00;
	
	public void addToBasket(ItemPurchased itemP){
		//logger.debug("AddItem");
		items.add(itemP);
		logger.debug(itemP.toString());
		//return items;
	}
	
	public ArrayList<ItemPurchased> getItemPurchased()
	{
		return items;
	}
	
	
	//questi sotto calculator o qui
	private double totImportDuty(){
		double totDuty=0.00;
		
		for(int i=0; i<this.getItemPurchased().size(); i++){
			totDuty=totDuty+this.getItemPurchased().get(i).importDutyForItem();
		}
		return totDuty;
	}
	
	public double totTaxes(){
		totaltaxes=0.00;
		for(int i=0; i<this.getItemPurchased().size(); i++){
			totaltaxes=totaltaxes+this.getItemPurchased().get(i).gettaxesForItem();
			totaltaxes=totaltaxes+this.getItemPurchased().get(i).importDutyForItem();	
		}
		//totTaxes=totTaxes+totImportDuty(shoppingBasket);
		return round(totaltaxes);
	}
	
	public double totBasket(){
		totalBasket=0.00;
		for(int i=0; i<this.getItemPurchased().size(); i++){
			totalBasket=totalBasket+this.getItemPurchased().get(i).getPrice();
			totalBasket=totalBasket+this.getItemPurchased().get(i).getTotTaxForItem();
		}
		
		return round(totalBasket);
		
	}
	
	private double round(Double toround){
	    double roundOff = (Math.round(toround*100.00))/100.00;
	    return roundOff;
	}
	/*private double totImportDuty(ShoppingBasket shoppingBasket){
		double totDuty=0.0;
		
		for(int i=0; i<shoppingBasket.getItemPurchased().size(); i++){
			totDuty=totDuty+importDutyForItem(shoppingBasket.getItemPurchased().get(i));
		}
		return totDuty;
	}
	
	public double totTaxes(ShoppingBasket shoppingBasket){
		double totTaxes=0.0;
		for(int i=0; i<shoppingBasket.getItemPurchased().size(); i++){
			totTaxes=totTaxes+gettaxesForItem(shoppingBasket.getItemPurchased().get(i));
			totTaxes=totTaxes+importDutyForItem(shoppingBasket.getItemPurchased().get(i));
		}
		//totTaxes=totTaxes+totImportDuty(shoppingBasket);
		return totTaxes;
	}
	
	public double totBasket(ShoppingBasket shoppingBasket){
		double totBasket=0.0;
		for(int i=0; i<shoppingBasket.getItemPurchased().size(); i++){
			totBasket=totBasket+shoppingBasket.getItemPurchased().get(i).getPrice();
			totBasket=totBasket+getTotTaxForItem(shoppingBasket.getItemPurchased().get(i));
		}
		
		return totBasket;
		
	}
	*/
	//TODO
	//manca l'arrotondamento delle duty fatto per singolo item e la gestioen delle qty
	
	
	/*
	 * 
	 * //Questi vanno spostati sotto item o sotto calculator
		private double importDutyForItem(ItemPurchased itemP){
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
			return gettaxesForItem(itemP)+importDutyForItem(itemP);
		}
		
		
		public Double getItemTotPrice(ItemPurchased itemP){
			logger.debug(itemP.getQty()+" "+itemP.getItemName()+" "+getTotTaxForItem(itemP));
			return itemP.getPrice()+getTotTaxForItem(itemP);
		}
	
	 * */
	
	
	
}
