package com.mycompany.cmd;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ReloadCmd extends Command 
{
	private GameWorld gw;
	

	public ReloadCmd(GameWorld gw)
	{
		super("Reload missiles");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.missileReload();
		System.out.println("Reload missiles");
	}
}
