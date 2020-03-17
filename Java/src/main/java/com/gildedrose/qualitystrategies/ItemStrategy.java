/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public interface ItemStrategy {
	
	/**
	 * Update all aspects of an item according to the chosen strategy
	 * @param item item to update
	 */
	public default void updateItem(Item item) {
		updateItemQuality(item);
		updateSellInValue(item);
	}
	
	default void updateItemQuality(Item item) {
		int qualityOffset = determineQualityOffset(item);
		updateItemQuality(item, qualityOffset);
	}
	
	default void updateSellInValue(Item item) {
		item.sellIn -= 1;
	}
	
	abstract void updateItemQuality(Item item, int qualityOffset);
	
	abstract int determineQualityOffset(Item item);

}
