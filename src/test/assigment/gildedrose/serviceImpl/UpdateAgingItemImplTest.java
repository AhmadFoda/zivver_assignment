package gildedrose.serviceImpl;

import com.gildedrose.model.Item;
import com.gildedrose.serviceimpl.UpdateAgingItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateAgingItemImplTest {

    @Test
    public void UpdateAgingItemTest(){
        Item item = new Item("Aged Brie",14,12);
        UpdateAgingItemImpl updateAgingItem =
                new UpdateAgingItemImpl();
        updateAgingItem.updateQuality(item);
        updateAgingItem.updateSellInValue(item);
        Assertions.assertEquals(13,item.sellIn);
        Assertions.assertEquals(13,item.quality);

    }
}
