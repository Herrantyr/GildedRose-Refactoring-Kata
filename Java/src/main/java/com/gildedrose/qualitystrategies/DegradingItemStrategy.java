/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;
import com.gildedrose.inventory.GildedRoseInventoryItems;

/**
 * @author bart.vanderplancken
 *
 */
public abstract class DegradingItemStrategy extends ItemStrategy {
	
	private static final int MIN_QUALITY = 0;

	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		degradeItemQuality(item, qualityOffset);

	}
	
	@Override
	public int determineQualityOffset(Item item) {
		return determineDegradingQualityOffset(item);
		
	}
	
	/**
	 * @param item
	 * @return
	 */
	private int determineDegradingQualityOffset(Item item) {
		int qualityOffset = 1;
		if(item.sellIn <= 0) {
			qualityOffset *=2;
		}
		if(isConjuredItem(item.name)) {
			qualityOffset *= 2;
		}
		return qualityOffset;
	}
	
	
	/**
	 * @param name
	 * @return
	 */
	private boolean isConjuredItem(String name) {
		return name.equals(GildedRoseInventoryItems.CONJURED_MANA_CAKE);
	}
	
	/**
	 * @param item
	 * @param qualityOffset
	 */
	private void degradeItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.max(MIN_QUALITY, item.quality - qualityOffset);
	}

}
