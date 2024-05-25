# Armorless

Simple mod to deal damage to players when wearing armor.
Inspired by the [Naked and Afraid](https://youtu.be/Yuvk4rfhjog) no armor hardcore multiplayer let's play by multiple content creators.

## Configuration

Configuration is done through the file `armorless.properties` in the config directory

```
# Static damage. Set to -1 to use the multiplyer
damage=-1

# Take damage multiplied by the armor defense
damage_multiplyer=0.5

# Make any item put in armor slots do damage (elytra, mob heads, etc.)
all_items=false
```

By default the amount of damage taken is half of a player's defense, for example wearing a diamond chestplate will deal 4 damage each second, which gives around 5 seconds to take it off without dying. This is so that some vanilla advancements (or modded) that require armor to be worn can be completed in hardcore without dying.
