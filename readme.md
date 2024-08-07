# Voided Enlightenment
[![Modrinth Downloads](https://img.shields.io/modrinth/dt/{template-mod-slug}?style=flat&logo=modrinth&label=Modrinth)](https://modrinth.com/mod/{template-mod-slug})
[![CurseForge Downloads](https://img.shields.io/curseforge/dt/{project-id}?style=flat&logo=curseforge&label=Curseforge)](https://www.curseforge.com/minecraft/mc-mods/{template-mod-slug})
![Modrinth Game Versions](https://cf.way2muchnoise.eu/versions/{project-id}.svg)

An minuson for [Enlightend](https://modrinth.com/mod/enlightend), that is: an addon that mainly removes things; I reject the supposed enlightenment and substitute my own.

I like a lot of Enlightend's features. But there's some I don't, and there's features I think can be expanded.  
Additionally, the mod is in a buggy state at the moment, and while fixes for those have been announced to be in the next big update, that next big update is also set to remove some features I like and add more features I don't, so that won't do (for me).

### Features
#### Additions
- Thematic recipes for 2/3 (3rd tbd) Enlightend potions that lacked recipes.
- Compat with Waxed Icons for waxed blocks made from Bismuth.
- Nuclear Bomb can now be disabled via config.
#### Removals
- Disabled Enlightend's end fog, as it had jarring, sudden transitions.
- Ender Chests have the vanilla loot table and recipe instead of the Enlightend one requiring Malachite.
- Turned off the one-time-per-world in-game advertising, see [details](src/main/java/com/github/voidleech/voided_enlightenment/mixin/misc/PatreonMessageMixin.java).

### Fixes
- Enlightend's potion recipes are now viewable in recipe viewers like JEI.
- Freshly planted cerulean stalk can now be mined and actually drops cerulean stalk.
- The Offering Statue loot table now works.
- The Adamantite Knife can now be crafted and works in Farmer's Delight recipes.
- Ooze is no longer part of the minecraft:water fluid tag.
- Lava Vision from Alex's Mobs now works as intended when used in combination with Enlightend.
- Lang Fixes/Consistency Changes.

### F.A.Q.
**Q: Can this be used in my CurseForge/Modrinth modpack?**  
A: Yes.

**Q: Will you add support for Enlightend versions past 5.0.14, when that releases?**  
A: I'm undecided. It'd practically be an entire rewrite, as:
- Lixir (Enlightend dev) has gone and stated he's fixed many (but tbf not all) of the bugs I've shimmied in a fix for
- His next big (stated to be final) update is also a massive rewrite, probably breaking a bunch of what I've done here.
- He's adding a bunch of new features to review (lots of work due to the nature of Enlightend being an MCreator mod), when I'm more inclined to stick to 5.0.14 for personal use due to:
- Stated Dependency on V-Minus and the (valid but not to my taste) design mindset that comes with it. I'd have to basically gut that entire mod as well.

### Licensing
This project is released under a [VL Art-Excluding MIT license](LICENSE).
