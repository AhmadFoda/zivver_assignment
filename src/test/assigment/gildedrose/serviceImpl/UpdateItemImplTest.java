package gildedrose.serviceImpl;

import com.gildedrose.model.Item;
import com.gildedrose.serviceimpl.UpdateItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateItemImplTest {

        @Test
        public void updateItemTest() {
            Item item = new Item("Normal Drink",
                    10, 10);
            UpdateItemImpl updateItemImpl =
                    new UpdateItemImpl();
            updateItemImpl.updateQuality(item);
            updateItemImpl.updateSellInValue(item);
            Assertions.assertEquals(9, item.sellIn);
            Assertions.assertEquals(9, item.quality);

        }
}
