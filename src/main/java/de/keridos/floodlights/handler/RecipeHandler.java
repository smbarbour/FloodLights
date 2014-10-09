package de.keridos.floodlights.handler;

import cpw.mods.fml.common.registry.GameData;
import cpw.mods.fml.common.registry.GameRegistry;
import de.keridos.floodlights.init.ModBlocks;
import de.keridos.floodlights.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Keridos on 28.02.14.
 * This Class adds all Recipes for this mod.
 */
public class RecipeHandler {
    private static RecipeHandler instance = null;
    private ConfigHandler configHandler = ConfigHandler.getInstance();

    private RecipeHandler() {
    }

    public static RecipeHandler getInstance() {
        if (instance == null) {
            instance = new RecipeHandler();
        }
        return instance;
    }

    public Item getMinecraftItem(String name) {
        Item item;
        item = GameData.getItemRegistry().getRaw("minecraft:" + name);
        return item;
    }

    public void initRecipes() {
        if (configHandler.electricFloodlight) {
            GameRegistry.addRecipe(new ItemStack(ModItems.rawFilament, 1), " L ", "RGR", " L ", 'R', new ItemStack(getMinecraftItem("redstone"), 1), 'G', new ItemStack(getMinecraftItem("gold_ingot"), 1), 'L', new ItemStack(getMinecraftItem("glowstone_dust"), 1));
            GameRegistry.addRecipe(new ItemStack(ModItems.carbonDissolver, 1), "GRG", "IGI", 'R', new ItemStack(getMinecraftItem("redstone"), 1), 'G', new ItemStack(getMinecraftItem("glass_pane"), 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1));
            GameRegistry.addRecipe(new ItemStack(ModItems.mantle, 1), "SSS", "SRS", "SSS", 'R', new ItemStack(getMinecraftItem("redstone"), 1), 'S', new ItemStack(getMinecraftItem("string"), 1));
            GameRegistry.addRecipe(new ItemStack(ModItems.carbonLantern, 1), " G ", "GMG", "DFI", 'G', new ItemStack(getMinecraftItem("glass_pane"), 1), 'M', new ItemStack(ModItems.mantle, 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1), 'D', new ItemStack(ModItems.carbonDissolver, 1), 'F', new ItemStack(getMinecraftItem("flint_and_steel"), 1));
            FurnaceRecipes.smelting().func_151394_a(new ItemStack(ModItems.rawFilament, 1), new ItemStack(ModItems.glowingFilament, 1), 0.1F);
            GameRegistry.addRecipe(new ItemStack(ModItems.lightBulb, 1), " G ", "GFG", " I ", 'G', new ItemStack(getMinecraftItem("glass_pane"), 1), 'F', new ItemStack(ModItems.glowingFilament, 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockElectricLight, 1), "CIC", "IBG", "CIC", 'C', new ItemStack(getMinecraftItem("cobblestone"), 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1), 'B', new ItemStack(ModItems.lightBulb, 1), 'G', new ItemStack(getMinecraftItem("glass"), 1)));
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.blockCarbonLight, 1), "CIC", "IBG", "CIC", 'C', new ItemStack(getMinecraftItem("cobblestone"), 1), 'I', new ItemStack(getMinecraftItem("iron_ingot"), 1), 'B', new ItemStack(ModItems.carbonLantern, 1), 'G', new ItemStack(getMinecraftItem("glass"), 1)));
        }
    }
}