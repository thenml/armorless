package net.nml.armorless.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.nml.armorless.Armorless;

@Mixin(net.minecraft.entity.player.PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {
	protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
		super(entityType, world);
	}

	@Shadow
	public abstract Iterable<ItemStack> getArmorItems();

	@Shadow
	public abstract boolean damage(DamageSource source, float amount);

	@Inject(at = @At("TAIL"), method = "tick()V")
	private void applyArmorDamage(CallbackInfo info) {
		float damage = Armorless.DAMAGE;

		int armor = this.getArmor();
		if (armor == 0) {
			damage = 0;
		} else if (Armorless.DAMAGE < 0) {
			damage = armor * Armorless.DAMAGE_MULTIPLYER;
		}

		if (Armorless.ALL_ITEMS) {
			for (ItemStack itemStack : this.getArmorItems()) {
				if (itemStack.isEmpty() || (itemStack.getItem() instanceof ArmorItem))
					continue;

				if (Armorless.DAMAGE < 0) {
					damage += Armorless.DAMAGE_MULTIPLYER * 2;
				} else {
					damage = Armorless.DAMAGE;
				}
			}
		}

		if (damage > 0) {
			this.damage(this.getDamageSources().cramming(), damage);
		}
	}
}