package gildedrose.serviceImpl;

import com.gildedrose.model.Item;
import com.gildedrose.serviceimpl.UpdateLegendaryItemImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UpdateLegendaryItemImplTest {

        @Test
        public void updateLegendaryItemTest() {
            Item item = new Item("Sulfuras, Hand of Ragnaros",
                    10, 10);
            UpdateLegendaryItemImpl updateLegendaryItem =
                    new UpdateLegendaryItemImpl();
            updateLegendaryItem.updateQuality(item);
            updateLegendaryItem.updateSellInValue(item);
            Assertions.assertEquals(10, item.sellIn);
            Assertions.assertEquals(10, item.quality);

        }
}
