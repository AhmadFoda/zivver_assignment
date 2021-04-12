package com.gildedrose.util;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;
import com.gildedrose.serviceimpl.*;

public class UpdateItemFactory {

    public static UpdateItemService getUpdateItem(Item item){

        switch(item.name){
            case "Aged Brie" :
                return new UpdateAgingItemImpl();
            case "Backstage passes to a TAFKAL80ETC concert" :
                return new UpdateBackStageItemImpl();
            case "Sulfuras, Hand of Ragnaros" :
                return new UpdateLegendaryItemImpl();
            case "Conjured Mana Cake" :
                return new UpdateConjuredItemImpl();
        }
        return new UpdateItemImpl();
    }
}
