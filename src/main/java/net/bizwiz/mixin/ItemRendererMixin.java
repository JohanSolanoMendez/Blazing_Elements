package net.bizwiz.mixin;

import net.bizwiz.BlazingElements;
import net.bizwiz.item.BlazingItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",at = @At(value = "HEAD"),argsOnly = true)
    public BakedModel useBouldrosClawModel(BakedModel value, ItemStack itemStack, ModelTransformationMode renderMode, boolean  leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumer, int light, int overlay){
        if(itemStack.isOf(BlazingItems.BOULDROSCLAW) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.FIXED){
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(BlazingElements.MOD_ID,"bouldros_claw_3d","inventory"));
        }
        return value;
    }

    @ModifyVariable(method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",at = @At(value = "HEAD"),argsOnly = true)
    public BakedModel useBlazingStaffModel(BakedModel value, ItemStack itemStack, ModelTransformationMode renderMode, boolean  leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumer, int light, int overlay){
        if(itemStack.isOf(BlazingItems.BLAZINGSTAFF) && renderMode != ModelTransformationMode.GUI && renderMode != ModelTransformationMode.FIXED){
            return ((ItemRendererAccessor) this).mccourse$getModels().getModelManager().getModel(new ModelIdentifier(BlazingElements.MOD_ID,"blazing_staff_3d","inventory"));
        }
        return value;
    }
}
