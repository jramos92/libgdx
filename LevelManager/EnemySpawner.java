package org.sfsoft.jfighter2dx.managers;

import static org.sfsoft.jfighter2dx.util.Constants.ENEMY_HEIGHT;
import static org.sfsoft.jfighter2dx.util.Constants.HEIGHT;

import java.util.Random;

import org.sfsoft.jfighter2dx.characters.BigEnemy;
import org.sfsoft.jfighter2dx.characters.Enemy;
import org.sfsoft.jfighter2dx.characters.Enemy.EnemyType;
import org.sfsoft.jfighter2dx.characters.PursuerEnemy;
import org.sfsoft.jfighter2dx.characters.ShooterEnemy;
import org.sfsoft.jfighter2dx.characters.SmallEnemy;
import org.sfsoft.jfighter2dx.characters.StaticShooterEnemy;
import org.sfsoft.jfighter2dx.characters.Stone;
import org.sfsoft.jfighter2dx.characters.ShooterBullet.BulletDirection;
import org.sfsoft.jfighter2dx.util.Constants;

/**
 * Clase donde se gestiona la generación de enemigos de diferentes tipos
 * @author Santiago Faci
 * @version 1.0
 *
 */
public class EnemySpawner {

	/**
	 * Crea un enemigo en la parte derecha de la pantalla y a un altura aleatoria
	 * @param type
	 * @return
	 * @throws SlickException
	 */
	public static Enemy createEnemy(EnemyType type, SpriteManager spriteManager) {
		
		Enemy enemy = null;
		
		switch (type) {
		
			case SMALL_ENEMY:
				enemy = new SmallEnemy(Constants.WIDTH, new Random().nextInt(HEIGHT - ENEMY_HEIGHT), -50f);
				break;
			case SHOOTER_ENEMY:
				int location = new Random().nextInt(2);
				
				if (location == 0) { 
					location = 20;
					enemy = new ShooterEnemy(Constants.WIDTH, location, -120f, BulletDirection.DOWN);
				}
				else {
					location = HEIGHT - ENEMY_HEIGHT - 20;
					enemy = new ShooterEnemy(Constants.WIDTH, location, -120f, BulletDirection.UP);
				}
				((ShooterEnemy) enemy).setEnemies(spriteManager.getEnemies());
				 
				break;
			case STONE:
				enemy = new Stone(Constants.WIDTH, new Random().nextInt(HEIGHT - ENEMY_HEIGHT), -50f);
				break;
			case BIG_ENEMY:
				enemy = new BigEnemy(Constants.WIDTH, new Random().nextInt(HEIGHT - ENEMY_HEIGHT * 2), -100f);
				break;
			case PURSUER_ENEMY:
				enemy = new PursuerEnemy(Constants.WIDTH, new Random().nextInt(HEIGHT - ENEMY_HEIGHT), -100f);
				((PursuerEnemy) enemy).setShip(spriteManager.getShip());
				break;
			case STATIC_SHOOTER_ENEMY:
				enemy = new StaticShooterEnemy(Constants.WIDTH - 100, new Random().nextInt(HEIGHT - ENEMY_HEIGHT), -100f, BulletDirection.LEFT);
				((StaticShooterEnemy) enemy).setEnemies(spriteManager.getEnemies());
			default:
				break;
		}
		
		return enemy;
	}
	
	/**
	 * Crea un enemigo en un lugar determinado de la pantalla
	 * @param type
	 * @param x
	 * @param y
	 * @return
	 * @throws SlickException
	 */
	public static Enemy createEnemy(EnemyType type, float x, float y, SpriteManager spriteManager) {
		
		Enemy enemy = null;
		
		switch (type) {
		
		case SMALL_ENEMY:
			enemy = new SmallEnemy(x, y, -50f);
			break;
		case SHOOTER_ENEMY:
			enemy = new ShooterEnemy(x, y, -50f, BulletDirection.UP);
			((ShooterEnemy) enemy).setEnemies(spriteManager.getEnemies());
			break;
		case STONE:
			enemy = new Stone(x, y, -50f);
			break;
		case BIG_ENEMY:
			enemy = new BigEnemy(x, y, -100f);
			break;
		case PURSUER_ENEMY:
			enemy = new PursuerEnemy(x, y, -100f);
			((PursuerEnemy) enemy).setShip(spriteManager.getShip());
			break;
		case STATIC_SHOOTER_ENEMY:
			enemy = new StaticShooterEnemy(x, y, -100f, BulletDirection.LEFT);
			((StaticShooterEnemy) enemy).setEnemies(spriteManager.getEnemies());
		default:
			break;
		}
		
		return enemy;
	}
	
	/**
	 * Crea un enemigo que aparece en la parte derecha de la pantalla
	 * @param type
	 * @param y
	 * @return
	 * @throws SlickException
	 */
	public static Enemy createEnemy(EnemyType type, float y, SpriteManager spriteManager) {
		
		return createEnemy(type, 1000, y, spriteManager);
	}
}
