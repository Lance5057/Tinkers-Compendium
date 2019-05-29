package lance5057.tDefense.core.entities;

import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;

public class EntityPhantomWolf extends EntityWolf {

	float lifetime = 1000;
	
	public EntityPhantomWolf(World worldIn) {
		super(worldIn);
	}

	@Override
	public void onUpdate()
    {
		super.onUpdate();
		lifetime--;
		
		if(lifetime<=0)
		{
			this.setDead();
		}
    }
}
