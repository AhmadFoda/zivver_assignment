package com.gildedrose.serviceimpl;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;

public class UpdateConjuredItemImpl implements UpdateItemService {
    @Override
    public void updateQuality(Item item) {
        if (item.quality>=2) item.quality -= 2;

    }

    @Override
    public void updateSellInValue(Item item) {
      item.sellIn -= 1;
    }
}
