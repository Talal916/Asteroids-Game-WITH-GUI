package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.plaf.Border;


public class MapView extends Container implements Observer{

	TextArea gameText;
	
	public MapView()
	{
		this.getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.GREEN));
		this.setLayout(new BorderLayout());
		
		gameText = new TextArea();
		gameText.setEditable(false);
		gameText.getAllStyles().setBgTransparency(0);
		
		this.setWidth(1024);
		this.setHeight(768);
		
		this.add(BorderLayout.NORTH, gameText);
		
		
	}
	
	@Override
	public void update(Observable observable, Object data) {
		GameWorldProxy prox = (GameWorldProxy) data;
		IIterator iter = prox.getCollection().getIterator();
		
		String displayText = "";
		
		while(iter.hasNext())
		{
			displayText = displayText + iter.getNext().toString()+"\n";
		}
		gameText.setText(displayText);
		this.repaint();
		
	}
	
	public double getMapWidth()
	{
		double retval = (double) this.getWidth();
		
		return retval;
	}
	
	public double getMapHeight()
	{
		double retval = (double) this.getHeight();
	
		return retval;
		
		
	}

}
