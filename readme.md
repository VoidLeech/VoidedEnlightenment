# Voided Enlightenment
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/{template-mod-slug}?style=flat&logo=modrinth&label=Modrinth)](https://modrinth.com/mod/{template-mod-slug})
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/{project-id}?style=flat&logo=curseforge&label=Curseforge)](https://www.curseforge.com/minecraft/mc-mods/{template-mod-slug})
![Modrinth Game Versions](https://cf.way2muchnoise.eu/versions/{project-id}.svg)

A minuson for [Enlightend](https://modrinth.com/mod/enlightend), that is: an addon that mainly removes things; I reject the supposed enlightenment and substitute my own.

I like a lot of Enlightend's features. But there's some I don't, and there's features I think can be expanded.  
Additionally, the mod is in a buggy state at the moment, and while fixes for those have been announced to be in the next big update, that next big update is also set to remove some features I like and add more features I don't, so that won't do (for me).

### Features
#### Additions
- Thematic recipes for 2/3 (3rd tbd) Enlightend potions that lacked recipes.
- Compat with Waxed Icons for waxed blocks made from Bismuth.
- Nuclear Bomb can now be disabled via config.
- Cerulean Stalk can now be bone-mealed.
- Cerulean Stalk can now directly be placed below other cerulean stalk, like bamboo can on top of bamboo.
- Ooze Rain can now fill Cauldrons.
- Sides of Nuclear Furnace now correspond to the input and output slots for automation.
- Dash Leggings now also work vertically, and horizontal dash is now also dependent on your looking direction.
- Boost Boots now behave on Lasers like Leather Boots on Powder Snow: proper walking, jumping possible, sneaking to descend.
- Boots enchanted with Frost Walker now allow you to walk on Helium and Xenon Gas.
#### Removals
- Disabled Enlightend's custom end fog, as it had jarring, sudden transitions.
- Ender Chests have the vanilla loot table and recipe instead of the Enlightend one requiring Malachite.
- Turned off the one-time-per-world in-game advertising, see [details](src/main/java/com/github/voidleech/voided_enlightenment/mixin/misc/PatreonMessageMixin.java).
- Liquid Ooze is no longer a swimmable liquid, isn't renewable via adjacent source blocks anymore, and is slightly slower to move through.
- Disabled Void Leviathan spawning for the foreseeable future, until I figure out a way to tweak it that doesn't leave it as an unengaging damage sponge.
- Hoppers don't break when horizontally adjacent to Nuclear Furnaces anymore.

### Fixes
- Enlightend's potion recipes are now viewable in recipe viewers like JEI.
- Freshly planted cerulean stalk can now be mined and actually drops cerulean stalk.
- The Offering Statue loot table now works.
- The Adamantite Knife can now be crafted and works in Farmer's Delight recipes.
- Ooze is no longer part of the minecraft:water fluid tag.
- Cauldrons can now be filled via Ooze Buckets (instead of only via Ooze Bottles), and can be properly emptied via Glass Bottles.
- Several items now have proper crafting remainders.
- Xenon Laser now can be properly toggled between burning and freezing mode, and works on active lasers as well.
- Several fixes to right-click interactions not triggering.
- Non-Nuclear Fuel Items being able to be put in the Nuclear Furnace's fuel slot via Item Transfer Capabilities.
- Ennegel Splat can't float freely anymore.
- Applying Ennegel Glob to an Ennegel Block now consumes Ennegel.
- Springleaf no longer has a hitbox that is solid all the way to the bottom of the block.
- See-Through Lava from various mods (Alex's Mobs: Lava Vision; L_Ender's Cataclysm: Ignitium Helmet) now works as intended when used in combination with Enlightend.
- Fog from Alex's Caves now works as intended when used in combination with Enlightend.
- Fixes an incidental crash with Presence Footsteps.
- Fixes/Consistency Changes related to the Language file.
- Volume/Consistency Changes related to Sounds.

### F.A.Q.
**Q: Can this be used in my CurseForge/Modrinth modpack?**  
A: Yes.

**Q: Will you add support for Enlightend versions past 5.0.14, when that releases?**  
A: I'm undecided but heavily lean towards no. It'd practically be an entire rewrite, as:
- Lixir (Enlightend dev) has gone and stated he's fixed many (but tbf not all) of the bugs I've shimmied in a fix for.
- His next big (stated to be final) update is also a massive rewrite, probably breaking a bunch/all of what I've done here.
- He's adding a bunch of new features that I'll have to review for whether I think they're actually fun:
  - This is a significant amount of work due to the nature of Enlightend being an MCreator mod and the code being very unorganized. Editing it too is a pain.
  - For some of the announced features, I already know I'd want to remove them, and the others don't excite me all that much.
  - A stated dependency on V-Minus and the (valid but not to my taste) design mindset that comes with it. I'd have to gut that entire mod as well.

So all in all I'm more inclined to stick to 5.0.14 and not put time into removing 99% of his update.

### Licensing
This project is released under a [VL Art-Excluding MIT license](LICENSE).
