package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PlayerHitsAsteroidCmd extends Command 
{
	private GameWorld gw;
	
	/**
	 * Creates a button command for when player ship collides with asteroid
	 * @param gw - Reference to game world to invoke appropriate method
	 */
	public PlayerHitsAsteroidCmd(GameWorld gw)
	{
		super("Player collides with asteroid");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.asteroidStrikePS();
		System.out.println("Player collides with asteroid");
	}
}
