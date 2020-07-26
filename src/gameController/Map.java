package gameController;

import java.util.ArrayList;


import game.*;

public class Map {
	protected MapItem[][] map;
	private int numberRooms;
	private MapItem[][] visibilityByRoom;
	protected ArrayList<Door> doors;

	
	
	public Map() {
		map = new MapItem[28][37];
		numberRooms = 34;
		visibilityByRoom = new MapItem[34][120];
		doors = new ArrayList<Door>();
	}
	
	public Map(int n, int m) {
		map = new MapItem[n][m];
		numberRooms = 0;
		visibilityByRoom = null;
		doors = new ArrayList<Door>();
	}
	
	public boolean isThereABlockX(int x, int y1, int y2) {
		boolean obstacle = false;
		if (y1 < y2) {
			for(int i=y1; i<y2; i++) {
				if (!map[x][i].isAccessible()) {
					obstacle = true;
				}
			}
		return obstacle;
		}
		else {
			for(int i=y2; i<y1; i++) {
				if (!map[x][i].isAccessible()) {
					obstacle = true;
				}
			}
		return obstacle;
		}
			
	}
	
	public boolean isThereABlockY(int y, int x1, int x2) {
		boolean obstacle = false;
		if (x1 < x2) {
			for(int i=x1; i<x2; i++) {
				if (!map[i][y].isAccessible()) {
					obstacle = true;
				}
			}
		return obstacle;
		}
		else {
			for(int i=x2; i<x1; i++) {
				if (!map[i][y].isAccessible()) {
					obstacle = true;
				}
			}
		return obstacle;
		}
			
	}
		
	
	
