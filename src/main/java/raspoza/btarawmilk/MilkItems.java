package raspoza.btarawmilk;

import net.minecraft.core.item.ItemFood;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.ItemInitEntrypoint;

import static raspoza.btarawmilk.Main.MOD_ID;

public class MilkItems implements ItemInitEntrypoint {
	public static ItemFood freshMilkBucket;
	public static ItemFood rawMilkBucket;
	@Override
	public void afterItemInit() {
		freshMilkBucket = new ItemBuilder(MOD_ID).build(new ItemFood("freshMilkBucket",MOD_ID + ":item/fresh_milk_bucket",25062, 10, 24, false, 1));
		rawMilkBucket = new ItemBuilder(MOD_ID).build(new ItemFood("rawMilkBucket", MOD_ID + ":item/raw_milk_bucket", 25063, 1, 0, false, 1));

	}
}
