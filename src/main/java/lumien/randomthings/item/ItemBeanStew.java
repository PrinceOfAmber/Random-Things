package lumien.randomthings.item;

import lumien.randomthings.util.RegisterUtil;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBeanStew extends ItemFood
{
	public ItemBeanStew()
	{
		super(8, false);

		RegisterUtil.registerItem(this, "beanStew");
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase livingEntity)
	{
		super.onItemUseFinish(stack, worldIn, livingEntity);

		if (stack.stackSize == 0)
		{
			return new ItemStack(Items.BOWL);
		}
		else
		{
			if (livingEntity instanceof EntityPlayer)
			{
				boolean inventory = ((EntityPlayer)livingEntity).inventory.addItemStackToInventory(new ItemStack(Items.BOWL));

				if (!inventory && !worldIn.isRemote)
				{
					worldIn.spawnEntityInWorld(new EntityItem(worldIn, livingEntity.posX, livingEntity.posY, livingEntity.posZ, new ItemStack(Items.BOWL)));
				}
			}
			return stack;
		}
	}
}
