package com.aurionpro.model;

public class Cell 
{
	private MarkType mark;
	public Cell() {
		this.mark=MarkType.EMPTY;
	}
	public boolean isEmpty() 
	{
		return this.mark==MarkType.EMPTY;
	}
	
	public MarkType getMark() {
		return this.mark;
	}
	public void setMark(MarkType mark) throws CellAlreadyMarkedException 
	{
		if(isEmpty()) {
			this.mark=mark;
		}else 
		{
			throw new CellAlreadyMarkedException("Already Marked");
		}
	}
	@Override
	public String toString() {
		return  ""+mark;
	}
	
	
}
