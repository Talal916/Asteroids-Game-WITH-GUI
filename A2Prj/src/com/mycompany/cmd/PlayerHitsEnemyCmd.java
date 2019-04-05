package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class PlayerHitsEnemyCmd extends Command 
{
	private GameWorld gw;

	public PlayerHitsEnemyCmd(GameWorld gw)
	{
		super("Player runs into enemy ship");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.NPSStrikePS();
		System.out.println("Player hits enemy ship");
	}
}
