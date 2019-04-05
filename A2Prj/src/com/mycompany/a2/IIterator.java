package com.mycompany.a2;

public interface IIterator {

	public boolean hasNext();
	
	public GameObject getNext();
	
	public GameObject getCurrent();
	
	public void remove();
	
	public void remove(GameObject gameObj);
	
	
}
