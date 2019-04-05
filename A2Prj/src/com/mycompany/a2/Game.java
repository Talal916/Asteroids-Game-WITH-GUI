package com.mycompany.a2;

import com.codename1.ui.Form; 
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.Form; 
import com.codename1.ui.Label; 

import com.codename1.ui.CheckBox; 
import com.codename1.ui.Container;

import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.cmd.*;

import java.lang.String;


public class Game extends Form {
	
	private GameWorld gw;
	private boolean waitGameEnd = false;
	private boolean returnGame = false;
	
	private PointsView pv;
	private MapView mv;
	private static String versionTitle = "Asteroids Game"; //change for app store uploads
	
	//declare pointsView here
	//delete comment when done
	
	public Game()
	{
		
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView();
		
		
		this.setLayout(new BorderLayout());
		this.setScrollable(false);
		
		gw.setGWHeight(mv.getMapHeight());
		gw.setGWWidth(mv.getMapWidth());
		
		
		System.out.println("Height = " + gw.getGWHeight());
		System.out.println("Width = " + gw.getGWWidth());	
		
		gw.addObserver(mv);
		gw.addObserver(pv);
		
		setUp();
		
		this.addComponent(BorderLayout.CENTER, mv);
		this.addComponent(BorderLayout.NORTH, pv);
		
		
		gw.init();
		this.show();
		
		
		//play(); deprecated
		
	}
	
	private void setUp() {
			setUPMenu();
			setUpCMD();
			
	}

