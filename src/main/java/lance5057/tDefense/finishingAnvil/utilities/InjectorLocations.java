package lance5057.tDefense.finishingAnvil.utilities;

import java.util.ArrayList;
import java.util.List;

public class InjectorLocations
{
	List<String>	list;

	public InjectorLocations()
	{
		list = new ArrayList<String>();

		//BroadSword
		list.add("broadsword_dull_head");
		list.add("broadsword_elusive_head");
		list.add("broadsword_glass_head");
		list.add("broadsword_mace_head");
		list.add("broadsword_plumed_head");
		list.add("broadsword_repulsive_head");
		list.add("broadsword_spiked_head");
		list.add("broadsword_tapered_head");
		list.add("broadsword_widebase_head");
		list.add("broadsword_falchion_head");
		list.add("broadsword_big_head");
		list.add("broadsword_segmented_head");
		list.add("broadsword_nofuller_head");
		list.add("broadsword_hourglass_head");
		list.add("broadsword_flat_head");

		list.add("broadsword_basket_accessory");
		list.add("broadsword_curved_accessory");
		list.add("broadsword_elusive_accessory");
		list.add("broadsword_extended_accessory");
		list.add("broadsword_legendary_accessory");
		list.add("broadsword_no_accessory");
		list.add("broadsword_basket_accessory");
		list.add("broadsword_repulsive_accessory");
		list.add("broadsword_square_accessory");
		list.add("broadsword_straight_accessory");
		list.add("broadsword_straight_accessory");
		list.add("broadsword_bulbous_accessory");
		list.add("broadsword_sun_accessory");
		list.add("broadsword_lamenting_accessory");
		list.add("broadsword_pixie_accessory");
		list.add("broadsword_forked_accessory");

		list.add("broadsword_ornate_handle");
		list.add("broadsword_thick_handle");
		list.add("broadsword_short_handle");

		//Arrow
		list.add("arrow_broad_head");
		list.add("arrow_elven_head");
		list.add("arrow_horned_head");
		list.add("arrow_trident_head");
		list.add("arrow_winged_head");

		list.add("arrow_bulbous_handle");
		list.add("arrow_natural_handle");

		list.add("arrow_matted_accessory");
		list.add("arrow_magic_accessory");
		list.add("arrow_pixie_accessory");
		list.add("arrow_small_accessory");

		//Axe
		list.add("axe_bearded_head");
		list.add("axe_broad_head");
		list.add("axe_minecraft_head");
		list.add("axe_thin_head");

		//Battleaxe
		list.add("battleaxe_halbard_head");
		list.add("battleaxe_magic_head");
		list.add("battleaxe_scythe_head");

		list.add("battleaxe_magic_extra");
		list.add("battleaxe_scythe_extra");
		list.add("battleaxe_halbard_extra");

		list.add("battleaxe_magic_accessory");
		list.add("battleaxe_halbard_accessory");
		list.add("battleaxe_knob_accessory");

		//Battlesign
		list.add("battlesign_small_handle");
		list.add("battlesign_smalllong_handle");

		list.add("battlesign_arrow_head");
		list.add("battlesign_caution_head");
		list.add("battlesign_noentry_head");
		list.add("battlesign_railroad_head");
		list.add("battlesign_stop_head");
		list.add("battlesign_X_head");
	}

	public List getList(String part)
	{
		List<String> request = new ArrayList<String>();

		if(!list.isEmpty())
		{
			for(int i = 0; i < list.size(); i++)
			{
				if(list.get(i).contains(part.toLowerCase()))
				{
					request.add(list.get(i).substring(part.length(), list.get(i).length()));
				}
			}
		}

		return request;
	}
}
