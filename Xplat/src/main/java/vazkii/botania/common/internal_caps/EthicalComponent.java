/*
 * This class is distributed as part of the Botania Mod.
 * Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 */
package vazkii.botania.common.internal_caps;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.PrimedTnt;

import vazkii.botania.common.helper.EthicalTntHelper;

public class EthicalComponent extends SerializableComponent {
	protected static final String TAG_UNETHICAL = "botania:unethical";
	protected boolean unethical;

	public EthicalComponent(PrimedTnt entity) {
		if (!entity.getLevel().isClientSide()) {
			EthicalTntHelper.addTrackedTntEntity(entity);
		}
	}

	public final boolean isUnethical() {
		return unethical;
	}

	public final void markUnethical() {
		unethical = true;
	}

	@Override
	public void readFromNbt(CompoundTag tag) {
		unethical = tag.getBoolean(TAG_UNETHICAL);
	}

	@Override
	public void writeToNbt(CompoundTag tag) {
		tag.putBoolean(TAG_UNETHICAL, unethical);
	}
}
