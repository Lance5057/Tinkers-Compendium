package thaumcraft.api.damagesource;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class DamageSourceIndirectThaumcraftEntity extends EntityDamageSourceIndirect
{

	public DamageSourceIndirectThaumcraftEntity(String par1Str, Entity par2Entity, Entity par3Entity)
	{
		super(par1Str, par2Entity, par3Entity);
	}

	@Override
	public DamageSource setFireDamage()
	{
		return this;
	}

	@Override
	public DamageSource setDamageBypassesArmor()
	{
		return this;
	}
}
