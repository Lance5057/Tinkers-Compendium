# Tinkers Compendium - Lean

An edit to the 1.12 version of Tinkers Compendium to remove stuff that is either broken or personally not very necessary.

What this fork changes from the original:

- ALL materials, blocks, extra gubbins added by the mod have been removed.
- Everything except:
    -Heavy Armour
    -Chain Armour
    -Buckler Shields
    -Heater Shields
    -Shears
    -Rings
  Have been removed.
  
- Updated Heavy Armour model and texture:
    -Helmet now has a leather mask under the visor.
    -Visor now has more mouth slits.
    -Breastplate pauldrons adjusted, added gauntlets.
    -Leggings belts removed (they looked out of place to me)
    -Boots plating adjusted to avoid z-fighting with leggings.
    -Cloth lengths adjusted to make chain parts stand out more.
    -Cloth made darker.
    -Recoloured some cloth parts to look like leather no matter the colour of cloth applied.
    
- Updated Chain Armour model and texture.
    -Hauberk now has vambraces. adjusted pauldrons due to misalignment issues.
    -Hauberk straps adjusted, recoloured to look like leather.
    -Boots slightly adjusted to look better.
    -Cloth lengths adjusted to make chain parts stand out more.
    -Cloth made darker.
    -Recoloured some cloth parts to look like leather no matter the colour of cloth applied.

- Heater Shields renamed to Kiteshields

- Pseudo-integrated compendium armours with constructs armoury by doing the following:
    -Compendium Armour now requires conarm parts to create them (consequently, all unecessary compendium parts are removed)
    -Removed the Compendium book and merged the entries with conarms book.
    -NOTE: Changes to conarm were necessary for this to happen so requires my fork of conarm to function.
    
- Updated model for Armor station
- Updated and fixed Armor Station GUI by changing the incorrect title, reduced the search box size, changed the texture of the GUI.
- Armor Station GUI now has a working preview that shows the completed armor piece before finalizing.
- Renamed Armor Station to Armor Refinery.

- Chain Boots now show up in JEI.

- Armor parts now show up as craftable in the book (using some rather cheaty method).

- Fixed/Updated/Changed/Added some material traits

- Heavy Helm visor now goes up and down based on item held in left hand. Most swords and axes will trigger this, aswell as tinkers construct weapons.
- Blocking with a shield will also cause the visor to lower.
- Added config to add more weapons if they happen to not trigger the visor
