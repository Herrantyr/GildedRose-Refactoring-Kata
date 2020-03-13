/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public abstract class EnhancingItemStrategy extends ItemStrategy{
	
	private static final int MAX_QUALITY = 50;
	
	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.min(item.quality + qualityOffset, MAX_QUALITY);
	}
	
	@Override
	public int determineQualityOffset(Item item) {
		int qualityOffset = 1;
		if (isExpiredSale(item.sellIn)) {
			qualityOffset *= 2;
		}
		return qualityOffset;
	}
	
	/**
	 * Check if item is expired with the sellIn date
	 * @param sellIn
	 * @return
	 */
	protected boolean isExpiredSale(int sellIn) {
		return sellIn <= 0;
	}

}
