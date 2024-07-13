package net.bizwiz.datagen;

import net.bizwiz.item.BlazingItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class BlazingAdvancementProvider extends FabricAdvancementProvider {
    public BlazingAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {
        Advancement rootAdvancement = Advancement.Builder.create()
                .display(
                        BlazingItems.BOULDROSROD, // El icono de visualización
                        Text.translatable("advancement.blazingelements.bouldros_rod_title"), // El título traducible
                        Text.translatable("advancement.blazingelements.bouldros_rod_description"), // La descripción traducible
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Imagen de fondo
                        AdvancementFrame.TASK, // Opciones: TASK, CHALLENGE, GOAL
                        true, // Mostrar notificación en la parte superior derecha
                        true, // Anunciar en el chat
                        false // Oculto en la pestaña de logros
                )
                .criterion("got_bouldros_rod", InventoryChangedCriterion.Conditions.items(BlazingItems.BOULDROSROD ))
                .build(consumer, "blazingelements/root").value();

        Advancement secondRootAdvancement = Advancement.Builder.create().parent(Identifier.tryParse("blazingelements/root"))
                .display(
                        BlazingItems.UNCHARGEELEMENTALSWORD, // El icono de visualización
                        Text.translatable("advancement.blazingelements.hero_sword_title"), // El título traducible
                        Text.translatable("advancement.blazingelements.hero_sword_description"), // La descripción traducible
                        new Identifier("textures/gui/advancements/backgrounds/adventure.png"), // Imagen de fondo
                        AdvancementFrame.CHALLENGE, // Opciones: TASK, CHALLENGE, GOAL
                        true, // Mostrar notificación en la parte superior derecha
                        true, // Anunciar en el chat
                        false // Oculto en la pestaña de logros
                )
                .criterion("got_sword", InventoryChangedCriterion.Conditions.items(BlazingItems.UNCHARGEELEMENTALSWORD))
                .build(consumer, "blazingelements/root").value();
    }
}
