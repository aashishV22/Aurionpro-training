package com.aurionpro.hotel;
import com.aurionpro.menu.*;
import com.aurionpro.model.*;

public class ItalianHotel implements IHotel
{
	@Override
	public IMenu getMenu() 
	{
		return new ItalianMenu();
	}

}
