package gameController;

import java.security.SecureRandom;

import java.util.*;
import java.io.*;

import game.*;

public class Game {
	
	private static SecureRandom random = new SecureRandom();
	private ArrayList<Monster> skeletons;
	private ArrayList<Monster> skeletonWizards;
	private ArrayList<Monster> goblins;
	private Map map;
	private Die die;
	private boolean exit;
	private Scanner scan;
	private HeroType type; 
	private Hero hero;
	private EmptySpace emptySpace;
	
	
	
	public Game() {
		skeletons = new ArrayList<Monster>();
		skeletonWizards = new ArrayList<Monster>();
		goblins = new ArrayList<Monster>();
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
			//Observacao: Quando o heroi anda, se ele vai para uma posicao onde esta um tesouro, ele perde a oportunidade de coletar esse tesouro
			int redDiceResult1, redDiceResult2, result, step, remaining, multiplier, backupX,backupY;
			char direction;
			String temp;
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
			while(endOfMovement == false) {
				System.out.println("Voce pode andar at� " + remaining + " casas.");
				System.out.println("Escolha a dire��o do movimento utilizando as teclas 'a' 'w' 's' e 'd', ou aperte 'e' para");
				System.out.println("parar o movimento");
				direction = scan.next().charAt(0);
				if(direction == 'e') {
					return;
				}
				if (direction == 'q') {
					System.exit(1);
				}
				System.out.print("Quantas casas deseja andar? ");
				try {
					if(scan.hasNextInt()) {
						step = scan.nextInt();
					}
				}
				catch(InputMismatchException e) {
					System.out.println("Valor n�o suportado");
			           scan.next();
				}			
				
				backupX = hero.getPositionX();
				backupY = hero.getPositionY();
				
				if(step > remaining) {
					return;
				}
				switch(direction) {
				case 'a':
				if (hero.getPositionY()-step >= 0 && (map.isPositionEmpty(hero.getPositionX(), hero.getPositionY()-step)) && !map.isThereABlockX(hero.getPositionX(),hero.getPositionY(),hero.getPositionY()-step)){
					try{
						if(hero.getPositionY()-step < 0) throw new ArrayIndexOutOfBoundsException();
						map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
						hero.setPosition(hero.getPositionX(), hero.getPositionY()-step);//muda posicao heroi
						map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
						map.printMap(); //imprime o mapa
						hero.getBag().printBag();
						movementHappened = true;
						moveMonsters();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Destino está fora do mapa.");
						System.out.println("Tente novamente!");
						map.map[backupX][backupY] = hero;
						movementHappened = false;
					}
					
				}else {
					System.out.println("Posi��o invalida ou ocupada."); 
					movementHappened = false;}
				break;
				case 'w':
				if (hero.getPositionX()-step >= 0 && (map.isPositionEmpty(hero.getPositionX()-step, hero.getPositionY())) && !map.isThereABlockY(hero.getPositionY(),hero.getPositionX(),hero.getPositionX()-step)) {
					try {
					if(hero.getPositionX()-step < 0) throw new ArrayIndexOutOfBoundsException();
					map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
					hero.setPosition(hero.getPositionX()-step, hero.getPositionY());//muda posicao heroi
					map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
					map.printMap();//
					hero.getBag().printBag();
					movementHappened = true;
					moveMonsters();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Destino está fora do mapa.");
						System.out.println("Tente novamente!");
						map.map[backupX][backupY] = hero;
						movementHappened = false;
					}
				}else {
					System.out.println("Posi��o invalida ou ocupada."); 
					movementHappened = false;}
				break;
				case 'd':
				if (hero.getPositionY()+step < map.getMapHeight() && (map.isPositionEmpty(hero.getPositionX(), hero.getPositionY()+step)) && !map.isThereABlockX(hero.getPositionX(), hero.getPositionY(), hero.getPositionY()+step) ){
					try {
					if(hero.getPositionY()+step >= map.getMapHeight()) throw new ArrayIndexOutOfBoundsException();
					map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
					hero.setPosition(hero.getPositionX(), hero.getPositionY()+step);//muda posicao heroi
					map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
					map.printMap();//
					hero.getBag().printBag();
					movementHappened = true;
					moveMonsters();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Destino está fora do mapa.");
						System.out.println("Tente novamente!");
						map.map[backupX][backupY] = hero;
						movementHappened = false;
					}
				}else {
					System.out.println("Posi��o invalida ou ocupada."); 
					movementHappened = false;}
				break;
				case 's':
				if ( hero.getPositionX()+step < map.getMapWidth() && (map.isPositionEmpty(hero.getPositionX()+step, hero.getPositionY())) && !map.isThereABlockY(hero.getPositionY(), hero.getPositionX(), hero.getPositionX()+step)) {
					try {
					if(hero.getPositionX()+step >= map.getMapWidth()) throw new ArrayIndexOutOfBoundsException();
					map.map[hero.getPositionX()][hero.getPositionY()] = emptySpace;//apaga posicao antiga
					hero.setPosition(hero.getPositionX()+step, hero.getPositionY());//muda posicao heroi
					map.map[hero.getPositionX()][hero.getPositionY()] = hero;//muda posicao heroi no mapa
					map.printMap();//
					hero.getBag().printBag();
					movementHappened = true;
					moveMonsters();
					}
					catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("Destino está fora do mapa.");
						System.out.println("Tente novamente!");
						map.map[backupX][backupY] = hero;
						movementHappened = false;
					}
				}else {
					System.out.println("Posi��o invalida ou ocupada."); 
					movementHappened = false;}
				break;
				}
				if(movementHappened) remaining = remaining - step;
				if(remaining <= 0) {
					endOfMovement = true;
				}
		   }
		}
	
	public void readInput() {
		int option = 1;
		System.out.println("Escolha:");
		System.out.println("1. Realizar acao");
		System.out.println("2. Mover");
		System.out.println();
		System.out.println("Digite o digito da opcao escolhida: ");
		try {
				if(scan.hasNextInt())
					option = scan.nextInt();
				else if(scan.hasNext()) {
					String temp = scan.next();
					System.out.printf("O valor %s inserido não é um inteiro.\nVocê deverá realizar uma ação.\n", temp);
					
				}
				if(option!= 1 && option != 2) 
					throw new IllegalArgumentException("Opção Inválida!");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Opção Inválida. Tente novamente!");
			System.out.println("Escolha:");
			System.out.println("1. Realizar acao");
			System.out.println("2. Mover");
			System.out.println();
			System.out.println("Digite o digito da opcao escolhida: ");
			if(scan.hasNextInt())
				option = scan.nextInt();
			else if(scan.hasNext()) {
				String temp = scan.next();
				System.out.printf("O valor %s inserido não é um inteiro.\nVocê deverá realizar uma ação.\n", temp);
				
			}
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
		int option = 2;
		System.out.println("O que você deseja fazer?");
		System.out.println("1. Atacar um monstro");
		System.out.println("2. Procurar um tesouro");
		if(type == HeroType.ELF || type == HeroType.WIZARD) {
			System.out.println("3. Lançar uma magia");
		}
		try {
			if(scan.hasNextInt())
				option = scan.nextInt();
			else if(scan.hasNext()) {
				String temp = scan.next();
				System.out.printf("O valor %s inserido não é um inteiro.\nVocê deverá procurar um tesouro.\n", temp);
				
			}
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
			if(scan.hasNextInt())
				option = scan.nextInt();
			else if(scan.hasNext()) {
				String temp = scan.next();
				System.out.printf("O valor %s inserido não é um inteiro.\nVocê deverá procurar um tesouro.\n", temp);
				
			}
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
		
		
		//atacar
		//primeiro procura por skeleton, depois skeleton wizard e depois goblin
		if (option == 1) {
			
			int damage;
			MapItem target = new MapItem();
			target = map.foundSkeletonNearby(hero);
			if (target!= null) {
				for (int i = 0; i < skeletons.size(); i++) {
					if(target == skeletons.get(i)) {
						damage = combat(hero,skeletons.get(i));
						hero.attack(skeletons.get(i), damage);
						System.out.printf("ATACOU! VIDA RESTANTE DO MONSTRO: %d\n", skeletons.get(i).getHP());
						System.out.printf("SUA VIDA: %d", hero.getHP());
						if(skeletons.get(i).getHP() <= 0) {
							map.removeFromMap(skeletons.get(i).getPositionX(), skeletons.get(i).getPositionY());
							skeletons.remove(i);
						}
					}
				}
			}
			else {
				target = map.foundSkeletonWizardNearby(hero);
				if (target != null) {
					for (int i = 0; i < skeletonWizards.size(); i++) {
						if(target == skeletonWizards.get(i)) {
							damage = combat(hero,skeletonWizards.get(i));
							hero.attack(skeletonWizards.get(i), damage);
							System.out.printf("ATACOU! VIDA RESTANTE DO MONSTRO: %d\n", skeletonWizards.get(i).getHP());
							System.out.printf("SUA VIDA: %d", hero.getHP());
							if(skeletonWizards.get(i).getHP() <= 0) {
								map.removeFromMap(skeletonWizards.get(i).getPositionX(), skeletonWizards.get(i).getPositionY());
								skeletonWizards.remove(i);
							}
						}
					}
				}
				else {
					target = map.foundGoblinNearby(hero);
					if(target != null) {
						for (int i = 0; i < goblins.size(); i++) {
							if(target == goblins.get(i)) {
								damage = combat(hero,goblins.get(i));
								hero.attack(goblins.get(i), damage);
								System.out.printf("ATACOU! VIDA RESTANTE DO MONSTRO: %d\n", goblins.get(i).getHP());
								System.out.printf("SUA VIDA: %d", hero.getHP());
								if(goblins.get(i).getHP() <= 0) {
									map.removeFromMap(goblins.get(i).getPositionX(), goblins.get(i).getPositionY());
									goblins.remove(i);
								}
							}
						}
					}
					else {
						System.out.println("Nenhum monstro por perto.");
					}
				}
			}
		}
		else if(option == 2) {
			if(findItems()) {
				System.out.println("Você encontrou tesouros!");
				System.out.println("Gostaria de coletá-los?");
				System.out.println("Pressione qualquer tecla para sim e 'n' para não");
				char a = scan.next().charAt(0);
				if (a == 'n') {
					System.out.println("Você não coletou seus tesouros!");
				}
				else {
					collectItems();
					System.out.println("Observe a sua nova mochila:");
					hero.getBag().printBag();
					if(type == HeroType.WIZARD) {
						((Wizard) hero).printMagics();
					}
					if(type == HeroType.ELF) {
						((Elf) hero).printMagics();
					}
					
				}
				
			}
			else {
				System.out.println("Você não encontrou tesouros!");
			}
		
		}
		
		else if(option == 3 && (type == HeroType.ELF || type == HeroType.WIZARD)) {
			System.out.println("Operação em Construção");
		}
	}
	
	public int combat(Hero h, Monster m) {
		DieFaces dadoAtk;
		DieFaces dadoDef;
		int atk = 0;
		int def = 0;
		int damage = 0;
		for (int i = 0; i<= h.getNumberAtkDices(); i++) {
			dadoAtk = die.rollCombatDice();
			if (dadoAtk== DieFaces.SKULL) {
				atk++;
			}
		}	
		for (int y = 0; y<= m.getNumberDefDices(); y++) {
			dadoDef = die.rollCombatDice();
			if (dadoDef== DieFaces.MONSTERSHIELD) {
				def++;
			}
		}
		damage = atk - def;
		System.out.println("LANCANDO DADOS:");
		System.out.printf("ATAQUE HEROI: %d caveiras || DEFESA MONSTRO: %d escudos || DANO TOTAL: %d\n", atk, def, damage);
		return damage;
	}
	
	
	public void start() {
		int heroi = 4, option = 1;
		System.out.println();
		System.out.println("HeroQuest");
		System.out.println();
		System.out.println();
		System.out.println("Escolha uma forma de jogo: ");
		System.out.println("1. Mapa aleatório");
		System.out.println("2. Mapa carregado dos arquivos");
		System.out.println();
		System.out.println("Digite o digito da opcao escolhida: ");
		try {
		if(scan.hasNextInt()) {
			option = scan.nextInt();
			System.out.println("Você escolheu a opção "+ option);
		}
		else if(scan.hasNext()) {
			String temp = scan.next();
			System.out.printf("O valor %s inserido não é um inteiro. Tente Novamente!\n", temp);
			if(scan.hasNextInt()) {
				option = scan.nextInt();
			}
			else {
				System.out.printf("O valor %s inserido não é um inteiro. Você jogará com o mapa aleatório.\n", temp);
				option = 1; 
			}
		}
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
			if(scan.hasNextInt())
				option = scan.nextInt();
			else if(scan.hasNext()) {
				String temp = scan.next();
				System.out.printf("O valor %s inserido não é um inteiro. Você jogará com o mapa aleatório.\n", temp);
				option = 1;
			}
			if(option != 1 && option != 2) {
				System.out.println("Você escolheu novamente uma opcao invalida!");
				System.out.println("Você jogará com o mapa aleatório.");
				option = 1; 
			}
		}
		
		
		if(option == 1) {

			System.out.println("Escolha um tipo de heroi:");
			System.out.println("|1 - Barbaro|  |2 - Elfo|  |3 - Anao|  |4 - Mago|");
			try{
				if(scan.hasNextInt())
					heroi = scan.nextInt();
				else if(scan.hasNext()) {
					String temp = scan.next();
					System.out.printf("O valor %s inserido não é uma opção válida.\nTente Novamente!.\n", temp);
					if(scan.hasNextInt())
						heroi = scan.nextInt();
					else if(scan.hasNext()) {
						temp = scan.next();
						System.out.printf("O valor %s inserido não é uma opção válida.\n Você jogará como o mago.\n", temp);
						heroi = 4;
					}
				}
				
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
				if(scan.hasNextInt())
					heroi = scan.nextInt();
				else {
					heroi = 5;
					}
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
			randomInsertItens();
			map.addHero(hero);
		}
		if(option == 2) {
			buildMapFromFile();
			System.out.printf("Parte iniciada. Boa sorte, %s!\n", hero.getName());
		}
		
		while(!exit) {
			map.printMap();
			if (type == HeroType.WIZARD) {
				((Wizard) hero).printMagics();
			}else if (type == HeroType.ELF){
				((Elf) hero).printMagics();
			}
			readInput();
		}
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
						break;
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
					case 'T':
						map.map[i][j] = new Teleport(i,j);
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
	
	private void randomInsertItens() {
		boolean successful = false;
		int tempX, tempY;
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new GoldArmor(tempX,tempY);
				successful = true;
			}
		}
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new BroadSword(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new BronzeArmor(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new Daggers(tempX,tempY);
				successful = true;
			}
		}
		
		if(type == HeroType.ELF || type == HeroType.WIZARD) {
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new Fireball(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new MagicMissile(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new SimpleHeal(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false;
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new Teleport(tempX,tempY);
				successful = true;
			}
		}
		}
		
		successful = false; 
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new Daggers(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false;
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new SilverArmor(tempX,tempY);
				successful = true;
			}
		}
		
		successful = false;
		
		while(!successful) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				map.map[tempX][tempY] = new ShortSword(tempX,tempY);
				successful = true;
			}
		}
		
		
	}
	
	
	public void collectItems() {
		int x, y;
		x = hero.getPositionX();
		y= hero.getPositionY();
		if(x+1 < map.getMapWidth() && map.isAnItem(x+1, y)) {
			((Collectable) map.map[x+1][y]).getCollected(hero);
			map.map[x+1][y] = new EmptySpace(x+1, y);
		}
		if(y+1 < map.getMapHeight() && map.isAnItem(x, y+1)) {
			((Collectable) map.map[x][y+1]).getCollected(hero);
			map.map[x][y+1] = new EmptySpace(x, y+1);
		}
		if(x-1 >=0 && map.isAnItem(x-1, y)) {
			((Collectable) map.map[x-1][y]).getCollected(hero);
			map.map[x-1][y] = new EmptySpace(x-1, y);
		}
		if(y-1 >= 0 && map.isAnItem(x, y-1)) {
			((Collectable) map.map[x][y-1]).getCollected(hero);
			map.map[x][y-1] = new EmptySpace(x, y-1);
		}
		
		if(type == HeroType.ELF) {
			if( x+1 < map.getMapWidth() && map.isAMagic(x+1, y)) {
				((Elf) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x+1][y] = new EmptySpace(x+1, y);
			}
			if(y+1 < map.getMapHeight() &&map.isAMagic(x, y+1)) {
				((Elf) hero).addMagic((Magic) map.map[x][y+1]);
				map.map[x][y+1] = new EmptySpace(x, y+1);
			}
			if( x-1 >=0 && map.isAMagic(x-1, y)) {
				((Elf) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x-1][y] = new EmptySpace(x-1, y);
			}
			if( y-1 >= 0 && map.isAMagic(x, y-1)) {
				((Elf) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x][y-1] = new EmptySpace(x, y-1);
			}
			
		}
		
		if(type == HeroType.WIZARD) {
			if( x+1 < map.getMapWidth() && map.isAMagic(x+1, y)) {
				((Wizard) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x+1][y] = new EmptySpace(x+1, y);
			}
			if(y+1 < map.getMapHeight() &&map.isAMagic(x, y+1)) {
				((Wizard) hero).addMagic((Magic) map.map[x][y+1]);
				map.map[x][y+1] = new EmptySpace(x, y+1);
			}
			if( x-1 >=0 && map.isAMagic(x-1, y)) {
				((Wizard) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x-1][y] = new EmptySpace(x-1, y);
			}
			if( y-1 >= 0 && map.isAMagic(x, y-1)) {
				((Wizard) hero).addMagic((Magic) map.map[x+1][y]);
				map.map[x][y-1] = new EmptySpace(x, y-1);
			}
			
		}

	}
	
	public boolean findItems() {
		int x, y;
		boolean found = false;
		x = hero.getPositionX();
		y= hero.getPositionY();
		if(x+1 < map.getMapWidth() && map.isAnItem(x+1, y)) {
			map.map[x+1][y].setHidden(false);
			found = true;
		}
		if(y+1 < map.getMapHeight() && map.isAnItem(x, y+1)) {
			map.map[x][y+1].setHidden(false);
			found = true;
		}
		if(x-1 >=0 && map.isAnItem(x-1, y)) {
			map.map[x-1][y].setHidden(false);
			found = true;
		}
		if(y-1 >= 0 && map.isAnItem(x, y-1)) {
			map.map[x][y-1].setHidden(false);
			found = true;
		}
		
		if(type == HeroType.ELF||type == HeroType.WIZARD) {
			if( x+1 < map.getMapWidth() && map.isAMagic(x+1, y)){
				map.map[x+1][y].setHidden(false);
				found = true;
			}
			if( y+1 < map.getMapHeight() && map.isAMagic(x, y+1)) {
				map.map[x][y+1].setHidden(false);
				found = true;
			}
			if(x-1 >=0 && map.isAMagic(x-1, y)) {
				map.map[x-1][y].setHidden(false);
				found = true;
			}
			if(y-1 >= 0 && map.isAMagic(x, y-1)) {
				map.map[x][y-1].setHidden(false);
				found = true;
			}
			
		}
		
		return found;
	}
	
	

}
