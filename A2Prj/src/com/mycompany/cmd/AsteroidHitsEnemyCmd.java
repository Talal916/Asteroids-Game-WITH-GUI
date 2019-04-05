package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AsteroidHitsEnemyCmd extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to remove an asteroid that collides with enemy ship
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public AsteroidHitsEnemyCmd(GameWorld gw)
	{
		super("Asteroid hits enemy ship");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.asteroidStrikeNPS();
		System.out.println("Asteroid hits enemy ship");
	}
}
