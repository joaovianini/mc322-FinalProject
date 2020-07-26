package gameController;

import java.util.ArrayList;


import game.*;

public class Map {
	protected MapItem[][] map;
	private int numberRooms;
	private MapItem[][] visibilityByRoom;
	protected ArrayList<Door> doors;
	private Hero hero;

	public Map() {
		map = new MapItem[28][37];
		numberRooms = 34;
		visibilityByRoom = new MapItem[34][120];
		doors = new ArrayList<Door>();
		hero = null;
	}
	
	public Map(int n, int m) {
		map = new MapItem[n][m];
		numberRooms = 0;
		visibilityByRoom = null;
		doors = new ArrayList<Door>();
		hero = null;
	}

	public void addHero(Hero hero) {
		this.hero = hero;
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
		
	
	
	void printMapRooms() {
		for(int i=0; i<getMapWidth(); i++) {
			for(int j=0; j<getMapHeight();j++) {
				System.out.printf(" %d ", map[i][j].getRoom());
			}
			System.out.println();
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
		Door door = new Door(6,5,1,3);
		doors.add(door);
		map[6][5] = door;
		Door door1 = new Door(2,10,25,2);
		doors.add(door1);
		map[2][10] = door1;
		Door door2 = new Door(3,17,5,26);
		doors.add(door2);
		map[3][17] = door2;
		Door door3 = new Door(8,7,3,4);
		doors.add(door3);
		map[8][7] = door3;
		Door door4 = new Door(12,10,4,27);
		doors.add(door4);
		map[12][10] = door4;
		Door door5 = new Door(15,4,6,27);
		doors.add(door5);
		map[15][4] = door5;
		Door door6 = new Door(18,7,6,7);
		doors.add(door6);
		map[18][7] = door6;
		Door door7 = new Door(17,10,7,8);
		doors.add(door7);
		map[17][10] = door7;
		Door door8 = new Door(19,12,8,10);
		doors.add(door8);
		map[19][12] = door8;
		Door door9 = new Door(24,7,9,10);
		doors.add(door9);
		map[24][7] = door9;
		Door door10 = new Door(23, 13,10,11);
		doors.add(door10);
		map[23][13] = door10;
		Door door11 = new Door(17,19,0,32);
		doors.add(door11);
		map[17][19] = door11;
		Door door12 = new Door(24,20,28,12);
		doors.add(door12);
		map[24][20] = door12;
		Door door13 = new Door(4,24,17,18);
		doors.add(door13);
		map[4][24] = door13;
		Door door14 = new Door(8,24,17,20);
		doors.add(door14);
		map[8][24] = door14;
		Door door15 = new Door(20,25,12,13);
		doors.add(door15);
		map[20][25] = door15;
		Door door16 = new Door(24,29,15,16);
		doors.add(door16);
		map[24][29] = door16;
		Door door17 = new Door(16,28,13,14);
		doors.add(door17);
		map[16][28] = door17;
		Door door18 = new Door(4,29,18,19);
		doors.add(door18);
		map[4][29] = door18;
		Door door19 = new Door(7,31,19,21);
		doors.add(door19);
		map[7][31] = door19;
		Door door20 = new Door(12,33,21,29);
		doors.add(door20);
		map[12][33] = door20;
		Door door21 = new Door(20,33,14,16);
		doors.add(door21);
		map[20][33] = door21;	
	}
	
	public ArrayList<Door> getDoors(){
		return doors;
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
		setVisibility();
		for(int i=0; i<map.length; i++) {
			for (int j=0; j<map[i].length; j++) {
				if(map[i][j].isVisible())
				System.out.print(map[i][j].toString());
				else {
					System.out.print("###");
				}
			}
			System.out.printf("\n");
		}
	}
	
	public void setVisibility() {
		determineDefaultRooms();
		int x, y, hx, hy, hr;
		hx = hero.getPositionX();
		hy = hero.getPositionY();
		hr = hero.getRoom();
		for(int i=0; i<visibilityByRoom.length; i++) {
			for(int j=0; j<visibilityByRoom[0].length;j++) {
				if(i != hr) {
					visibilityByRoom[i][j].setVisible(false);
				}
			}
		}
		for(int j=0; j<visibilityByRoom[0].length; j++) {
			if(visibilityByRoom[hr][j].ExistsOnMap()) {
				x = visibilityByRoom[hr][j].getPositionX();
				y = visibilityByRoom[hr][j].getPositionY();
				if(map[x][y].isAccessible() && !isThereABlockX(hx,hy,y) && !isThereABlockY(hy,hx,x)) {
					map[x][y].setVisible(true);
				}
				else if(hx>x && hy>y && x!= getMapWidth()-1 && y!= getMapHeight()-1) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y+1) && !isThereABlockY(hy,hx,x+1)) {
						map[x][y].setVisible(true);
					}
				}
				else if(hx>x && hy<y && x!= getMapWidth()-1 && y!=0) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y-1) && !isThereABlockY(hy,hx,x+1)) {
						map[x][y].setVisible(true);
					}
				}
				else if(hx<x && hy>y && y!= getMapHeight()-1&& x!=0) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y+1) && !isThereABlockY(hy,hx,x-1)) {
						map[x][y].setVisible(true);
					}
				}
				else if(hx<x && hy<y && y!=0 && x!=0 ) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y-1) && !isThereABlockY(hy,hx,x-1)) {
						map[x][y].setVisible(true);
					}
				}
				else if(hx==x && hy > y && y!= getMapHeight()-1) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y+1)){
						map[x][y].setVisible(true);
					}
				}
				else if(hx==x && hy < y && y<0) {
					if(!map[x][y].isAccessible() && !isThereABlockX(hx,hy,y-1)){
						map[x][y].setVisible(true);
					}
				}
				else if(hx<x && hy==y && x!=0) {
					if(!map[x][y].isAccessible() && !isThereABlockY(hy,hx,x-1)){
						map[x][y].setVisible(true);
					}
				}
				else if(hx<x && hy>y && x!= getMapWidth()-1) {
					if(!map[x][y].isAccessible() && !isThereABlockY(hy,hx,x+1)){
						map[x][y].setVisible(true);
					}
				}
				else if(hx==x && hy==y) {
						map[x][y].setVisible(true);
				}
				else {
					visibilityByRoom[hr][j].setVisible(false);
				}
		}
			
		}
	}

	public void determineDefaultRooms() {
		int i, j, k;
		if (getMapWidth() != 28 || getMapHeight() != 37) {
			return;
		}
		k=0;
		for(i = 11; i<18; i++) {
			for(j= 15; j<23; j++) {
				map[i][j].setRoom(0);
				visibilityByRoom[0][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[0][k] = new MapItem();
			k++;
		}
		k=0;
		for(i = 2; i<7; i++) {
			for(j=2; j<8; j++) {
				map[i][j].setRoom(1);
				visibilityByRoom[1][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[1][k] = new MapItem();
			k++;
		}
		k=0;
		for(i = 2; i<7; i++) {
			for(j=7;j<14;j++) {
				map[i][j].setRoom(2);
				visibilityByRoom[2][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[2][k] = new MapItem();
			k++;
		}
		k=0;
		for(i = 6; i<13; i++) {
			for(j=2;j<8;j++) {
				map[i][j].setRoom(3);
				visibilityByRoom[3][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[3][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=6; i<13; i++) {
			for(j=7;j<14;j++) {
				map[i][j].setRoom(4);
				visibilityByRoom[4][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[4][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=2; i<10; i++) {
			for(j=13;j<18;j++) {
				map[i][j].setRoom(5);
				visibilityByRoom[5][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[5][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=15; i<21; i++) {
			for(j=2;j<8;j++) {
				map[i][j].setRoom(6);
				visibilityByRoom[6][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[6][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=15; i<20; i++) {
			for(j=7;j<11;j++) {
				map[i][j].setRoom(7);
				visibilityByRoom[7][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[7][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=15; i<20; i++) {
			for(j=10;j<14;j++) {
				map[i][j].setRoom(8);
				visibilityByRoom[8][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[8][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=20; i<26; i++) {
			for(j=2;j<8;j++) {
				map[i][j].setRoom(9);
				visibilityByRoom[9][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[9][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=19; i<26; i++) {
			for(j=7;j<14;j++) {
				map[i][j].setRoom(10);
				visibilityByRoom[10][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[10][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=19; i<26; i++) {
			for(j=13;j<18;j++) {
				map[i][j].setRoom(11);
				visibilityByRoom[11][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[11][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=19; i<26; i++) {
			for(j=20;j<26;j++) {
				map[i][j].setRoom(12);
				visibilityByRoom[12][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[12][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=15; i<20; i++) {
			for(j=24; j<29;j++) {
				map[i][j].setRoom(13);
				visibilityByRoom[13][k] = map[i][j];
				k++;
			}
		}
		map[20][25].setRoom(13);
		visibilityByRoom[13][k] = map[20][25];
		k++;
		map[20][26].setRoom(13);
		visibilityByRoom[13][k] = map[20][26];
		k++;
		map[20][27].setRoom(13);
		visibilityByRoom[13][k] = map[20][27];
		k++;
		map[20][28].setRoom(13);
		visibilityByRoom[13][k] = map[20][28];
		k++;
		map[21][25].setRoom(13);
		visibilityByRoom[13][k] = map[21][25];
		k++;
		map[21][26].setRoom(13);
		visibilityByRoom[13][k] = map[21][26];
		k++;
		map[21][27].setRoom(13);
		visibilityByRoom[13][k] = map[21][27];
		while(k<120) {
			visibilityByRoom[13][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=15; i<21; i++) {
			for(j=28; j<35;j++) {
				map[i][j].setRoom(14);
				visibilityByRoom[14][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[14][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=21; i<26; i++) {
			for(j=24; j<30;j++) {
				map[i][j].setRoom(15);
				visibilityByRoom[15][k] = map[i][j];
				k++;
			}
		}
		map[20][27].setRoom(15);
		visibilityByRoom[15][k] = map[15][27];
		k++;
		map[20][28].setRoom(15);
		visibilityByRoom[15][k] = map[20][28];
		k++;
		map[20][29].setRoom(15);
		visibilityByRoom[15][k] = map[20][29];
		while(k<120) {
			visibilityByRoom[15][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=20; i<26; i++) {
			for(j=29; j<35;j++) {
				map[i][j].setRoom(16);
				visibilityByRoom[16][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[16][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=2; i<10; i++) {
			for(j=20; j<25;j++) {
				map[i][j].setRoom(17);
				visibilityByRoom[17][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[17][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=2; i<8; i++) {
			for(j=24; j<30;j++) {
				map[i][j].setRoom(18);
				visibilityByRoom[18][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[18][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=2; i<8; i++) {
			for(j=29; j<35;j++) {
				map[i][j].setRoom(19);
				visibilityByRoom[19][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[19][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=7; i<13; i++) {
			for(j=24; j<30;j++) {
				map[i][j].setRoom(20);
				visibilityByRoom[20][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[20][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=7; i<13; i++) {
			for(j=29; j<35;j++) {
				map[i][j].setRoom(21);
				visibilityByRoom[21][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[21][k] = new MapItem();
			k++;
		}
		//corredores
		k=0;
		for(i=0; i<28; i++) {
			for(j=0;j<3; j++) {
				if(j!=3) {
					map[i][j].setRoom(22);
					visibilityByRoom[22][k] = map[i][j];
					k++;
				}
				else if((i!=0) && (i!=1) && (i!=26) && (i!=27)) {
					map[i][j].setRoom(22);
					visibilityByRoom[22][k] = map[i][j];
					k++;
				}
			}
		}
		while(k<120) {
			visibilityByRoom[22][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=25;i<28;i++) {
			for(j=0;j<37;j++) {
				if(i!=25) {
					map[i][j].setRoom(23);
					visibilityByRoom[23][k] = map[i][j];
					k++;
				}
				else if(j!= 0 && j!=1 && j !=35 && j!= 36) {
					map[i][j].setRoom(23);
					visibilityByRoom[23][k] = map[i][j];
					k++;
				}
			}
		}
		while(k<120) {
			visibilityByRoom[23][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=0; i<28; i++) {
			for(j=34;j<37; j++) {
					if(j!=34) {
					map[i][j].setRoom(24);
						visibilityByRoom[24][k] = map[i][j];
						k++;
				}
					else if((i!=0) && (i!=1) && (i!=26) && (i!=27)) {
					map[i][j].setRoom(24);
					visibilityByRoom[24][k] = map[i][j];
					k++;
					}
			}	
		}
		while(k<120) {
			visibilityByRoom[24][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=0;i<3;i++) {
			for(j=0;j<37;j++) {
				if(i!=3) {
					map[i][j].setRoom(25);
					visibilityByRoom[25][k] = map[i][j];
					k++;
				}
				else if(j!= 0 && j!=1 && j !=35 && j!= 36) {
					map[i][j].setRoom(25);
					visibilityByRoom[25][k] = map[i][j];
					k++;
				}
			}
		}
		while(k<120) {
			visibilityByRoom[25][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=2;i<10;i++) {
			for(j=17;j<21;j++) {
				map[i][j].setRoom(26);
				visibilityByRoom[26][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[26][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=12;i<16;i++) {
			for(j=2;j<14;j++) {
				map[i][j].setRoom(27);
				visibilityByRoom[27][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[27][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=19;i<26;i++) {
			for(j=17;j<21;j++) {
				map[i][j].setRoom(28);
				visibilityByRoom[28][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[28][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=12;i<16;i++) {
			for(j=24;j<35;j++) {
				map[i][j].setRoom(29);
				visibilityByRoom[29][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[29][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=9;i<12;i++) {
			for(j=14;j<25;j++) {
				map[i][j].setRoom(30);
				visibilityByRoom[30][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[30][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=9;i<20;i++) {
			for(j=13;j<15;j++) {
				map[i][j].setRoom(31);
				visibilityByRoom[31][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[31][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=17;i<20;i++) {
			for(j=14;j<25;j++) {
				map[i][j].setRoom(30);
				visibilityByRoom[32][k] = map[i][j];
			k++;
			}
		}
		while(k<120) {
			visibilityByRoom[32][k] = new MapItem();
			k++;
		}
		k=0;
		for(i=9;i<20;i++) {
			for(j=22;j<24;j++) {
				map[i][j].setRoom(33);
					visibilityByRoom[33][k] = map[i][j];
				k++;
			}
		}
		while(k<120) {
			visibilityByRoom[33][k] = new MapItem();
			k++;
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
