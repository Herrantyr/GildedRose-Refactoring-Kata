/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public class LegendaryItemStrategy implements ItemStrategy {
	
	@Override
	public void updateSellInValue(Item item) {
		// do nothing - sell in value is not updated
	}

	@Override
	public void updateItemQuality(Item item, int qualityOffset) {
		// do nothing - item quality is not updated

	}

	@Override
	public int determineQualityOffset(Item item) {
		// no offset - item quality is not updated
		return 0;
	}

}