	public boolean isACreature(int x, int y) {
		return map[x][y].isCreature();
	}
	
	
	public void buildDefautMap() {
		//Desenho das paredes do tabuleiro padrão de Hero Quest
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) {
				map[i][j] = new EmptySpace(i,j);
			}
		}
		
		for(int i=2; i<35; i++) {
			if(i != 18 && i != 19) {
				map[2][i] = new Wall(2,i);
			}
		}
		for(int i=2; i<26; i++ ) {
			if(i!= 13 && i!=14) map[i][2] = new Wall(i, 2);
		}
		
		for(int i=2; i<26; i++ ) {
			if(i!= 13 && i!=14) map[i][7] = new Wall(i, 7);
		}
		
		for(int i=2; i<26; i++ ) {
			if(i!= 13 && i!=14) map[i][13] = new Wall(i, 13);
		}
		
		for(int i=2; i<26; i++ ) {
			if(i!= 13 && i!=14) map[i][34] = new Wall(i, 34);
		}
		
		map[3][17] = new Wall(3,17);
		map[3][20] = new Wall(3,20);
		map[3][24] = new Wall(3,24);
		map[3][29] = new Wall(3,29);
		map[4][17] = new Wall(4,17);
		map[4][20] = new Wall(4,20);
		map[4][24] = new Wall(4,24);
		map[4][29] = new Wall(4,29);
		map[5][17] = new Wall(5,17);
		map[5][20] = new Wall(5,20);
		map[5][24] = new Wall(5,24);
		map[5][29] = new Wall(5,29);
		for(int i=2; i<14;i++) {
			map[6][i] = new Wall(6,i);
		}
		map[6][17] = new Wall(6,17);
		map[6][20] = new Wall(6,20);
		map[6][24] = new Wall(6,24);
		map[6][29] = new Wall(6,29);
		map[7][17] = new Wall(7,17);
		map[7][20] = new Wall(7,20);
		for(int i = 24; i<35;i++) {
			map[7][i] = new Wall(7,i);
		}
		map[8][17] = new Wall(8,17);
		map[8][20] = new Wall(8,20);
		map[8][24] = new Wall(8,24);
		map[8][29] = new Wall(8,29);
		for(int i=14; i<25; i++ ) {
			if(i!= 18 && i!=19) map[9][i] = new Wall(9, i);
		}
		map[9][29] = new Wall(24,29);
		map[10][24] = new Wall(10,24);
		map[10][29] = new Wall(10,29);
		map[11][24] = new Wall(11,24);
		map[11][29] = new Wall(11,29);
		for(int i =2; i<14; i++) map[12][i] = new Wall(12,i);
		for(int i =24; i<35; i++) map[12][i] = new Wall(12,i);
		for(int i =2; i<14; i++) map[15][i] = new Wall(15,i);
		for(int i =24; i<35; i++) map[15][i] = new Wall(15,i);
		for(int i = 8; i<18; i++) map[19][i] = new Wall(19,i);
		for(int i =20; i<26; i++) map[19][i] = new Wall(19,i);
		for(int i = 2; i<8; i++) map[20][i] = new Wall(20,i);
		for(int i =15; i<20; i++) map[i][10] = new Wall(i,10);
		for(int i = 19; i<25; i++) map[i][17] = new Wall(i,17);
		for(int i = 19; i<25; i++) map[i][20] = new Wall(i,20);
		for(int i = 19; i<25; i++) map[i][25] = new Wall(i,25);
		for(int i = 15; i<19; i++) map[i][24] = new Wall(i,24);
		for(int i = 16; i<21; i++) map[i][28] = new Wall(i,28);
		for(int i = 20; i<25; i++) map[i][29] = new Wall(i,29);
		for(int i = 30; i<35; i++) map[20][i] = new Wall(20,i);
		map[21][26] = new Wall(21,26);
		map[21][27] = new Wall(21,27);
		map[20][27] = new Wall(20,27);
		for(int i = 2; i<35; i++) {
			if(i!= 18 && i!= 19) map[25][i] = new Wall(25,i);
		}
		for(int i=15;i<23;i++) {
			map[11][i] = new Wall(11,i);
			map[17][i] = new Wall(17,i);
		}
		for(int i=12;i<17; i++) {
			map[i][15] = new Wall(i, 15);
			map[i][22] = new Wall(i, 22);
		}
		
		//Adição das portas
		Door door = new Door(6,5);
		doors.add(door);
		map[6][5] = door;
		Door door1 = new Door(2,10);
		doors.add(door1);
		map[2][10] = door1;
		Door door2 = new Door(3,17);
		doors.add(door2);
		map[3][17] = door2;
		Door door3 = new Door(8,7);
		doors.add(door3);
		map[8][7] = door3;
		Door door4 = new Door(12,10);
		doors.add(door4);
		map[12][10] = door4;
		Door door5 = new Door(15,4);
		doors.add(door5);
		map[15][4] = door5;
		Door door6 = new Door(18,7);
		doors.add(door6);
		map[18][7] = door6;
		Door door7 = new Door(17,10);
		doors.add(door7);
		map[17][10] = door7;
		Door door8 = new Door(19,12);
		doors.add(door8);
		map[19][12] = door8;
		Door door9 = new Door(24,7);
		doors.add(door9);
		map[24][7] = door9;
		Door door10 = new Door(23, 13);
		doors.add(door10);
		map[23][13] = door10;
		Door door11 = new Door(17,19);
		doors.add(door11);
		map[17][19] = door11;
		Door door12 = new Door(24,20);
		doors.add(door12);
		map[24][20] = door12;
		Door door13 = new Door(4,24);
		doors.add(door13);
		map[4][24] = door13;
		Door door14 = new Door(8,24);
		doors.add(door14);
		map[8][24] = door14;
		Door door15 = new Door(20,25);
		doors.add(door15);
		map[20][25] = door15;
		Door door16 = new Door(24,29);
		doors.add(door16);
		map[24][29] = door16;
		Door door17 = new Door(16,28);
		doors.add(door17);
		map[16][28] = door17;
		Door door18 = new Door(4,29);
		doors.add(door18);
		map[4][29] = door18;
		Door door19 = new Door(7,31);
		doors.add(door19);
		map[7][31] = door19;
		Door door20 = new Door(12,33);
		doors.add(door20);
		map[12][33] = door20;
		Door door21 = new Door(20,33);
		doors.add(door21);
		map[20][33] = door21;	
	}
	
	public ArrayList<Door> getDoors(){
		return doors;
	}
	
	public void buildMapFromFile() {
		
	}
	
	public MapItem foundSkeletonNearby(Hero hero) {
		int x = hero.getPositionX();
		int y = hero.getPositionY();
		if (x-1 >= 0 && map[x-1][y].toString() == " S "){return map[x-1][y];}
		else if(x-1 >= 0 && y+1 < getMapHeight() && map[x-1][y+1].toString() == " S ") {return map[x-1][y+1];}
		else if(y+1 < getMapHeight() && map[x][y+1].toString() == " S ") {return map[x][y+1];} 
		else if(x+1 < getMapWidth() && y+1 < getMapHeight() && map[x+1][y+1].toString() == " S ") {return map[x+1][y+1];} 
		else if(x+1 < getMapWidth() && map[x+1][y].toString() == " S ") {return map[x+1][y];} 
		else if(x+1 < getMapWidth() && y-1 >= 0 && map[x+1][y-1].toString() == " S ") {return map[x+1][y-1];} 
		else if(y-1 >= 0 && map[x][y-1].toString() == " S ") {return map[x][y-1];}
		else if(x-1 >= 0 && y-1 >= 0 && map[x-1][y-1].toString() == " S ") {return map[x-1][y-1];}
		else {return null;}
	}
	
	public MapItem foundSkeletonWizardNearby(Hero hero) {
		int x = hero.getPositionX();
		int y = hero.getPositionY();
		if (x-1 >= 0 && map[x-1][y].toString() == " R "){return map[x-1][y];}
		else if(x-1 >= 0 && y+1 < getMapHeight() && map[x-1][y+1].toString() == " R ") {return map[x-1][y+1];}
		else if(y+1 < getMapHeight() && map[x][y+1].toString() == " R ") {return map[x][y+1];} 
		else if(x+1 < getMapWidth() && y+1 < getMapHeight() && map[x+1][y+1].toString() == " R ") {return map[x+1][y+1];} 
		else if(x+1 < getMapWidth() && map[x+1][y].toString() == " R ") {return map[x+1][y];} 
		else if(x+1 < getMapWidth() && y-1 >= 0 && map[x+1][y-1].toString() == " R ") {return map[x+1][y-1];} 
		else if(y-1 >= 0 && map[x][y-1].toString() == " R ") {return map[x][y-1];}
		else if(x-1 >= 0 && y-1 >= 0 && map[x-1][y-1].toString() == " R ") {return map[x-1][y-1];}
		else {return null;}
	}
	
	
	public MapItem foundGoblinNearby(Hero hero) {
		int x = hero.getPositionX();
		int y = hero.getPositionY();
		if (x-1 >= 0 && map[x-1][y].toString() == " G "){return map[x-1][y];}
		else if(x-1 >= 0 && y+1 < getMapHeight() && map[x-1][y+1].toString() == " G ") {return map[x-1][y+1];}
		else if(y+1 < getMapHeight() && map[x][y+1].toString() == " G ") {return map[x][y+1];} 
		else if(x+1 < getMapWidth() && y+1 < getMapHeight() && map[x+1][y+1].toString() == " G ") {return map[x+1][y+1];} 
		else if(x+1 < getMapWidth() && map[x+1][y].toString() == " G ") {return map[x+1][y];} 
		else if(x+1 < getMapWidth() && y-1 >= 0 && map[x+1][y-1].toString() == " G ") {return map[x+1][y-1];} 
		else if(y-1 >= 0 && map[x][y-1].toString() == " G ") {return map[x][y-1];}
		else if(x-1 >= 0 && y-1 >= 0 && map[x-1][y-1].toString() == " G ") {return map[x-1][y-1];}
		else {return null;}
	}
	
	public MapItem getItem(int x, int y) {
		return map[x][y];
	}
	
	public int getMapWidth() {
		return map.length;
	}

	public int getMapHeight() {
		return map[0].length;
	}
	
	public void printMap() {
		for(int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				System.out.print(map[i][j].toString());
			}
			System.out.printf("\n");
		}
	}
	
	public boolean isPositionEmpty(int x, int y) {
		if (map[x][y] instanceof EmptySpace) return true;
		else return false;
	}
	
	public void removeFromMap(int x, int y) {
		EmptySpace vazio = new EmptySpace(x,y);
		map[x][y] = vazio;
	}
}
