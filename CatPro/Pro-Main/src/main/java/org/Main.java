package org;

import api.service.ICatService;
import entity.cat.Cat;
import service.cat.CatService;

public class Main {
	public static void main(String[] args) {
		ICatService catService=new CatService();
		
		catService.create(new Cat(0, "Venera",15));
		catService.create(new Cat(1, "Luna",14));
		catService.create(new Cat(2, "Zet",17));
		
		Cat Venera=catService.getCat(0);
		Cat Luna=catService.getCat(1);
		Cat Zet=catService.getCat(2);
		
		catService.fight(Venera, Luna);
		catService.fight(Venera, Zet);
	}

	
	
	
	
	

}
