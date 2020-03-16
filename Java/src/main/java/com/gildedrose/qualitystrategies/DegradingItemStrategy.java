/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public class DegradingItemStrategy extends ItemStrategy {
	
	private static final int MIN_QUALITY = 0;

	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		item.quality = Integer.max(MIN_QUALITY, item.quality - qualityOffset);

	}
	
	@Override
	public int determineQualityOffset(Item item) {
		int qualityOffset = 1;
		if(item.sellIn <= 0) {
			qualityOffset *=2;
		}
		return qualityOffset;
		
	}
	
}
