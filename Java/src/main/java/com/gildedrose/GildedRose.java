package com.gildedrose;

import com.gildedrose.inventory.GildedRoseInventoryItems;
import com.gildedrose.qualityHandlers.DegradingItemQualityHandler;
import com.gildedrose.qualityHandlers.EnhancingItemQualityHandler;
import com.gildedrose.qualityHandlers.ItemQualityHandler;
import com.gildedrose.qualityHandlers.LegendaryItemQualityHandler;

class GildedRose {
	
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			
			ItemQualityHandler itemQualityHandler = getItemQualityHandler(item.name);
			int qualityOffset = itemQualityHandler.determineQualityOffset(item);
			itemQualityHandler.updateItemQuality(item, qualityOffset);
			itemQualityHandler.updateSellInValue(item);
		}
    }

	private ItemQualityHandler getItemQualityHandler(String itemName) {
		if(isEnhancingItem(itemName)) {
			return new EnhancingItemQualityHandler() {
			};
		} else if (isLegendaryItem(itemName)) {
			return new LegendaryItemQualityHandler();
		} else {
			return new DegradingItemQualityHandler() {
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