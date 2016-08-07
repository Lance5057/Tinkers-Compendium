package thaumcraft.api.damagesource;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class DamageSourceThaumcraft extends DamageSource
{

	public static DamageSource	taint		= new DamageSourceThaumcraft(
			"taint").setDamageBypassesArmor().setMagicDamage();
	public static DamageSource	tentacle	= new DamageSourceThaumcraft(
			"tentacle");
	public static DamageSource	swarm		= new DamageSourceThaumcraft(
			"swarm");
	public static DamageSource	dissolve	= new DamageSourceThaumcraft(
			"dissolve").setDamageBypassesArmor();

	protected DamageSourceThaumcraft(String par1Str)
	{
		super(par1Str);
	}

	public static DamageSource causeSwarmDamage(EntityLivingBase par0EntityLiving)
	{
		return new EntityDamageSource("swarm", par0EntityLiving);
	}

	public static DamageSource causeTentacleDamage(EntityLivingBase par0EntityLiving)
	{
		return new EntityDamageSource("tentacle", par0EntityLiving);
	}

}
