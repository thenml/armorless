package net.nml.armorless;

import net.fabricmc.api.ModInitializer;

public class Armorless implements ModInitializer {
	static SimpleConfig CONFIG = SimpleConfig.of("armorless").provider((String filename) -> {
		return "# Static damage. Set to -1 to use the multiplyer, set to 0 to disable\n" +
				"damage=-1.0\n\n" +
				"# Take damage multiplied by the armor defense\n" +
				"damage_multiplyer=0.5\n\n" +
				"# Make any item put in armor slots do damage (elytra, mob heads, etc.)\n" +
				"all_items=false";
	}).request();

	public static final float DAMAGE = CONFIG.getOrDefault("damage", -1.0f);
	public static final float DAMAGE_MULTIPLYER = CONFIG.getOrDefault("damage_multiplyer", 0.5f);
	public static final boolean ALL_ITEMS = CONFIG.getOrDefault("all_items", false);

	@Override
	public void onInitialize() {
	}
}