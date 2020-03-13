package com.gildedrose;

import com.gildedrose.inventory.GildedRoseInventoryItems;
import com.gildedrose.qualityHandlers.DegradingItemQualityHandler;
import com.gildedrose.qualityHandlers.EnhancingItemQualityHandler;
import com.gildedrose.qualityHandlers.ItemQualityHandler;

class GildedRose {
	
	Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			Item item = items[i];
			if(isLegendaryItem(item.name)) {
				continue;
			}
			// update quality
			int qualityOffset = 0;
			if (isEnhancingItem(item.name)) {
				qualityOffset = determineEnhancingQualityOffset(item);
			} else {
				qualityOffset = determineDegradingQualityOffset(item);
			}
			
			// update sell in value
			ItemQualityHandler itemQualityHandler = getItemQualityHandler(item.name);
			itemQualityHandler.updateItemQuality(item, qualityOffset);
			itemQualityHandler.updateSellInValue(item);
		}
    }

	private ItemQualityHandler getItemQualityHandler(String itemName) {
		if(isEnhancingItem(itemName)) {
			return new EnhancingItemQualityHandler() {
			};
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
	
	/**
	 * @param name
	 * @return
	 */
	private boolean isConjuredItem(String name) {
		return name.equals(GildedRoseInventoryItems.CONJURED_MANA_CAKE);
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
	 * @param item
	 * @return
	 */
	private int determineDegradingQualityOffset(Item item) {
		int qualityOffset = 1;
		if(item.sellIn <= 0) {
			qualityOffset *=2;
		}
		if(isConjuredItem(item.name)) {
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
}