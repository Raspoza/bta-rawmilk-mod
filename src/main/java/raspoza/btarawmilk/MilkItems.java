package raspoza.btarawmilk;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBucketIceCream;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ItemInitEntrypoint;

import static net.minecraft.core.item.Items.BUCKET;
import static raspoza.btarawmilk.Main.MOD_ID;

public class MilkItems implements ItemInitEntrypoint {
	public static Item freshMilkBucket;
	public static Item rawMilkBucket;
	@Override
	public void afterItemInit() {
		freshMilkBucket = new ItemBuilder(MOD_ID).build(new ItemBucketIceCream("freshMilkBucket","minecraft:item/fresh_milk_bucket",25062, 10, 24)).setContainerItem(BUCKET);

	}
}
