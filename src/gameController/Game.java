package gameController;

import java.security.SecureRandom;

import java.util.*;
import java.io.*;

import game.*;

public class Game {
	
	private static SecureRandom random = new SecureRandom();
	private ArrayList<Skeleton> skeletons;
	private ArrayList<SkeletonWizard> skeletonWizards;
	private ArrayList<Goblin> goblins;
	private Map map;
	private Die die;
	private boolean exit;
	private Scanner roll;
	private Scanner scan;
	private HeroType type; 
	private Hero hero;
	private EmptySpace emptySpace;
	
	
	
	public Game() {
		skeletons = new ArrayList<Skeleton>();
		skeletonWizards = new ArrayList<SkeletonWizard>();
		goblins = new ArrayList<Goblin>();
		map = null;
		die = new Die();
		exit = false;
		scan = new Scanner(System.in);
		hero = null;
		emptySpace = new EmptySpace();
	}
	
	private void moveMonsters() {
		moveSkeletons();
		moveSkeletonWizards();
		moveGoblins();
}
	private void moveGoblins() {
		int direcao, x, y;
		System.out.println("Numero de Goblins" + goblins.size());
		for (int i = 0; i< goblins.size(); i++) {
			x = goblins.get(i).getPositionX();
			y = goblins.get(i).getPositionY();
			direcao = random.nextInt(4);
			switch(direcao) {
			case 0://equivalente dir a
				if (y-1 >= 0  &&  map.isPositionEmpty(x,y-1)){
					map.map[x][y] = new EmptySpace(x,y);
					goblins.get(i).setPosition(x,y-1);
					map.map[x][y-1] = goblins.get(i);
				}
				break;
			case 1://equivalente dir w
				if (x-1 >= 0  &&  map.isPositionEmpty(x-1,y)){
					map.map[x][y] = new EmptySpace(x,y);
					goblins.get(i).setPosition(x-1, y);
					map.map[x-1][y] = goblins.get(i);
				}
				break;
			case 2://equivalente dir d
				if (y+1 < map.getMapHeight()  &&  map.isPositionEmpty(x, y+1)){
					map.map[x][y] = new EmptySpace(x,y);
					goblins.get(i).setPosition(x, y+1);
					map.map[x][y+1] = goblins.get(i);
				}
				break;
			case 3://equivalente dir s
				if (x+1 < map.getMapWidth()  &&  map.isPositionEmpty(x+1, y)){
					map.map[x][y] = new EmptySpace(x,y);
					goblins.get(i).setPosition(x+1, y);
					map.map[x+1][y] = goblins.get(i);
				}
				break;
			}
		}
	}
	
	
	
