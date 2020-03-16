/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public abstract class ItemStrategy {
	
	/**
	 * Update all aspects of an item according to the chosen strategy
	 * @param item
	 */
	public void updateItem(Item item) {
		updateItemQuality(item);
		updateSellInValue(item);
	}
	
	/**
	 * Update the quality of the item, determined by the chosen strategy
	 * @param item
	 */
	public void updateItemQuality(Item item) {
		int qualityOffset = determineQualityOffset(item);
		updateItemQuality(item, qualityOffset);
	}
	
	/**
	 * Update the sell in value of an item
	 * @param item
	 */
	public void updateSellInValue(Item item) {
		item.sellIn -= 1;
	}
	
	/**
	 * Update the quality of a given item with a determined offset
	 * @param item
	 * @param qualityOffset
	 */
	public abstract void updateItemQuality(Item item, int qualityOffset);
	
	/**
	 * Determine the offset with how much the item quality should be updated
	 * @param item
	 * @return
	 */
	public abstract int determineQualityOffset(Item item);

}
