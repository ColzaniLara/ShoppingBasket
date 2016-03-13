package test.sb.tester;

import main.sb.purchase.Calculator;

import org.json.JSONArray;
import org.junit.*;

public class ShoppingBasketTest {
	
	
	@Test
	public void testINPUT1() {
		
		String stringJSON="[" +
				"{\"ItemName\":\"book\", \"Price\":12.49, \"FlagExempt\":true, \"FlagImport\":false}," +
				"{\"ItemName\":\"music CD\", \"Price\":14.99, \"FlagExempt\":false, \"FlagImport\":false}," +
				"{\"ItemName\":\"chocolate bar\", \"Price\":0.85, \"FlagExempt\":true, \"FlagImport\":false}" +
				"]";
				
		JSONArray jsonarray = new JSONArray(stringJSON);
		
		//JSONObject inputParams=new JSONObject(stringJSON);
		Calculator.calculateReceipt(jsonarray);
		
		/*logger.info("INPUT");
		logger.info("Input 1:");
		ItemPurchased item1= new ItemPurchased();
		item1.setQty(1);
		item1.setItemName("book");
		//item1.setFlagImport(false);
		item1.setPrice(12.49);
		item1.setFlagExempt(true);
		shoppingBasket1.addToBasket(item1);
			
		logger.info("Input 2:");
		ItemPurchased item2 =  new ItemPurchased();
		item2.setQty(1);
		item2.setItemName("music CD");
		item2.setPrice(14.99);
		item2.setFlagExempt(false);
		shoppingBasket1.addToBasket(item2);
		
		logger.info("Input 3:");
		ItemPurchased item3 =  new ItemPurchased();
		item3.setQty(1);
		item3.setItemName("chocolate bar");
		item3.setPrice(0.85);
		item3.setFlagExempt(true);
		shoppingBasket1.addToBasket(item3);
		*/
		/*logger.debug("item1.gettaxesForItem()"+item1.gettaxesForItem());
		logger.debug("item1.getTotTaxForItem()"+item1.getTotTaxForItem());
		logger.debug("item1.getItemTotPrice();"+item1.getItemTotPrice());
		
		logger.debug("item2.gettaxesForItem()"+item2.gettaxesForItem());
		logger.debug("item2.getTotTaxForItem()"+item2.getTotTaxForItem());
		logger.debug("item2.getItemTotPrice();"+item2.getItemTotPrice());
		
		logger.debug("item3.gettaxesForItem()"+item3.gettaxesForItem());
		logger.debug("item3.getTotTaxForItem()"+item3.getTotTaxForItem());
		logger.debug("item3.getItemTotPrice();"+item3.getItemTotPrice());
		*/
		//logger.debug("shoppingBasket1.totBasket()"+shoppingBasket1.totBasket());
		//logger.debug("shoppingBasket1.totTaxes()"+shoppingBasket1.totTaxes());
		
		//Calculator.calculateReceipt(shoppingBasket1);
		
		//Carrello2
	/*	ItemPurchased item4 =  new ItemPurchased();
		item4.setQty(1);
		item4.setItemName("box of chocolates");
		item4.setPrice(10.0);
		item4.setFlagImport(true);
		item4.setFlagExempt(true);
		shoppingBasket2.addToBasket(item4);
		
		ItemPurchased item5 =  new ItemPurchased();
		item5.setQty(1);
		item5.setItemName("bottle of perfume");
		item5.setPrice(47.50);
		item5.setFlagImport(true);
		item5.setFlagExempt(false);
		shoppingBasket2.addToBasket(item5);
		*/
		//Calculator.calculateReceipt(shoppingBasket2);
		/*
		logger.debug("item4.gettaxesForItem()"+item4.gettaxesForItem());
		logger.debug("item4.getTotTaxForItem()"+item4.getTotTaxForItem());
		logger.debug("item4.getItemTotPrice();"+item4.getItemTotPrice());
		
		logger.debug("item5.gettaxesForItem()"+item5.gettaxesForItem());
		logger.debug("item5.getTotTaxForItem()"+item5.getTotTaxForItem());
		logger.debug("item5.getItemTotPrice();"+item5.getItemTotPrice());
		*/
	
	}
	
	@Test
	public void testINPUT2() {
		
		String stringJSON="[" +
				"{\"ItemName\":\"box of chocolates\", \"Price\":10.00, \"FlagExempt\":true, \"FlagImport\":true}," +
				"{\"ItemName\":\"bottle of perfume\", \"Price\":47.50, \"FlagExempt\":false, \"FlagImport\":true}" +
				"]";
				
		JSONArray jsonarray = new JSONArray(stringJSON);
		
		//JSONObject inputParams=new JSONObject(stringJSON);
		Calculator.calculateReceipt(jsonarray);
	}
	
	@Test
	public void testINPUT3() {
		
		String stringJSON="[" +
				"{\"ItemName\":\"bottle of perfume\", \"Price\":27.99, \"FlagExempt\":false, \"FlagImport\":true}," +
				"{\"ItemName\":\"bottle of perfume\", \"Price\":18.99, \"FlagExempt\":false, \"FlagImport\":false}," +
				"{\"ItemName\":\"headache pills\", \"Price\":9.75, \"FlagExempt\":true, \"FlagImport\":false}," +
				"{\"ItemName\":\"box of imported chocolates\", \"Price\":11.25, \"FlagExempt\":true, \"FlagImport\":true}" +
				"]";
				
		JSONArray jsonarray = new JSONArray(stringJSON);
		
		//JSONObject inputParams=new JSONObject(stringJSON);
		Calculator.calculateReceipt(jsonarray);
	}
	
	
/*
	@Test
	public void testGetItemPurchased() {
		
	}

	@Test
	public void testGetTotTaxForItem() {
		
	}

	@Test
	public void testGetItemTotPrice() {
		
	}
*/
}
