package com.gildedrose.serviceimpl;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;

public class UpdateLegendaryItemImpl implements UpdateItemService {
    @Override
    public void updateQuality(Item item) {
        // do nothing
    }

    @Override
    public void updateSellInValue(Item item) {
     //   item.sellIn -=1 ;
    }
}
