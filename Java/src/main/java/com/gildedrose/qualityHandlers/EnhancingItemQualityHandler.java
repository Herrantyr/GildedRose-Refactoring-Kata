/**
 * 
 */
package com.gildedrose.qualityHandlers;

import com.gildedrose.Item;
import com.gildedrose.inventory.GildedRoseInventoryItems;

/**
 * @author bart.vanderplancken
 *
 */
public abstract class EnhancingItemQualityHandler extends ItemQualityHandler{
	
	private static final int MAX_QUALITY = 50;
	
	/**
	 *
	 */
	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		enhanceItemQuality(item, qualityOffset);
	}
	
	@Override
	public int determineQualityOffset(Item item) {
		return determineEnhancingQualityOffset(item);
	}
	
	/**
	 * @param item
	 * @return
	 */
	private int determineEnhancingQualityOffset(Item item) {
		int qualityOffset = 1;
		if (item.name.equals(GildedRoseInventoryItems.BACKSTAGE_PASSES)) {
			if (isExpiredSale(item.sellIn)) {
				qualityOffset = -item.quality;
			} else if (isUrgentSale(item.sellIn)) {
				qualityOffset += 2;
			} else if (isExperingSale(item.sellIn)) {
				qualityOffset += 1;
			}
		} else if (isExpiredSale(item.sellIn)) {
			qualityOffset *= 2;
		}
		return qualityOffset;
	}
	
	/**
	 * @param sellIn
	 * @return
	 */
	private boolean isExpiredSale(int sellIn) {
		return sellIn <= 0;
	}

	/**
	 * @param sellIn
	 * @return
	 */
	private boolean isUrgentSale(int sellIn) {
		return sellIn < 6;
	}

	/**
	 * @param sellIn
	 * @return
	 */
	private boolean isExperingSale(int sellIn) {
		return sellIn < 11;
	}
	
	/**
	 * @param item
	 * @param qualityOffset
	 */
	private void enhanceItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.min(item.quality + qualityOffset, MAX_QUALITY);
	}

}
