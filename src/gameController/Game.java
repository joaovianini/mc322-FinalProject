package gameController;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
	private Barbarian barbarian;
	private Elf elf;
	private Dwarf dwarf;
	private Wizard wizard;
	
	
	public Game() {
		skeletons = new ArrayList<Skeleton>();
		skeletonWizards = new ArrayList<SkeletonWizard>();
		goblins = new ArrayList<Goblin>();
		map = null;
		die = new Die();
		exit = false;
		scan = new Scanner(System.in);
		barbarian = null;
		elf = null;
		dwarf = null;
		wizard = null;
	}
	
	public void movement() {
		int redDiceResult1, redDiceResult2, result;
		char direction;
		System.out.println("Pressione qualquer tecla pra rolar os dados");
		scan.nextLine();
		redDiceResult1 = die.rollRedDice();
		redDiceResult2 = die.rollRedDice();
		result = redDiceResult1 + redDiceResult2;
		System.out.println("Dado 1: "+ redDiceResult1 + " Dado 2: " + redDiceResult2);
		System.out.println("Voce pode andar até " + result + " casas.");
		System.out.print("Mova usando as teclas de direção 'a' 'w' 's' e 'd' e pressione 'e' caso queira parar"); 
		for(int i=0; i<result; i++) {
			direction = scan.next().charAt(0);
			if (direction == 'e') {
				break;
			}
		}
	}
	
	public void readInput() {
		int option;
		System.out.println("Você pode realizar uma ação antes ou depois de se mover.");
		System.out.println("Você prefere realizar sua ação:");
		System.out.println("1. Antes de se mover?");
		System.out.println("2. Depois de se mover?");
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
			System.out.println("Você pode realizar uma ação antes ou depois de se mover.");
			System.out.println("Você prefere realizar sua ação:");
			System.out.println("1. Antes de se mover?");
			System.out.println("2. Depois de se mover?");
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
			System.out.println("Você pode realizar uma ação antes ou depois de se mover.");
			System.out.println("Você prefere realizar sua ação:");
			System.out.println("1. Antes de se mover?");
			System.out.println("2. Depois de se mover?");
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
			movement();
		}
		else if(option == 2) {
			movement();
			action();
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
				barbarian = new Barbarian(25,18,nome);
				map.map[25][18] = barbarian;
			case ELF:
				elf = new Elf(25,18,nome);
				map.map[25][18] = elf;
			case DWARF: 
				dwarf = new Dwarf(25,18,nome);
				map.map[25][18] = dwarf;
			case WIZARD:
				wizard = new Wizard(25,18,nome);
				map.map[25][18] = wizard;
			}
			map.printMap();
			while(!exit) {
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
	
	private void buildMapFromFile() {
		
	}
	
	private int getRandomX() {
		return random.nextInt(map.map.length);
	}
	
	private int getRandomY() {
		return random.nextInt(map.map[0].length);
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
		
		for(int i=0; i<numberSkeletons;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				skeletons.add(new Skeleton(tempX,tempY));
				map.map[tempX][tempY] = skeletons.get(i);	
			}
			else if(tempX != map.map.length && map.isPositionEmpty(tempX+1, tempY)) {
				skeletons.add(new Skeleton(tempX+1,tempY));
				map.map[tempX+1][tempY] = skeletons.get(i);
				
			}
			else if(tempX != 0 && map.isPositionEmpty(tempX-1, tempY)) {
				skeletons.add(new Skeleton(tempX-1,tempY));
				map.map[tempX-1][tempY] = skeletons.get(i);		
			}
			else if(tempY != map.map[0].length && map.isPositionEmpty(tempX, tempY+1)) {
				skeletons.add(new Skeleton(tempX+1,tempY));
				map.map[tempX][tempY+1] = skeletons.get(i);
				
			}
			else if(tempY != 0 && map.isPositionEmpty(tempX, tempY-1)) {
				skeletons.add(new Skeleton(tempX,tempY-1));
				map.map[tempX][tempY-1] = skeletons.get(i);		
			}
			else {
				i--;
			}
		}
		
		for(int i=0; i<numberSkeletonWizards;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				skeletonWizards.add(new SkeletonWizard(tempX,tempY));
				map.map[tempX][tempY] = skeletons.get(i);	
			}
			else if(tempX != map.map.length && map.isPositionEmpty(tempX+1, tempY)) {
				skeletonWizards.add(new SkeletonWizard(tempX+1,tempY));
				map.map[tempX+1][tempY] = skeletonWizards.get(i);
				
			}
			else if(tempX != 0 && map.isPositionEmpty(tempX-1, tempY)) {
				skeletonWizards.add(new SkeletonWizard(tempX-1,tempY));
				map.map[tempX-1][tempY] = skeletonWizards.get(i);		
			}
			else if(tempY != map.map[0].length && map.isPositionEmpty(tempX, tempY+1)) {
				skeletonWizards.add(new SkeletonWizard(tempX+1,tempY));
				map.map[tempX][tempY+1] = skeletonWizards.get(i);
				
			}
			else if(tempY != 0 && map.isPositionEmpty(tempX, tempY-1)) {
				skeletonWizards.add(new SkeletonWizard(tempX,tempY-1));
				map.map[tempX][tempY-1] = skeletonWizards.get(i);		
			}
			else {
				i--;
			}
		}
		
		for(int i=0; i<numberGoblins;i++) {
			tempX = getRandomX();
			tempY = getRandomY();
			if(map.isPositionEmpty(tempX, tempY)) {
				goblins.add(new Goblin(tempX,tempY));
				map.map[tempX][tempY] = goblins.get(i);	
			}
			else if(tempX != map.map.length && map.isPositionEmpty(tempX+1, tempY)) {
				goblins.add(new Goblin(tempX+1,tempY));
				map.map[tempX+1][tempY] = goblins.get(i);
				
			}
			else if(tempX != 0 && map.isPositionEmpty(tempX-1, tempY)) {
				goblins.add(new Goblin(tempX-1,tempY));
				map.map[tempX-1][tempY] = goblins.get(i);		
			}
			else if(tempY != map.map[0].length && map.isPositionEmpty(tempX, tempY+1)) {
				goblins.add(new Goblin(tempX+1,tempY));
				map.map[tempX][tempY+1] = goblins.get(i);
				
			}
			else if(tempY != 0 && map.isPositionEmpty(tempX, tempY-1)) {
				goblins.add(new Goblin(tempX,tempY-1));
				map.map[tempX][tempY-1] = goblins.get(i);		
			}
			else {
				i--;
			}
		}
		
		
	}

	

}
