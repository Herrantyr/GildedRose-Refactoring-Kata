/**
 * 
 */
package com.gildedrose.qualityHandlers;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public class DegradingItemQualityHandler extends ItemQualityHandler {
	
	private static final int MIN_QUALITY = 0;

	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		degradeItemQuality(item, qualityOffset);

	}
	
	/**
	 * @param item
	 * @param qualityOffset
	 */
	private void degradeItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.max(MIN_QUALITY, item.quality - qualityOffset);
	}

}
