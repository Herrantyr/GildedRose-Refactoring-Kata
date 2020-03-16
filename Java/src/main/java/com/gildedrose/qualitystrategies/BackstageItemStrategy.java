/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public class BackstageItemStrategy extends EnhancingItemStrategy {

	@Override
	public int determineQualityOffset(Item item) {
		int qualityOffset = 1;
		if (isExpiredSale(item.sellIn)) {
			qualityOffset = -item.quality;
		} else if (isUrgentSale(item.sellIn)) {
			qualityOffset += 2;
		} else if (isExpiringSale(item.sellIn)) {
			qualityOffset += 1;
		}
		return qualityOffset;
	}
	
	/**
	 * Check if the item is urgent to sell
	 * @param sellIn
	 * @return
	 */
	private boolean isUrgentSale(int sellIn) {
		return sellIn < 6;
	}

	/**
	 * Check if the item is starting to expire
	 * @param sellIn
	 * @return
	 */
	private boolean isExpiringSale(int sellIn) {
		return sellIn < 11;
	}
}
