package thaumcraft.api.research;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

public class ResearchItem
{
	/**
	 * A short string used as a key for this research. Must be unique
	 */
	public final String				key;

	/**
	 * A short string used as a reference to the research category to which this must be added.
	 */
	public final String				category;

	/**
	 * The aspect tags and their values required to complete this research
	 */
	public final AspectList			tags;

	/**
	 * This links to any research that needs to be completed before this research can be discovered or learnt.
	 */
	public String[]					parents			= null;

	/**
	 * Like parent above, but a line will not be displayed in the thaumonomicon linking them. Just used to prevent clutter.
	 */
	public String[]					parentsHidden	= null;
	/**
	 * any research linked to this that will be unlocked automatically when this research is complete
	 */
	public String[]					siblings		= null;

	/**
	 * the horizontal position of the research icon
	 */
	public final int				displayColumn;

	/**
	 * the vertical position of the research icon
	 */
	public final int				displayRow;

	/**
	 * the icon to be used for this research 
	 */
	public final ItemStack			icon_item;

	/**
	 * the icon to be used for this research 
	 */
	public final ResourceLocation	icon_resource;

	/**
	 * How large the research grid is. Valid values are 1 to 3.
	 */
	private int						complexity;

	/**
	 * Special research has a spiky border. Used for important research milestones.
	 */
	private boolean					isSpecial;

	/**
	 * Research that can be directly purchased with RP in normal research difficulty.
	 */
	private boolean					isSecondary;

	/**
	 * This indicates if the research should use a circular icon border. Usually used for "passive" research 
	 * that doesn't have recipes and grants passive effects, or that unlock automatically.
	 */
	private boolean					isRound;

	/**
	 * Stub research cannot be discovered by normal means, but can be unlocked via the sibling system.
	 */
	private boolean					isStub;

	/**
	 * This indicated that the research is completely hidden and cannot be discovered by any 
	 * player-controlled means. The recipes will never show up in the thaumonomicon.
	 * Usually used to unlock "hidden" recipes via sibling unlocking, like 
	 * the various cap and rod combos for wands.
	 */
	private boolean					isVirtual;

	/**
	 * Concealed research does not display in the thaumonomicon until parent researches are discovered.
	 */
	private boolean					isConcealed;

	/**
	 * Hidden research can only be discovered via scanning or knowledge fragments 
	 */
	private boolean					isHidden;

	/**
	 * This is the same as isHidden, except it cannot be discovered with knowledge fragments, only scanning.  
	 */
	private boolean					isLost;

	/**
	 * These research items will automatically unlock for all players on game start
	 */
	private boolean					isAutoUnlock;

	/**
	 * Scanning these items will have a chance of revealing hidden knowledge in the thaumonomicon
	 */
	private ItemStack[]				itemTriggers;

	/**
	 * Scanning these entities will have a chance of revealing hidden knowledge in the thaumonomicon
	 */
	private String[]				entityTriggers;

	/**
	 * Scanning things with these aspects will have a chance of revealing hidden knowledge in the thaumonomicon
	 */
	private Aspect[]				aspectTriggers;

	private ResearchPage[]			pages			= null;

	public ResearchItem(String key, String category)
	{
		this.key = key;
		this.category = category;
		tags = new AspectList();
		icon_resource = null;
		icon_item = null;
		displayColumn = 0;
		displayRow = 0;
		setVirtual();

	}

	public ResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ResourceLocation icon)
	{
		this.key = key;
		this.category = category;
		this.tags = tags;
		icon_resource = icon;
		icon_item = null;
		displayColumn = col;
		displayRow = row;
		complexity = complex;
		if(complexity < 1)
		{
			complexity = 1;
		}
		if(complexity > 3)
		{
			complexity = 3;
		}
	}

	public ResearchItem(String key, String category, AspectList tags, int col, int row, int complex, ItemStack icon)
	{
		this.key = key;
		this.category = category;
		this.tags = tags;
		icon_item = icon;
		icon_resource = null;
		displayColumn = col;
		displayRow = row;
		complexity = complex;
		if(complexity < 1)
		{
			complexity = 1;
		}
		if(complexity > 3)
		{
			complexity = 3;
		}
	}

	public ResearchItem setSpecial()
	{
		isSpecial = true;
		return this;
	}

	public ResearchItem setStub()
	{
		isStub = true;
		return this;
	}

	public ResearchItem setLost()
	{
		isLost = true;
		return this;
	}

	public ResearchItem setConcealed()
	{
		isConcealed = true;
		return this;
	}

	public ResearchItem setHidden()
	{
		isHidden = true;
		return this;
	}

	public ResearchItem setVirtual()
	{
		isVirtual = true;
		return this;
	}

	public ResearchItem setParents(String... par)
	{
		parents = par;
		return this;
	}

	public ResearchItem setParentsHidden(String... par)
	{
		parentsHidden = par;
		return this;
	}

	public ResearchItem setSiblings(String... sib)
	{
		siblings = sib;
		return this;
	}

	public ResearchItem setPages(ResearchPage... par)
	{
		pages = par;
		return this;
	}

	public ResearchPage[] getPages()
	{
		return pages;
	}

	public ResearchItem setItemTriggers(ItemStack... par)
	{
		itemTriggers = par;
		return this;
	}

	public ResearchItem setEntityTriggers(String... par)
	{
		entityTriggers = par;
		return this;
	}

	public ResearchItem setAspectTriggers(Aspect... par)
	{
		aspectTriggers = par;
		return this;
	}

	public ItemStack[] getItemTriggers()
	{
		return itemTriggers;
	}

	public String[] getEntityTriggers()
	{
		return entityTriggers;
	}

	public Aspect[] getAspectTriggers()
	{
		return aspectTriggers;
	}

	public ResearchItem registerResearchItem()
	{
		ResearchCategories.addResearch(this);
		return this;
	}

	public String getName()
	{
		return StatCollector.translateToLocal("tc.research_name." + key);
	}

	public String getText()
	{
		return StatCollector.translateToLocal("tc.research_text." + key);
	}

	public boolean isSpecial()
	{
		return isSpecial;
	}

	public boolean isStub()
	{
		return isStub;
	}

	public boolean isLost()
	{
		return isLost;
	}

	public boolean isConcealed()
	{
		return isConcealed;
	}

	public boolean isHidden()
	{
		return isHidden;
	}

	public boolean isVirtual()
	{
		return isVirtual;
	}

	public boolean isAutoUnlock()
	{
		return isAutoUnlock;
	}

	public ResearchItem setAutoUnlock()
	{
		isAutoUnlock = true;
		return this;
	}

	public boolean isRound()
	{
		return isRound;
	}

	public ResearchItem setRound()
	{
		isRound = true;
		return this;
	}

	public boolean isSecondary()
	{
		return isSecondary;
	}

	public ResearchItem setSecondary()
	{
		isSecondary = true;
		return this;
	}

	public int getComplexity()
	{
		return complexity;
	}

	public ResearchItem setComplexity(int complexity)
	{
		this.complexity = complexity;
		return this;
	}

	/**
	 * @return the aspect aspects ordinal with the highest value. Used to determine scroll color and similar things
	 */
	public Aspect getResearchPrimaryTag()
	{
		Aspect aspect = null;
		int highest = 0;
		if(tags != null)
		{
			for(final Aspect tag : tags.getAspects())
			{
				if(tags.getAmount(tag) > highest)
				{
					aspect = tag;
					highest = tags.getAmount(tag);
				}
				;
			}
		}
		return aspect;
	}

}
