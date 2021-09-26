package io.github.k3kdev.amethystitems;

import io.github.k3kdev.amethystitems.materials.AmethystArmorMat;
import io.github.k3kdev.amethystitems.materials.AmethystToolMat;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import io.github.k3kdev.amethystitems.AmethystItems.*;

public class Register {

    //---------------------------GROUPS---------------------------
    private static final ItemGroup MAGIC_WANDS = FabricItemGroupBuilder.create(
                    new Identifier("ameitems", "magic_wands"))
            .icon(() -> new ItemStack(Items.STICK))
            .build();

    //---------------------------Magic Wands---------------------------
    public static final Item BLANK_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));
    public static final Item FIRE_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));
    public static final Item FROZEN_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));
    public static final Item WATER_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));
    public static final Item AIR_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));
    public static final Item EARTH_WAND = new Item(new Item.Settings().group(MAGIC_WANDS).maxCount(1));


    //---------------------------TOOLS---------------------------
    public static final ToolItem AMETHYST_SHOVEL = new ShovelItem(AmethystToolMat.INSTANCE, 1.5F, -3.0F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_SWORD = new SwordItem(AmethystToolMat.INSTANCE, 3, -2.4F, new Item.Settings().group(ItemGroup.COMBAT));
    public static final ToolItem AMETHYST_PICKAXE = new CustomPickaxeItem(AmethystToolMat.INSTANCE, 1, -2.8F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_AXE = new CustomAxeItem(AmethystToolMat.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));
    public static final ToolItem AMETHYST_HOE = new CustomHoeItem(AmethystToolMat.INSTANCE, 7, -3.2F, new Item.Settings().group(ItemGroup.TOOLS));


    //---------------------------ARMORS---------------------------
    public static final ArmorMaterial AmethystArmorMat = new AmethystArmorMat();
    public static final Item AMETHYST_HELMET = new ArmorItem(AmethystArmorMat, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_CHESTPLATE = new ArmorItem(AmethystArmorMat, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_LEGGINGS = new ArmorItem(AmethystArmorMat, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
    public static final Item AMETHYST_BOOTS = new ArmorItem(AmethystArmorMat, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));


    //---------------------------BLOCKS---------------------------

    public static void register() {

        Registry.register(Registry.RECIPE_SERIALIZER, WandTableSerializer.ID,
                WandTableSerializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE, new Identifier("ameitems", WandTableRecipe.Type.ID), WandTableRecipe.Type.INSTANCE);

        //---------------------------ITEMS---------------------------
        Registry.register(Registry.ITEM, new Identifier("ameitems", "blank_wand"), BLANK_WAND);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "fire_wand"), FIRE_WAND);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "frozen_wand"), FROZEN_WAND);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "water_wand"), WATER_WAND);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "air_wand"), AIR_WAND);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "earth_wand"), EARTH_WAND);


        //---------------------------TOOLS---------------------------
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_shovel"), AMETHYST_SHOVEL);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_sword"), AMETHYST_SWORD);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_pickaxe"), AMETHYST_PICKAXE);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_axe"), AMETHYST_AXE);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_hoe"), AMETHYST_HOE);

        //---------------------------ARMORS---------------------------
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_helmet"), AMETHYST_HELMET);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_chestplate"), AMETHYST_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_leggings"), AMETHYST_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier("ameitems", "amethyst_boots"), AMETHYST_BOOTS);

        //---------------------------BLOCKS--------------------------
        // ---------------------------BLOCKITEMS---------------------------
    }
}
