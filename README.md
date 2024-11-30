# Tower-Defense-Game

I built a tower defense game to practice Java and intro game design principles! 

Here is the basic overview on what the game contains:
- A path which enemies follow
- A surrounding map for tower placement and a menu with towers, lives, and credits.
- Animations for different enemy states and towers.
- Features 3 types of snails as enemies and 2 types of snail weaknesses as towers. 

Specific enemy and tower details:

Snail Enemy
- Fast movement speed (0.04 units/tick)
- Low health (1 health)
- Swarm unit (spawns at a higher rate) (1 per second during certain time intervals)
- Low credit reward on kill (0.25 credits)

SCargo Enemy
- Slow movement speed (0.03/tick)
- Medium health (3 health)
- Low spawn rate (Average 1 per 5 seconds during specific intervals)
- On destroyed: Transform into a Crashed Scargo
- High credit reward on kill (2 credits)

Crashed Scargo Enemy
- Stationary
- High health (5 health)
- Spawns snails at a constant rate until destroyed
- High credit reward on kill (3 credits)

Salt Tower
- Low damage (0.5 damage)
- High fire rate
- High cost (15 credits)
- Salt projectiles always travel to mouse coordinates (projectiles follow mouse)

Beer Tower
- High damage (1 damage)
- Slows Scargos on projectile impact (50% speed)
- Slow fire rate
- Low cost (5 credits)
- Automatically targets and fires at enemies
