package gildedrose.util;

import com.gildedrose.model.Item;
import com.gildedrose.service.UpdateItemService;
import com.gildedrose.serviceimpl.UpdateAgingItemImpl;
import com.gildedrose.serviceimpl.UpdateBackStageItemImpl;
import com.gildedrose.serviceimpl.UpdateConjuredItemImpl;
import com.gildedrose.serviceimpl.UpdateLegendaryItemImpl;
import com.gildedrose.util.UpdateItemFactory;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

public class UpdateItemFactoryTest {

    @Test
    public void UpdateItemFactoryTest(){
        Item item = new Item("Aged Brie",12,12);

        UpdateItemService updateItemService = UpdateItemFactory.getUpdateItem(item);
        MatcherAssert.assertThat(updateItemService,instanceOf(UpdateAgingItemImpl.class));

        item.name = "Backstage passes to a TAFKAL80ETC concert" ;
        updateItemService = UpdateItemFactory.getUpdateItem(item);
        MatcherAssert.assertThat(updateItemService,instanceOf(UpdateBackStageItemImpl.class));

        item.name = "Sulfuras, Hand of Ragnaros" ;
        updateItemService = UpdateItemFactory.getUpdateItem(item);
        MatcherAssert.assertThat(updateItemService,instanceOf(UpdateLegendaryItemImpl.class));

        item.name = "Conjured Mana Cake" ;
        updateItemService = UpdateItemFactory.getUpdateItem(item);
        MatcherAssert.assertThat(updateItemService,instanceOf(UpdateConjuredItemImpl.class));

    }
}
