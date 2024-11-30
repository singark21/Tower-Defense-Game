# Tower-Defense-Game

I built a tower defense game to practice Java and intro game design principles! 

Here is the basic overview on what the game contains:
- A path which enemies follow
- A surrounding map for tower placement and a menu with towers, lives, and credits.
- Animations for different enemy states and towers/projectiles.
- Features 3 types of snails as enemies and 2 types of snail weaknesses as towers. 

### Enemies

| **Enemy Type**      | **Speed**            | **Health** | **Spawn Rate**                 | **Special**                                   | **Reward**          |
|---------------------|----------------------|------------|--------------------------------|-----------------------------------------------|---------------------|
| **Snail**           | Fast (0.04/tick)     | Low (1)    | High (1/sec during intervals)  | N/A                                           | Low (0.25 credits)  |
| **SCargo**          | Slow (0.03/tick)     | Medium (3) | Low (1/5 sec during intervals) | On Destroyed: Transforms into Crashed Scargo  | High (2 credits)    |
| **Crashed Scargo**  | Stationary           | High (5)   | N/A                            | Spawn snails at a constant rate               | High (3 credits)    |

### Towers

| **Tower Type** | **Damage**  | **Fire Rate**       | **Special**                            | **Cost**          |
|----------------|-------------|---------------------|----------------------------------------|-------------------|
| **Salt**       | Low (0.5)   | High                | Projectiles follow mouse coordinates   | High (15 credits) |
| **Beer**       | High (1)    | Slow                | Slows Scargos (50% speed on impact)    | Low (5 credits)   |

