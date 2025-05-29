package raspoza.btarawmilk;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBucketIceCream;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ItemInitEntrypoint;

import static net.minecraft.core.item.Items.BUCKET;
import static raspoza.btarawmilk.Main.MOD_ID;

public class MilkItems implements ItemInitEntrypoint {
	public static Item freshMilkBucket;

	@Override
	public void afterItemInit() {
		freshMilkBucket = new ItemBuilder(MOD_ID).build(new ItemBucketIceCream("freshMilkBucket","minecraft:item/bucket_milk_fresh",Main.config.getInt("ids.freshMilkBucket"), 10, 24)).setContainerItem(BUCKET);

	}
}
