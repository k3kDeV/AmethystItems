package io.github.k3kdev.amethystitems;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WandTableSerializer implements RecipeSerializer<WandTableRecipe> {

    @Override
    public WandTableRecipe read(Identifier recipeId, JsonObject json) {
        WandTableJsonFormat recipeJson = new Gson().fromJson(json, WandTableJsonFormat.class);
        // Validate all fields are there
        if (recipeJson.inputA == null || recipeJson.inputB == null || recipeJson.outputItem == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }
        // We'll allow to not specify the output, and default it to 1.
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;

        Ingredient inputA = Ingredient.fromJson(recipeJson.inputA);
        Ingredient inputB = Ingredient.fromJson(recipeJson.inputB);
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem))
                // Validate the inputted item actually exists
                .orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);

        return new WandTableRecipe(inputA, inputB, output, recipeId);
    }

    @Override
    public void write(PacketByteBuf packetData, WandTableRecipe recipe) {
        recipe.getInputA().write(packetData);
        recipe.getInputB().write(packetData);
        packetData.writeItemStack(recipe.getOutput());
    }

    @Override
    public WandTableRecipe read(Identifier recipeId, PacketByteBuf packetData) {
        // Make sure the read in the same order you have written!
        Ingredient inputA = Ingredient.fromPacket(packetData);
        Ingredient inputB = Ingredient.fromPacket(packetData);
        ItemStack output = packetData.readItemStack();
        return new WandTableRecipe(inputA, inputB, output, recipeId);
    }

    public static final WandTableSerializer INSTANCE = new WandTableSerializer();

    // This will be the "type" field in the json
    public static final Identifier ID = new Identifier("ameitems:wand_table_recipe");


}