package com.gildedrose.serviceimpl;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;

public class UpdateBackStageItemImpl implements UpdateItemService {
    @Override
    public void updateQuality(Item item) {
        if (item.sellIn <= 5 && item.quality < 47){
            item.quality +=3 ;
        } else if (item.sellIn <= 10 && item.quality < 48){
            item.quality +=2 ;
        } else if (item.quality< 50){
            item.quality+=1 ;
        }
    }

    @Override
    public void updateSellInValue(Item item) {
           item.sellIn -=1 ;
    }
}