	private void moveSkeletonWizards() {
		int direcao, x, y;
		System.out.println("Numero de Skeleton Wizards" + skeletonWizards.size());
		for (int i = 0; i< skeletonWizards.size(); i++) {
			x = skeletonWizards.get(i).getPositionX();
			y = skeletonWizards.get(i).getPositionY();
			direcao = random.nextInt(4);
			switch(direcao) {
			case 0://equivalente dir a
				if (y-1 >= 0  &&  map.isPositionEmpty(x,y-1)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletonWizards.get(i).setPosition(x,y-1);
					map.map[x][y-1] = skeletonWizards.get(i);
				}
				break;
			case 1://equivalente dir w
				if (x-1 >= 0  &&  map.isPositionEmpty(x-1,y)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletonWizards.get(i).setPosition(x-1, y);
					map.map[x-1][y] = skeletonWizards.get(i);
				}
				break;
			case 2://equivalente dir d
				if (y+1 < map.getMapHeight()  &&  map.isPositionEmpty(x, y+1)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletonWizards.get(i).setPosition(x, y+1);
					map.map[x][y+1] = skeletonWizards.get(i);
				}
				break;
			case 3://equivalente dir s
				if (x+1 < map.getMapWidth()  &&  map.isPositionEmpty(x+1, y)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletonWizards.get(i).setPosition(x+1, y);
					map.map[x+1][y] = skeletonWizards.get(i);
				}
				break;
			}
		}
	}
	
	
	
	
	private void moveSkeletons() {
		int direcao, x, y;
		System.out.println("Numero de Skeletons" + skeletons.size());
		for (int i = 0; i< skeletons.size(); i++) {
			x = skeletons.get(i).getPositionX();
			y = skeletons.get(i).getPositionY();
			direcao = random.nextInt(4);
			switch(direcao) {
			case 0://equivalente dir a
				if (y-1 >= 0  &&  map.isPositionEmpty(x,y-1)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletons.get(i).setPosition(x,y-1);
					map.map[x][y-1] = skeletons.get(i);
				}
				break;
			case 1://equivalente dir w
				if (x-1 >= 0  &&  map.isPositionEmpty(x-1,y)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletons.get(i).setPosition(x-1, y);
					map.map[x-1][y] = skeletons.get(i);
				}
				break;
			case 2://equivalente dir d
				if (y+1 < map.getMapHeight()  &&  map.isPositionEmpty(x, y+1)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletons.get(i).setPosition(x, y+1);
					map.map[x][y+1] = skeletons.get(i);
				}
				break;
			case 3://equivalente dir s
				if (x+1 < map.getMapWidth()  &&  map.isPositionEmpty(x+1, y)){
					map.map[x][y] = new EmptySpace(x,y);
					skeletons.get(i).setPosition(x+1, y);
					map.map[x+1][y] = skeletons.get(i);
				}
				break;
			}
		}
	}
	
	
	public void movement() {
		int redDiceResult1, redDiceResult2, result, step, remaining;
		char direction;
		boolean endOfMovement = false;
		System.out.println("Pressione qualquer tecla pra rolar os dados");
		scan.nextLine();
		redDiceResult1 = die.rollRedDice();
		redDiceResult2 = die.rollRedDice();
		result = redDiceResult1 + redDiceResult2;
		step = 0;
		remaining = result;
		System.out.println("Dado 1: "+ redDiceResult1 + " Dado 2: " + redDiceResult2);
		Boolean movementHappened = false;
		Boolean cleanShot = true;
		while(!endOfMovement) {
			System.out.println("Voce pode andar até " + remaining + " casas.");
			System.out.println("Escolha a direção do movimento utilizando as teclas 'a' 'w' 's' e 'd', ou aperte 'e' para");
			System.out.println("parar o movimento");
			direction = scan.next().charAt(0);
			System.out.print("Quantas casas deseja andar? ");
			step = scan.nextInt();
			if(step > remaining) {
				System.out.println("Valor não permitido. Você fica nessa posição.");
				return;
			}
			switch(direction) {
			case 'a':
			if (hero.getPositionY()-step >= 0 && (map.isPositionEmpty(hero.getPositionX(), hero.getPositionY()-step)) && !map.isThereABlockX(hero.getPositionX(),hero.getPositionY(),hero.getPositionY()-step)){
				map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
				hero.setPosition(hero.getPositionX(), hero.getPositionY()-step);//muda posicao heroi
				map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
				map.printMap(); //imprime o mapa
				hero.getBag().printBag();
				movementHappened = true;
				moveMonsters();
				
			}else {
				System.out.println("Posição invalida ou ocupada."); 
				movementHappened = false;}
			break;
			case 'w':
			if (hero.getPositionX()-step >= 0 && (map.isPositionEmpty(hero.getPositionX()-step, hero.getPositionY())) && !map.isThereABlockY(hero.getPositionY(),hero.getPositionX(),hero.getPositionX()-step)) {
				map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
				hero.setPosition(hero.getPositionX()-step, hero.getPositionY());//muda posicao heroi
				map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
				map.printMap();//
				hero.getBag().printBag();
				movementHappened = true;
				moveMonsters();
			}else {
				System.out.println("Posição invalida ou ocupada."); 
				movementHappened = false;}
			break;
			case 'd':
			if (hero.getPositionY()+step <= map.getMapHeight() && (map.isPositionEmpty(hero.getPositionX(), hero.getPositionY()+step)) && !map.isThereABlockX(hero.getPositionX(), hero.getPositionY(), hero.getPositionY()+step) ){
				map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
				hero.setPosition(hero.getPositionX(), hero.getPositionY()+step);//muda posicao heroi
				map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
				map.printMap();//
				hero.getBag().printBag();
				movementHappened = true;
				moveMonsters();
			}else {
				System.out.println("Posição invalida ou ocupada."); 
				movementHappened = false;}
			break;
			case 's':
			if ( hero.getPositionX()+step <= map.getMapWidth() && (map.isPositionEmpty(hero.getPositionX()+step, hero.getPositionY())) && !map.isThereABlockY(hero.getPositionY(), hero.getPositionX(), hero.getPositionX()+step)) {
				map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
				hero.setPosition(hero.getPositionX()+step, hero.getPositionY());//muda posicao heroi
				map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
				map.printMap();//
				hero.getBag().printBag();
				movementHappened = true;
				moveMonsters();
			}else {
				System.out.println("Posição invalida ou ocupada."); 
				movementHappened = false;}
			break;
			case 'e': 
				endOfMovement = true;
				break;
			}
			if(movementHappened) remaining = remaining - step;
			if(remaining <= 0) {
				endOfMovement = true;
			}
	   }
	}
	
