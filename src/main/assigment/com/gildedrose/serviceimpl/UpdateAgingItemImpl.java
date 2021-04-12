package com.gildedrose.serviceimpl;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;

public class UpdateAgingItemImpl implements UpdateItemService {

    @Override
    public void updateQuality(Item item) {
      if (item.quality<50) item.quality += 1;
    }

    @Override
    public void updateSellInValue(Item item) {
        item.sellIn -=  1;
    }
}
