package raspoza.btarawmilk;

import turniplabs.halplibe.helper.RecipeBuilder;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.Blocks;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.Items;
import net.minecraft.core.util.helper.DyeColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.helper.recipeBuilders.RecipeBuilderShaped;
import turniplabs.halplibe.util.RecipeEntrypoint;
import static raspoza.btarawmilk.Main.MOD_ID;
import raspoza.btarawmilk.Main;

public class MilkRecipes implements ModInitializer, RecipeEntrypoint {
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("BTA Pasteurization initialized.");
	}

	@Override
	public void initNamespaces() {
		// Initializes each workstation for our modid
		RecipeBuilder.initNameSpace(MOD_ID);
		// Initializes our custom itemgroup "example:exampleGroup1"
		RecipeBuilder.getItemGroup("example", "exampleGroup1");
	}

	@Override
	public void onRecipesReady() {

		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("cake");
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("mushroom_stew");
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("pumpkin_pie");
		RecipeBuilder.ModifyWorkbench("minecraft").removeRecipe("ice_cream_bucket");

		RecipeBuilder.BlastFurnace(MOD_ID)
			.setInput(Items.BUCKET_MILK)
			.create("bucket_milk_fresh", MilkItems.freshMilkBucket.getDefaultStack());

		RecipeBuilder.Shapeless(MOD_ID)
			.addInput(MilkItems.freshMilkBucket)
			.addInput(Blocks.MUSHROOM_BROWN)
			.addInput(Blocks.MUSHROOM_RED)
			.addInput(Items.BOWL)
			.create("mushroom_stew", Items.FOOD_STEW_MUSHROOM.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("FFF", "SES", "WWW")
			.addInput('F', MilkItems.freshMilkBucket)
			.addInput('S', Items.DUST_SUGAR)
			.addInput('E', Items.EGG_CHICKEN)
			.addInput('W', Items.WHEAT)
			.create("cake", Items.FOOD_CAKE.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape("FFF", "SPS", "WWW")
			.addInput('F', MilkItems.freshMilkBucket)
			.addInput('S', Items.DUST_SUGAR)
			.addInput('P', Blocks.PUMPKIN)
			.addInput('W', Items.WHEAT)
			.create("pumpkin_pie", Items.FOOD_PUMPKIN_PIE.getDefaultStack());

		RecipeBuilder.Shaped(MOD_ID)
			.setShape(" C ", "SBS", " F ")
			.addInput('C', Items.FOOD_CHERRY)
			.addInput('S', Items.AMMO_SNOWBALL)
			.addInput('B', Items.DYE, 3)
			.addInput('F', MilkItems.freshMilkBucket)
			.create("ice_cream_bucket", Items.BUCKET_ICECREAM.getDefaultStack());
	}
}