	public void readInput() {
		int option;
		System.out.println("Escolha:");
		System.out.println("1. Realizar a��o");
		System.out.println("2. Mover");
		System.out.println();
		System.out.println("Digite o digito da opcao escolhida: ");
		try {
		option = scan.nextInt();
			if(option!= 1 && option != 2) {
				throw new IllegalArgumentException("Opção Inválida!");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Opção Inválida. Tente novamente!");
			System.out.println("Escolha:");
			System.out.println("1. Realizar a��o");
			System.out.println("2. Mover");
			System.out.println();
			System.out.println("Digite o digito da opcao escolhida: ");
			option = scan.nextInt();
			if(option != 1 && option != 2) {
				System.out.println("Você escolheu novamente uma opcao invalida!");
				System.out.println("Você deverá realizar sua ação agora.");
				option = 1; 
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Opção Inválida. Tente novamente!");
			System.out.println("Escolha:");
			System.out.println("1. Realizar a��o");
			System.out.println("2. Mover");
			System.out.println();
			System.out.println("Digite o digito da opcao escolhida: ");
			option = scan.nextInt();
			if(option != 1 && option != 2) {
				System.out.println("Você escolheu novamente uma opcao invalida!");
				System.out.println("Você deverá realizar sua ação agora.");
				option = 1; 
			}
		}
		
		if(option == 1) {
			action();
		}
		else if(option == 2) {
			movement();
		}
	}
	
	public void action() {
		int option;
		System.out.println("O que você deseja fazer?");
		System.out.println("1. Atacar um monstro");
		System.out.println("2. Procurar um tesouro");
		if(type == HeroType.ELF || type == HeroType.WIZARD) {
			System.out.println("3. Lançar uma magia");
		}
		try {
		option = scan.nextInt();
			if(option == 3 && (type != HeroType.ELF && type != HeroType.WIZARD)) {
				throw new IllegalArgumentException("Ação não Suportada");
			}
			if (option != 1 && option != 2 && option != 3) {
				throw new IllegalArgumentException("Opção Inválida!");
			}
		}
		catch(IllegalArgumentException e){
			System.out.println("Você digitou uma opção inválida.");
			System.out.println("Tente novamente!");
			System.out.println("O que você deseja fazer?");
			System.out.println("1. Atacar um monstro");
			System.out.println("2. Procurar um tesouro");
			if(type == HeroType.ELF || type == HeroType.WIZARD) {
				System.out.println("3. Lançar uma magia");
			}
			option = scan.nextInt();
			if(option == 3 && (type != HeroType.ELF && type != HeroType.WIZARD)) {
				System.out.println("Você digitou uma opção inválida novamente.");
				System.out.println("Você vai procurar por tesouros.");
				option = 2;
			}
			if (option != 1 && option != 2 && option != 3) {
				System.out.println("Você digitou uma opção inválida novamente.");
				System.out.println("Você vai procurar por tesouros.");
				option = 2;
			}
			
		}
		catch(InputMismatchException e){
			System.out.println("Você digitou uma opção inválida.");
			System.out.println("Tente novamente!");
			System.out.println("O que você deseja fazer?");
			System.out.println("1. Atacar um monstro");
			System.out.println("2. Procurar um tesouro");
			if(type == HeroType.ELF || type == HeroType.WIZARD) {
				System.out.println("3. Lançar uma magia");
			}
			option = scan.nextInt();
			if(option == 3 && (type != HeroType.ELF && type != HeroType.WIZARD)) {
				System.out.println("Você digitou uma opção inválida novamente.");
				System.out.println("Você vai procurar por tesouros.");
				option = 2;
			}
			if (option != 1 && option != 2 && option != 3) {
				System.out.println("Você digitou uma opção inválida novamente.");
				System.out.println("Você vai procurar por tesouros.");
				option = 2;
			}
			
		}
	}
	
	public void start() {
		int heroi, option;
		System.out.println();
		System.out.println("HeroQuest");
		System.out.println();
		
		System.out.println("Escolha um tipo de heroi:");
		System.out.println("|1 - Barbaro|  |2 - Elfo|  |3 - Anao|  |4 - Mago|");
		try{
			heroi = scan.nextInt();
			
			switch(heroi) {
			case 1:
				type = HeroType.BARBARIAN;
				break;
			case 2:
				type = HeroType.ELF;
				break;
			case 3:
				type = HeroType.DWARF;
				break;
			case 4:
				type = HeroType.WIZARD;
				break;
			default:
				throw new IllegalArgumentException("Tipo Inválido de Herói.");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Você escolheu um tipo inválido de heroi");
			System.out.println("Tente novamente!");
			System.out.println("Escolha um tipo de heroi:");
			System.out.println("|1 - Barbaro|  |2 - Elfo|  |3 - Anao|  |4 - Mago|");
			heroi = scan.nextInt();
			
			switch(heroi) {
			case 1:
				type = HeroType.BARBARIAN;
				break;
			case 2:
				type = HeroType.ELF;
				break;
			case 3:
				type = HeroType.DWARF;
				break;
			case 4:
				type = HeroType.WIZARD;
				break;
			default:
				System.out.println("Você escolheu novamente um tipo inválido.");
				System.out.println("Você jogará como o mago.");
				type = HeroType.WIZARD;
				heroi = 4;
			}
		
		}
		catch(InputMismatchException e) {
			System.out.println("Você escolheu um tipo inválido de heroi");
			System.out.println("Tente novamente!");
			System.out.println("Escolha um tipo de heroi:");
			System.out.println("|1 - Barbaro|  |2 - Elfo|  |3 - Anao|  |4 - Mago|");
			heroi = scan.nextInt();
			
			switch(heroi) {
			case 1:
				type = HeroType.BARBARIAN;
				break;
			case 2:
				type = HeroType.ELF;
				break;
			case 3:
				type = HeroType.DWARF;
				break;
			case 4:
				type = HeroType.WIZARD;
				break;
			default:
				System.out.println("Você escolheu novamente um tipo inválido.");
				System.out.println("Você jogará como o mago.");
				type = HeroType.WIZARD;
				heroi = 4;
			}
		
		}
		
		System.out.printf("Qual o nome do seu heroi: ");
		String nome = scan.next();
		System.out.println();
		System.out.println("Escolha uma forma de jogo: ");
		System.out.println("1. Mapa aleatório");
		System.out.println("2. Mapa carregado dos arquivos");
		System.out.println();
		System.out.println("Digite o digito da opcao escolhida: ");
		try {
		option = scan.nextInt();
		if(option!= 1 && option != 2) {
			throw new IllegalArgumentException("Opção Inválida!");
		}
		}
		catch(IllegalArgumentException e) {
			System.out.println("Opção Inválida. Tente novamente!");
			System.out.println("Escolha uma forma de jogo: ");
			System.out.println("1. Mapa aleatório");
			System.out.println("2. Mapa carregado dos arquivos");
			System.out.println();
			System.out.println("Digite o digito da opcao escolhida: ");
			option = scan.nextInt();
			if(option != 1 && option != 2) {
				System.out.println("Você escolheu novamente uma opcao invalida!");
				System.out.println("Você jogará com o mapa aleatório.");
				option = 1; 
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Opção Inválida. Tente novamente!");
			System.out.println("Escolha uma forma de jogo: ");
			System.out.println("1. Mapa aleatório");
			System.out.println("2. Mapa carregado dos arquivos");
			System.out.println();
			System.out.println("Digite o digito da opcao escolhida: ");
			option = scan.nextInt();
			if(option != 1 && option != 2) {
				System.out.println("Você escolheu novamente uma opcao invalida!");
				System.out.println("Você jogará com o mapa aleatório.");
				option = 1; 
			}
		}
		
		if(option == 1) {
			System.out.printf("Parte iniciada. Boa sorte, %s!\n", nome);
			System.out.println("Pressione q a qualquer momento durante um movimento para encerrar o jogo");
			map = new Map();
			map.buildDefautMap();
			randomInsertMonsters();
			switch(type) { 
			case BARBARIAN:
				hero = new Barbarian(25,18,nome);
				map.map[25][18] = hero;
				break;
			case ELF:
				hero = new Elf(25,18,nome);
				map.map[25][18] = hero;
				break;
			case DWARF: 
				hero = new Dwarf(25,18,nome);
				map.map[25][18] = hero;
				break;
			case WIZARD:
				hero = new Wizard(25,18,nome);
				map.map[25][18] = hero;
				break;
			}
			
			
			while(!exit) {
				map.printMap();
				readInput();
				//map.printMap();
			}
		}
		if(option == 2) {
			buildMapFromFile();
		}
		
		//teste
		int a = die.rollRedDice();
		DieFaces face =  die.rollCombatDice();
		System.out.println("Dado numérico = " + a + " Dado vermelho = " + face);
		
		
	}
	
	private int buildMapFromFile() {
		int goblinIndex = 0;
		int skeWizIndex = 0;
		int skeletIndex = 0;
		String directory;
		System.out.println("Insira o caminho completo para seu arquivo .txt");
		directory = scan.next();
		File readMap = new File(directory);
		try(Scanner scnr  = new Scanner(readMap);){
			int n;
			int m;
			char a;
			String string;
			String name;
			n = scnr.nextInt();
			m = scnr.nextInt();
			name = scnr.next();
			map = new Map(n,m);
			for(int i=0; i<n; i++) {
				string = scnr.next();
				for(int j=0; j<m; j++) {
					a = string.charAt(j);
					switch(a) {
					case '-': 
						map.map[i][j] = new EmptySpace(i,j);
						break;
					case '&':
						map.map[i][j] = new Wall(i,j);
						break;
					case 'G':
						goblins.add(new Goblin(i,j));
						map.map[i][j] = goblins.get(goblinIndex);
						goblinIndex++;
						break;
					case 'S':
						skeletons.add(new Skeleton(i,j));
						map.map[i][j] = skeletons.get(skeletIndex);
						skeletIndex++;
						break;
					case 'R':
						skeletonWizards.add(new SkeletonWizard(i,j));
						map.map[i][j] = skeletonWizards.get(skeWizIndex);
						skeWizIndex++;
						break;
					case 'U':
						map.map[i][j] = new Door(i,j);
					case 'O':
						map.map[i][j] = new GoldArmor(i,j);
						break;
					case 'B': 
						hero = new Barbarian(i,j, name);
						map.map[i][j] = hero;
						type = HeroType.BARBARIAN;
						break;
					case 'D':
						hero = new Dwarf(i,j,name);
						map.map[i][j] = hero;
						type = HeroType.DWARF;
						break;
					case 'E':
						hero = new Elf(i,j,name);
						map.map[i][j] = hero;
						type = HeroType.ELF;
						break;
					case 'W':
						hero = new Wizard(i,j,name);
						map.map[i][j] = hero;
						type = HeroType.WIZARD;
						break;
					case 'A':
						map.map[i][j] = new Daggers(i,j);
						break;
					case 'L':
						map.map[i][j] = new BroadSword(i,j);
						break;
					case 'H':
						map.map[i][j] = new BronzeArmor(i,j);
						break;
					case 'N': 
						map.map[i][j] = new ShortSword(i,j);
						break;
					case 'P': 
						map.map[i][j] = new Potion(i,j);
						break;
					case 'C':
						map.map[i][j] = new SimpleHeal(i,j);
						break;
					case 'M': 
						map.map[i][j] = new MagicMissile(i,j);
						break;
					case 'F': 
						map.map[i][j] = new Fireball(i,j);
						break;
					case 'X':
						map.map[i][j] = new SilverArmor(i,j);
						break;
					default:
						continue;
					}
				}
			}
			
			
		}
		catch(FileNotFoundException e) {
			System.out.println("Arquivo de mapa não encontrado.");
			System.out.println("Um mapa aleatório será gerado.");
			return -1;
		}		
		return 1;
	}
	
	private int getRandomX() {
		return random.nextInt(map.getMapWidth());
	}
	
	private int getRandomY() {
		return random.nextInt(map.getMapHeight());
	}
	
	
	private void randomInsertMonsters() {
		int numberSkeletonWizards;
		int numberSkeletons;
		int numberGoblins;
		int tempX;
		int tempY;
		
		numberSkeletons = 10;
		numberGoblins = 5;
		numberSkeletonWizards = 4;
		
		for(int i=1; i<=numberSkeletons;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				skeletons.add(new Skeleton(tempX,tempY));
				map.map[tempX][tempY] = skeletons.get(i-1);	
			}
			else {
				i--;
			}
		}
		
		for(int i=1; i<=numberSkeletonWizards;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				skeletonWizards.add(new SkeletonWizard(tempX,tempY));
				map.map[tempX][tempY] = skeletons.get(i-1);	
			}
			else {
				i--;
			}
			
		}
		
		for(int i=1; i<=numberGoblins;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				goblins.add(new Goblin(tempX,tempY));
				map.map[tempX][tempY] = goblins.get(i-1);	
			}
			else {
				i--;
			}
			
		}
		
		
	}

	

}
