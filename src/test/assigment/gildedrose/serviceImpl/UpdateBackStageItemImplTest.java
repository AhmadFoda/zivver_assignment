package gildedrose.serviceImpl;

import com.gildedrose.model.Item;
import com.gildedrose.serviceimpl.UpdateBackStageItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateBackStageItemImplTest {

    // test quality change when sell in <10
    // when sell-in below 10 quality should increase by 2
    @Test
    public void UpdateBackStageItemTest(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",
                7,12);
        UpdateBackStageItemImpl updateBackStageItemImpl =
                new UpdateBackStageItemImpl();
        updateBackStageItemImpl.updateQuality(item);
        updateBackStageItemImpl.updateSellInValue(item);
        Assertions.assertEquals(6,item.sellIn);
        Assertions.assertEquals(14,item.quality);

    }
    // test quality change when sell in <5
    // when sell-in below 5 quality should increase by 3
    @Test
    public void UpdateBackStageItem_BelowFive(){
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert",
                4,12);
        UpdateBackStageItemImpl updateBackStageItemImpl =
                new UpdateBackStageItemImpl();
        updateBackStageItemImpl.updateQuality(item);
        updateBackStageItemImpl.updateSellInValue(item);
        Assertions.assertEquals(3,item.sellIn);
        Assertions.assertEquals(15,item.quality);

    }
}
