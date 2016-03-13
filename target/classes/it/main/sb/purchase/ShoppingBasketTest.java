package it.main.sb.purchase;

import static org.junit.Assert.*;
import it.main.sb.beans.ItemPurchased;

import org.junit.*;

public class ShoppingBasketTest {

	@Test
	public void testAddToBasket() {
		ShoppingBasket shoppingBasket1= new ShoppingBasket();
		ItemPurchased item1= new ItemPurchased();
		item1.setItemName("book");
		item1.setPrice(10.0);
		item1.setQty(1);
		item1.setFlagExempt(true);
		item1.setFlagImport(false);
		
		shoppingBasket1.addToBasket(item1);
		
	}
		

	@Test
	public void testGetItemPurchased() {
		
	}

	@Test
	public void testGetTotTaxForItem() {
		
	}

	@Test
	public void testGetItemTotPrice() {
		
	}

}
