package lumien.randomthings.handler;

import lumien.randomthings.handler.spectre.SpectreWorldProvider;
import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions
{
	public static int SPECTRE_ID = "Spectre".hashCode();

	public static void register()
	{
		DimensionManager.registerDimension(SPECTRE_ID, DimensionType.register("Spectre", "Spectre_", SPECTRE_ID, SpectreWorldProvider.class, true));
	}
}
