package gildedrose.serviceImpl;

import com.gildedrose.model.Item;
import com.gildedrose.serviceimpl.UpdateConjuredItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateConjuredItemImplTest {
    @Test
    public void updateConjuredItemTest(){
        Item item = new Item("Conjured Mana Cake",
                10,14);
        UpdateConjuredItemImpl updateConjuredItemImpl =
                new UpdateConjuredItemImpl();
        updateConjuredItemImpl.updateQuality(item);
        updateConjuredItemImpl.updateSellInValue(item);
        Assertions.assertEquals(9,item.sellIn);
        Assertions.assertEquals(12,item.quality);

    }
}
