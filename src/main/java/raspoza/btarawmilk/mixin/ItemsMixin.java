package raspoza.btarawmilk.mixin;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemBucketIceCream;
import net.minecraft.core.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.core.item.Items.BUCKET;

@Mixin(value = Items.class, remap = false)
public class ItemsMixin {
	@Inject(method = "setupItems", at = @At("TAIL"))
	private static void replaceMilkBucket(CallbackInfo ci) {
		Item.itemsList[Items.BUCKET_MILK.id] = null;
		Item.itemsMap.remove(Items.BUCKET_MILK.namespaceID);
		Items.BUCKET_MILK = new ItemBucketIceCream("rawMilkBucket", Items.BUCKET_MILK.namespaceID.toString(), Items.BUCKET_MILK.id, 0, 0).setContainerItem(BUCKET);
	}
}
