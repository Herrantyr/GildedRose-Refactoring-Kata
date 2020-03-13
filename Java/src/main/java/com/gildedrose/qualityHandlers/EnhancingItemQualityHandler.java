/**
 * 
 */
package com.gildedrose.qualityHandlers;

import com.gildedrose.Item;

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
	
	/**
	 * @param item
	 * @param qualityOffset
	 */
	private void enhanceItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.min(item.quality + qualityOffset, MAX_QUALITY);
	}

}
