/**
 * 
 */
package com.gildedrose.qualitystrategies;

import com.gildedrose.Item;

/**
 * @author bart.vanderplancken
 *
 */
public class ConjuredItemStrategy extends DegradingItemStrategy {
	
	@Override
	public int determineQualityOffset(Item item) {
		return super.determineQualityOffset(item) * 2;
	}

}
