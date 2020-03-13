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
	 * @param item
	 */
	public void updateSellInValue(Item item) {
		item.sellIn -= 1;
	}
	
	public void updateItemQuality(Item item) {
		int qualityOffset = determineQualityOffset(item);
		updateItemQuality(item, qualityOffset);
	}
	
	public abstract void updateItemQuality(Item item, int qualityOffset);
	
	public abstract int determineQualityOffset(Item item);

}
