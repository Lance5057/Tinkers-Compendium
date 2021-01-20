package lance5057.tDefense.core.materials.traits;

import lance5057.tDefense.TCConfig;
import lance5057.tDefense.core.tools.TDToolEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import java.util.List;

public class TraitNovel extends AbstractTDTrait {

	public TraitNovel() {
		super("novel", TextFormatting.WHITE);
	}

	public void onDamageTaken(ItemStack tool, LivingHurtEvent e) {

		if (e.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer ent = (EntityPlayer) e.getEntityLiving();
			float dmg = e.getAmount();

			if (dmg >= 1) {
				if(ent.experience >= 5)
				{
					dmg--;
					ent.experience -= 5;

				}
			}
			e.setAmount(dmg);
		}
	}

	@Override
	public void onArmorTick(ItemStack tool, World world, EntityPlayer player) {
		AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();

		List<Entity> list = world.getEntitiesWithinAABBExcludingEntity(player, axisalignedbb);

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = list.get(i);

			if (entity instanceof EntityXPOrb) {
				int rand = world.rand.nextInt(30);
				int chance = world.rand.nextInt(10); // reduce how often it happens so its not just white noise

				if (chance < 1) {
					if (rand == 1) {
						player.sendMessage(new TextComponentString("Cramped in all kinds of dim cupboards and hutches at Tellson's, the oldest of men carried on the business gravely. When they took a young man into Tellson's London house, they hid him somewhere till he was old. They kept him in a dark place, like a cheese, until he had the full Tellson flavour and blue-mould upon him. Then only was he permitted to be seen, spectacularly poring over large books, and casting his breeches and gaiters into the general weight of the establishment."));
					}
					else if (rand == 2) {
						player.sendMessage(new TextComponentString("I doubt whether any girl would be satisfied with her lover's mind if she knew the whole of it."));
					}
					else if (rand == 3) {
						player.sendMessage(new TextComponentString("Mrs. Boffin, insisting that Bella should make tomorrow's expedition in the chariot, she went home in great grandeur. Mrs. Wilfer and Miss Lavinia had speculated much on the probabilities and improbabilities of her coming in this gorgeous state, and, on beholding the chariot from the window at which they were secreted to look out for it, agreed that it must be detained at the door as long as possible, for the mortification and confusion of the neighbours."));
					}
					else if (rand == 4) {
						player.sendMessage(new TextComponentString("I have learned not to think little of any one's belief, no matter how strange it may be. I have tried to keep an open mind, and it is not the ordinary things of life that could close it, but the strange things, the extraordinary things, the things that make one doubt if they be mad or sane."));
					}
					else if (rand == 5) {
						player.sendMessage(new TextComponentString("You needn't tell me that a man who doesn't love oysters and asparagus and good wines has got a soul, or a stomach either. He's simply got the instinct for being unhappy highly developed."));
					}
					else if (rand == 6) {
						player.sendMessage(new TextComponentString("I had a latent impression that there was something decidedly fine in Mr. Wopsle's elocution - not for old associations' sake, I am afraid, but because it was very slow, very dreary, very up-hill and down-hill, and very unlike any way in which any man in any natural circumstances of life or death ever expressed himself about anything."));
					}
					else if (rand == 7) {
						player.sendMessage(new TextComponentString("You know, there are two good things in life, freedom of thought and freedom of action."));
					}
					else if (rand == 8) {
						player.sendMessage(new TextComponentString("It was, as I have said, a fine autumnal day; the sky was clear and serene, and nature wore that rich and golden livery which we always associate with the idea of abundance. The forests had put on their sober brown and yellow, while some trees of the tenderer kind had been nipped by the frosts into brilliant dyes of orange, purple, and scarlet."));
					}
					else if (rand == 9) {
						player.sendMessage(new TextComponentString("No, the office is one thing, and private life is another. When I go into the office, I leave the Castle behind me, and when I come into the Castle, I leave the office behind me."));
					}
					else if (rand == 10) {
						player.sendMessage(new TextComponentString("We are such stuff as dreams are made on, and our little life is rounded with a sleep."));
					}
					else if (rand == 11) {
						player.sendMessage(new TextComponentString("Science, my lad, is made up of mistakes, but they are mistakes which it is useful to make, because they lead little by little to the truth."));
					}
					else if (rand == 12) {
						player.sendMessage(new TextComponentString("How marvellously lie our anxieties, in filmy layers, one over the other! Take away that which has lain on the upper surface for so long-the care of cares-the only one, as it seemed to you, between your soul and the radiance of Heaven-and straight you find a new stratum there."));
					}
					else if (rand == 13) {
						player.sendMessage(new TextComponentString("It looked as if someone had cut a patch out of the air, about two metres from the edge of the road, a patch roughly square in shape and less than a metre across. If you were level with the patch so that it was edge-on, it was nearly invisible, and it was completely invisible from behind. You could only see it from the side nearest the road, and you couldn't see it easily even from there, because all you could see through it was exactly the same kind of thing that lay in front of it ont his side: a patch of grass lit by a street light."));
					}
					else if (rand == 14) {
						player.sendMessage(new TextComponentString("This whole act's immutably decreed. 'Twas rehearsed by thee and me a billion years before this ocean rolled. Fool! I am the Fates' lieutenant; I act under orders."));
					}
					else if (rand == 15) {
						player.sendMessage(new TextComponentString("Then a dog began to howl somewhere in a farmhouse far down the road, a long, agonized wailing, as if from fear. The sound was taken up by another dog, and then another and another, till, borne on the wind which now sighed softly through the Pass, a wild howling began, which seemed to come from all over the country, as far as the imagination could grasp it through the gloom of the night."));
					}
					else if (rand == 16) {
						player.sendMessage(new TextComponentString("In old days there were angels who came and took men by the hand and led them away from the city of destruction. We see no white-winged angels now. But yet men are led away from threatening destruction: a hand is put into theirs, which leads them forth gently towards a calm and bright land, so that they look no more backward; and the hand may be a little child's."));
					}
					else if (rand == 17) {
						player.sendMessage(new TextComponentString("Charles Darnay seemed to stand in a company of the dead. Ghosts all! The ghost of beauty, the ghost of stateliness, the ghost of elegance, the ghost of pride, the ghost of frivolity, the ghost of wit, the ghost of youth, the ghost of age, all waiting their dismissal from the desolate shore, all turning on him eyes that were changed by the death they had died in coming there."));
					}
					else if (rand == 18) {
						player.sendMessage(new TextComponentString("No more shall ye behold such sights of woe, deeds I have suffered and myself have wrought; henceforward quenched in darkness shall ye see those ye should ne'er have seen; now blind to those whom, when I saw, I vainly yearned to know."));
					}
					else if (rand == 19) {
						player.sendMessage(new TextComponentString("Yet, though love is thus an end in itself, it must be believed to be the means to another end if it is to assume the rosy hues of an unalloyed pleasure."));
					}
					else if (rand == 20) {
						player.sendMessage(new TextComponentString("It thrilled through him when he first felt the keel answer to his hand on the spokes and slide over the long hollows as the foresail scythed back and forth against the blue sky. "));
					}
					else if (rand == 21) {
						player.sendMessage(new TextComponentString("It was one January morning, very early—a pinching, frosty morning—the cove all grey with hoar-frost, the ripple lapping softly on the stones, the sun still low and only touching the hilltops and shining far to seaward."));
					}
					else if (rand == 22) {
						player.sendMessage(new TextComponentString("Long may it remain in this mixed world a point not easy of decision, which is the more beautiful evidence of the Almighty's goodness--the delicate fingers that are formed for sensitiveness and sympathy of touch, and made to minister to pain and grief, or the rough hard Captain Cuttle hand, that the heart teaches, guides, and softens in a moment!"));
					}
					else if (rand == 23) {
						player.sendMessage(new TextComponentString("She indulged in melancholy - that cheapest and most accessible of luxuries."));
					}
					else if (rand == 24) {
						player.sendMessage(new TextComponentString("Strong mental agitation and disturbance was no novelty to him, even before his late sufferings. It never is, to obstinate and sullen natures; for they struggle hard to be such."));
					}
					else if (rand == 25) {
						player.sendMessage(new TextComponentString("Rays from the sunrise drew forth the buds and stretched them into long stalks, lifted up sap in noiseless streams, opened petals, and sucked out scents in invisible jets and breathings. "));
					}
					else if (rand == 26) {
						player.sendMessage(new TextComponentString("Angel is the name of their office, not of their nature. If you seek the name of their nature, it is spirit; if you seek the name of their office, it is angel; from what they are, spirit, from what they do, angel."));
					}
					else if (rand == 27) {
						player.sendMessage(new TextComponentString("Lovely in the moonlight, her brilliant dark eyes wide with enchantment, her slender shape light and graceful; but as she snapped her fingers, the monkey stopped at once and leapt up into her arms, and he saw that the sweet-faced woman and the evil monkey were one being."));
					}
					else if (rand == 28) {
						player.sendMessage(new TextComponentString("Even in common people, conceit has the virtue of making them cheerful; the man who thinks his wife, his baby, his house, his horse, his dog, and himself severally unequalled, is almost sure to be a good-humored person, though liable to be tedious at times."));
					}
					else if (rand == 29) {
						player.sendMessage(new TextComponentString("At a single strain of music, the scent of a flower, or even one glimpse of a path of moonlight lying fair upon a Summer sea, the barriers crumble and fall. Through the long corridors the ghosts of the past walk unforbidden, hindered only by broken promises, dead hopes, and dream-dust."));
					}
					else if (rand == 30) {
						player.sendMessage(new TextComponentString("There are strings, said Mr. Tappertit, flourishing his bread-and-cheese knife in the air, in the human heart that had better not be wibrated."));
					}

				}
			}
		}
	}
}
