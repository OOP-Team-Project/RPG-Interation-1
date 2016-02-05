# RPG-Interation-1
First iteration of the RPG game.


Load/Save file should be in this form (looks kind of ugly, but gives lots of special characters to split on). 
Each one of the lines between the exclamation points can be repeated as many times as is necessary. ~Josh

!
GGMM%					<-- Map grid
GGWM%
GWWG%
GWGG%
!
decal_type;x,y%		<-- Decals on map
!
item_type;x,y%			<-- Items on map
!
effect_type;x,y-amount(if HealDamage or TakeDamage)%			<-- Area Effects on map
!
orientation;location;occupation;strength;agility;intellect;hardiness;movementSpeed;currentMana;currentHealth;livesLeft;experience%			<-- Entities
!
item%					<-- Items in inventory; not sure how to split up the statModifiers in it yet
