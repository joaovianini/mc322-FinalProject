package game;

public enum DieFaces {
	SKULL{
		public String toString() {
			String out =  "Caveira";
			return out;
		}
	}, HEROSHIELD{
		public String toString() {
			String out = "Escudo Herói";
			return out;
		}
	}, MONSTERSHIELD{
		public String toString() {
			String out = "Escudo Monstro";
			return out;
		}
	};
}