	private void setUpCMD() {
		Container mainContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		mainContainer.setScrollableY(false);
		Label commandLabel = new Label("Commands");
		mainContainer.add(commandLabel);
		
		AddAsteroidCmd astButton = new AddAsteroidCmd(gw);
		buttonObj addAsteroid = new buttonObj(astButton);
		mainContainer.add(addAsteroid);

 		AddEnemyShipCmd enemyButton = new AddEnemyShipCmd(gw);
		buttonObj addEnemy = new buttonObj(enemyButton);
		mainContainer.add(addEnemy);
		
		AddSpaceStationCmd ssButton = new AddSpaceStationCmd(gw);
		buttonObj addStation = new buttonObj(ssButton);
		mainContainer.add(addStation);
 		
 		AddPlayerCmd addPlayer = new AddPlayerCmd(gw);
		buttonObj playerButton = new buttonObj(addPlayer);
		mainContainer.add(playerButton);
 		
 		AccelerateCmd accelerateCommand = new AccelerateCmd(gw);
		buttonObj accelButton = new buttonObj(accelerateCommand);
		addKeyListener('w', accelerateCommand);
		addKeyListener(-91, accelerateCommand);
		mainContainer.add(accelButton);
 		
 		DecelerateCmd deccelerateCommand = new DecelerateCmd(gw);
		buttonObj decelButton= new buttonObj(deccelerateCommand);
		addKeyListener('s', deccelerateCommand);
		addKeyListener(-92, deccelerateCommand);
		mainContainer.add(decelButton);
 		
 		TurnLeftCmd leftCommand = new TurnLeftCmd(gw);
		buttonObj leftButton = new buttonObj(leftCommand);
		addKeyListener('a', leftCommand);
		addKeyListener(-93, leftCommand);
		mainContainer.add(leftButton);
 		
		TurnRightCmd rightCommand = new TurnRightCmd(gw);
		buttonObj rightButton = new buttonObj(rightCommand);
		addKeyListener('d', rightCommand);
		addKeyListener(-94, rightCommand);
		mainContainer.add(rightButton);
		
		LauncherTurnLeftCmd launcherLeftCMD = new LauncherTurnLeftCmd(gw);
		buttonObj launcherLeftButton = new buttonObj(launcherLeftCMD);
		addKeyListener(44, launcherLeftCMD);
		mainContainer.add(launcherLeftButton);
		
		LauncherTurnRightCmd launcherRightCMD = new LauncherTurnRightCmd(gw);
		buttonObj launcherRightButton = new buttonObj(launcherRightCMD);
		addKeyListener(46, launcherRightCMD);
		mainContainer.add(launcherRightButton);
		
		FirePlayerMissileCmd fireCommand = new FirePlayerMissileCmd(gw);
		buttonObj fireButton = new buttonObj(fireCommand);
		addKeyListener(-90, fireCommand);
		mainContainer.add(fireButton);
		
		FireEnemyMissileCmd enemyFireCommand = new FireEnemyMissileCmd(gw);
		buttonObj enemyFireButton = new buttonObj(enemyFireCommand);
		mainContainer.add(enemyFireButton);
		
		JumpCmd jumpCommand = new JumpCmd(gw);
		buttonObj jumpButton = new buttonObj(jumpCommand);
		addKeyListener('j', jumpCommand);
		mainContainer.add(jumpButton);
		
		ReloadCmd reloadCommand = new ReloadCmd(gw);
		buttonObj reloadButton = new buttonObj(reloadCommand);
		addKeyListener('r', reloadCommand);
		mainContainer.add(reloadButton);
		
		MissileKillsAsteroidCmd pShootAstCMD = new MissileKillsAsteroidCmd(gw);
		buttonObj pShootAstButton = new buttonObj(pShootAstCMD);
		mainContainer.add(pShootAstButton);
		
		MissileKillsEnemyCmd pShootEnemyCommand = new MissileKillsEnemyCmd(gw);
		buttonObj playerShootsEnemyButton = new buttonObj(pShootEnemyCommand);
		mainContainer.add(playerShootsEnemyButton);
		
		EnemyMissileKillsPlayerCmd enemyShootPlayerCommand = new EnemyMissileKillsPlayerCmd(gw);
		buttonObj enemyShootsPlayerButton = new buttonObj(enemyShootPlayerCommand);
		mainContainer.add(enemyShootsPlayerButton);
		
		PlayerHitsAsteroidCmd playerHitAsteroidCommand = new PlayerHitsAsteroidCmd(gw);
		buttonObj pAstCollisionButton = new buttonObj(playerHitAsteroidCommand);
		mainContainer.add(pAstCollisionButton);
		
		PlayerHitsEnemyCmd pEnemyCollideCommand = new PlayerHitsEnemyCmd(gw);
		buttonObj pEnemyCollideButton = new buttonObj(pEnemyCollideCommand);
		mainContainer.add(pEnemyCollideButton);
		
		AsteroidHitsAsteroidCmd astCollisionCommand = new AsteroidHitsAsteroidCmd(gw);
		buttonObj astCollisionButton = new buttonObj(astCollisionCommand);
		mainContainer.add(astCollisionButton);
		
		AsteroidHitsEnemyCmd eAstCollisionCommand = new AsteroidHitsEnemyCmd(gw);
		buttonObj eAstCollisionButton = new buttonObj(eAstCollisionCommand);
		mainContainer.add(eAstCollisionButton);
		
		TickCmd clockCommand = new TickCmd(gw);
		buttonObj clockButton = new buttonObj(clockCommand);
		mainContainer.add(clockButton);
		
		this.addComponent(BorderLayout.WEST, mainContainer);
		
	}

	private void setUPMenu() {
			Toolbar menu = new Toolbar();
			this.setToolbar(menu);
			menu.setTitle(versionTitle);
			NewGameCmd newGame = new NewGameCmd();
			menu.addCommandToSideMenu(newGame);
			
			SaveCmd saveCommand = new SaveCmd();
			menu.addCommandToSideMenu(saveCommand);
			
			UndoCmd undoCommand = new UndoCmd();
			menu.addCommandToSideMenu(undoCommand);
			
			CheckBox soundOn = new CheckBox("Sound");
			SoundCmd soundCommand = new SoundCmd(gw, soundOn);
			soundOn.setCommand(soundCommand);
			menu.addCommandToSideMenu(soundCommand);
			
			AboutCmd aboutCommand = new AboutCmd();
			menu.addCommandToSideMenu(aboutCommand);
			
			QuitCmd quit = new QuitCmd();
			menu.addCommandToSideMenu(quit);
			
			
	}

