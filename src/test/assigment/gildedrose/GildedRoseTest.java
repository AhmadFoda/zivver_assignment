package gildedrose;

import com.gildedrose.GildedRose;
import com.gildedrose.model.Item;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class GildedRoseTest {


    // this was the initial test function on the repo I just replaced for loop with asserts
    @Test
    public void updateQualityTest(){
        Item[] items = new Item[]{
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Elixir of the Mongoose", 5, 7), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Sulfuras, Hand of Ragnaros", -1, 80),
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                new Item("Conjured Mana Cake", 3, 6)};

        GildedRose app = new GildedRose(items);

        app.updateQuality();
        Assert.assertEquals(items[0].toString(),"+5 Dexterity Vest, 9, 19");
        Assert.assertEquals(items[1].toString(),"Aged Brie, 1, 1");
        Assert.assertEquals(items[2].toString(),"Elixir of the Mongoose, 4, 6");
        Assert.assertEquals(items[3].toString(),"Sulfuras, Hand of Ragnaros, 0, 80");
        Assert.assertEquals(items[4].toString(),"Sulfuras, Hand of Ragnaros, -1, 80");
        Assert.assertEquals(items[5].toString(),"Backstage passes to a TAFKAL80ETC concert, 14, 21");
        Assert.assertEquals(items[6].toString(),"Backstage passes to a TAFKAL80ETC concert, 9, 50");
        Assert.assertEquals(items[7].toString(),"Backstage passes to a TAFKAL80ETC concert, 4, 50");
        Assert.assertEquals(items[8].toString(),"Conjured Mana Cake, 2, 4");

    }

}