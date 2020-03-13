package com.gildedrose;

import com.gildedrose.inventory.GildedRoseInventoryItems;
import com.gildedrose.qualitystrategies.DegradingItemStrategy;
import com.gildedrose.qualitystrategies.EnhancingItemStrategy;
import com.gildedrose.qualitystrategies.ItemStrategy;
import com.gildedrose.qualitystrategies.LegendaryItemStrategy;

class GildedRose {
	
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			
			ItemStrategy itemStrategy = getItemStrategy(item.name);
			itemStrategy.updateItemQuality(item);
			itemStrategy.updateSellInValue(item);
		}
    }

	private ItemStrategy getItemStrategy(String itemName) {
		if(isEnhancingItem(itemName)) {
			return new EnhancingItemStrategy() {
			};
		} else if (isLegendaryItem(itemName)) {
			return new LegendaryItemStrategy();
		} else {
			return new DegradingItemStrategy() {
			};
		}
	}

	/**
	 * @param name
	 * @return
	 */
	private boolean isLegendaryItem(String name) {
		return name.equals(GildedRoseInventoryItems.SULFURAS_HAND_OF_RAGNAROS);
	}

	/**
	 * @param name
	 * @return
	 */
	private boolean isEnhancingItem(String name) {
		return name.equals(GildedRoseInventoryItems.AGED_BRIE) || name.equals(GildedRoseInventoryItems.BACKSTAGE_PASSES);
	}
	
}