	private void play() //deprecated as of a2
	{
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				
				
				
				if(!sCommand.equals(null) && sCommand.length() > 0 && !gw.isEndGame()) //&& !endGame
				{
					returnGame = true;
					if(sCommand.charAt(0) == 'q')
					{
						waitGameEnd = true;
						System.out.println("Are you sure you want to quit without saving? (y/n)");
					}
					if(waitGameEnd)
						
						switch(sCommand.charAt(0))
						{
						case 'y':
							System.out.println("Exiting the Game Now!");
							System.exit(0);
							break;
						case 'n':
							waitGameEnd = false;
							System.out.println("Returning to Game");
							returnGame = false;
							break;
						}
					if(!waitGameEnd && returnGame)
					{	
						switch (sCommand.charAt(0))
						{
		
							case 'a': // add a new asteroid to the world 
								//method call to add asteroid
								gw.addObj('a');
								break;
							case 'y':
								//method call to add NPS to world
								gw.addObj('y');
								break;
							case 'b':
								//method call to add a new blinking space station to the world
								gw.addObj('b');
								break;
							case 's':
								//method call to add a PS to the world
								gw.addObj('s');
								break;
							case 'i': 
								gw.changeSpeed('i');
								//increase the speed of the PS by a small amount
								break;
							case 'd':
								gw.changeSpeed('d');
								//decrease the speed of the PS by a small amount, but not negative
								break;
							case 'l':
								gw.turnPS('l');
								//turn PS left by a small amount counter clockwise
								break;
							case 'r':
								gw.turnPS('r');
								//turn PS right by a small amount clock wise 
								break;
							case '>': 
								gw.turnML(0);
								//controls direction of PS's missile launcher
								//by revolving about center of PS in c.c direction
								break;
							case 'f':
								gw.firePMissile();
								//fire missile from front of PS
								//if no missiles remaining, display err message
								break;
							case 'L': 
								gw.fireEMissile();
								//launch a missile from front of NPS
								//if no missiles, display err msg
							case 'j':
								gw.resetPos();
								//jumps PS to center of initial default position screen
								break;
							case 'n':
								gw.loadPMissile();
								//load new supply of missiles into PS
								break;
							case 'k':
								gw.removeAsteroid();
								//remove asteroid killed by PS and increment player score
								break;
							case 'e': //if letter e is input, eliminate NPS
								gw.eliminate(); 
								break;
							
							case 'E':
								gw.missileStrikePS();
								//remove missile and PS after a missile has struck a PS
								break;
							case 'c':
								gw.asteroidStrikePS();
								//PS crashed into asteroid, remove ship and asteroid 
								//decrement the count of lives left
								//game is over if no lives left
								break;
							case 'h':
								gw.NPSStrikePS();
								//the PS has hit a NPS, remove NPS and decrement lives left
								break;
							case 'x':
								gw.asteroidCollision();
								//two asteroids have collided
								//remove two asteroids from game
								break;
							case 'I':
								gw.asteroidStrikeNPS();
								//asteroid impacted NPS, remove both from game
								break;
							case 't':
								gw.clkTick();
								//game clock has ticked
								//updated game state variables
								break;
							case 'q': //deprecated
								waitGameEnd = true;
							case 'p':
								gw.printGameState();
								//print display of current game state values
								break;
							case 'm':
								gw.printGameMap();
								//print a map showing the current world state
								break;
							default:
								System.out.println("\nInput is invalid\n");
								break;
								
	
						} // switch (sCommand.chartAt(0))
					}// if(!waitGameEnd
				} //if sCommand not null
				if(gw.isEndGame())
				{
					System.out.println("Exiting Game Now!");
					System.exit(0);
				}
			} //public void actionPerformed(ActionEvent evt)
		} //myTextField.addActionListener(new ActionListener()
		
		); //myTextField.addActionListener(

	} // private void play()
}



