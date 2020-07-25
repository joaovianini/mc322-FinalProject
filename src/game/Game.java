package game;

import java.util.*;

public class Game {
	
	private ArrayList<Monster> monsters;
	private Map map;
	private Die die;
	private boolean exit;
	private Scanner roll;
	private Scanner scan;
	
	public Game() {
		monsters = new ArrayList<Monster>();
		map = null;
		die = new Die();
		exit = false;
		roll = new Scanner(System.in);
		scan = new Scanner(System.in);
	}
	
	public void readInput() {
		int redDiceResult;
		int casas;
		
		DieFaces combatDiceResult =  die.rollCombatDice();
		
		System.out.print("Pressione qualquer tecla pra rolar os dados");
		roll.nextLine();
		redDiceResult = die.rollRedDice();
		System.out.printf("Voce pode andar %d casas.\n", redDiceResult);
		System.out.print("Escolha quantas deseja andar:");
		casas = scan.nextInt();
		
		
	}
	public void start() {
		System.out.println();
		System.out.println("HeroQuest");
		System.out.println();
		
		System.out.print("Escolha um tipo de heroi: \n");
		System.out.print("|1 - Barbaro|  |2 - Elfo|  |3 - Anao|  |4 - Mago|\n");
		int heroi = scan.nextInt();
		System.out.printf("Qual o nome do seu heroi: ");
		String nome = scan.next();
		
		System.out.println("Escolha uma forma de jogo: ");
		System.out.println("1. Mapa aleatório");
		System.out.println("2. Mapa carregado dos arquivos");
		System.out.println();
		System.out.println("Digite o digito da op�ao escolhida: ");
		int option = scan.nextInt();
		if(option == 1) {
			System.out.printf("Game started. Good luck %s!", nome);
			map = new Map();
			map.buildDefautMap();
			map.addHero(heroi, nome);
			while(!exit) {
				map.printMap();
				readInput();
			}
		}
		if(option == 2) {
			map.buildMapFromFile();
		}
		
		//teste
		int a = die.rollRedDice();
		DieFaces face =  die.rollCombatDice();
		System.out.println("Dado numérico = " + a + " Dado vermelho = " + face);
		
		
	}
	

	

}
