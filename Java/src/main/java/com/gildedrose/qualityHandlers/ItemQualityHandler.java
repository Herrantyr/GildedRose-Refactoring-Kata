/**
 * 
 */
package com.gildedrose.qualityHandlers;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public abstract class ItemQualityHandler {
	
	/**
	 * @param item
	 */
	public void updateSellInValue(Item item) {
		item.sellIn -= 1;
	}
	
	public abstract void updateItemQuality(Item item, int qualityOffset);

}
