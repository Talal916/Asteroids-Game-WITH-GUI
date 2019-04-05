package com.mycompany.cmd;

import com.codename1.ui.Command; 
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TickCmd extends Command 
{
	private GameWorld gw;

	public TickCmd(GameWorld gw)
	{
		super("Advance game clock");
		this.gw = gw;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		gw.clkTick();
		System.out.println("Advance game clock");
	}
}
