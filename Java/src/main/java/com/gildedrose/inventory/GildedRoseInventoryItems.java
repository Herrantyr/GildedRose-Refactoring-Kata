/**
 * 
 */
package com.gildedrose.inventory;

import com.gildedrose.qualitystrategies.BackstageItemStrategy;
import com.gildedrose.qualitystrategies.ConjuredItemStrategy;
import com.gildedrose.qualitystrategies.DefaultDegradingItemStrategy;
import com.gildedrose.qualitystrategies.DefaultEnhancingItemStrategy;
import com.gildedrose.qualitystrategies.ItemStrategy;
import com.gildedrose.qualitystrategies.LegendaryItemStrategy;

/**
 * @author bart.vanderplancken
 *
 */
public class GildedRoseInventoryItems {

	public static final String AGED_BRIE = "Aged Brie";
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";
	public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
	public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
	
	private static ItemStrategy backstageItemStrategy = new BackstageItemStrategy();
	private static ItemStrategy defaultEnhancingStrategy = new DefaultEnhancingItemStrategy();
	private static ItemStrategy legendaryItemStrategy = new LegendaryItemStrategy();
	private static ItemStrategy conjuredItemStrategy = new ConjuredItemStrategy();
	private static ItemStrategy defaultDegradingStrategy = new DefaultDegradingItemStrategy();
	
	private GildedRoseInventoryItems() {
		// do nothing
	}
	
	/**
	 * find the item strategy belonging to the name of the item
	 * @param itemName
	 * @return
	 */
	public static ItemStrategy getItemStrategy(String itemName) {
		switch (itemName) {
		case BACKSTAGE_PASSES:
			return backstageItemStrategy;
		case AGED_BRIE:
			return defaultEnhancingStrategy;
		case SULFURAS_HAND_OF_RAGNAROS:
			return legendaryItemStrategy;
		case CONJURED_MANA_CAKE:
			return conjuredItemStrategy;
		default:
			return defaultDegradingStrategy;
		}
	}
	
}
