package game;

import java.util.*;

public class Game {
	
	private ArrayList<Monster> monsters;
	private Map map;
	private Barbarian barbarian;
	private Dwarf dwarf;
	private Elf elf;
	private Wizard wizard; 
	private Die die;
	
	public Game() {
		monsters = new ArrayList<Monster>();
		map = null;
		barbarian = null;
		dwarf = null;
		elf = null;
		wizard = null;
		die = new Die();
	}
	
	public void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("HeroQuest");
		System.out.println();
		
		System.out.println("Escolha uma forma de jogo: ");
		System.out.println("1. Mapa aleatório");
		System.out.println("2. Mapa carregado dos arquivos");
		System.out.println();
		System.out.println("Digite o dígito da opção escolhida: ");
		int option = scan.nextInt();
		if(option == 1) {
			map = new Map();
			map.buildDefautMap();
		}
		if(option == 2) {
			map.buildMapFromFile();
		}
		
		//teste
		int a = die.rollNumberDice();
		DieFaces face =  die.rollRedDice();
		System.out.println("Dado numérico = " + a + " Dado vermelho = " + face);
		
		
	}
	

	

}
