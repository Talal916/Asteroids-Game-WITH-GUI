package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AsteroidHitsAsteroidCmd extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command to remove two asteroids that collide
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public AsteroidHitsAsteroidCmd(GameWorld gw)
	{
		super("Asteroid hits another asteroid");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.asteroidCollision();
		System.out.println("Asteroid hits another asteroid");
	}
}
