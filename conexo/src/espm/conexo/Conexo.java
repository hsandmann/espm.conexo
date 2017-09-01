package espm.conexo;

public class Conexo {
	
	public static void main(String[] args) {
		
		Conexo c1 = new Conexo(new int[][] {
			{0, 2, 2},
			{1, 3, 4},
			{1, 3, 6}
		});
		System.out.println(c1.calc());
		
	}

	private final int[][] values;
	private final int[][] visited;
	
	private final int N;
	private final int M;

	public Conexo(int[][] m) {
		this.values = m;
		this.N = m.length;
		this.M = m[0].length;
		this.visited = new int[N][M];
	}	
	
	public int calc() {
		return 0 //superior()
			+ horizontal()
			+ vertical();
	}
	
	private int superior() {
		int s = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] == 0) {
					neighborConexo(i, j, values[i][j]);
					s++;
				}
			}
		}
		return s;
	}
	
	private void neighborConexo(int i, int j, int ref) {
		if (visited[i][j] == 1 || values[i][j] != ref) return;
		visited[i][j] = 1;
		if (i - 1 >= 0) neighborConexo(i - 1, j, ref);
		if (i + 1 < N)	neighborConexo(i + 1, j, ref);
		if (j - 1 >= 0)	neighborConexo(i, j - 1, ref);
		if (j + 1 < M)	neighborConexo(i, j + 1, ref);
	}
	
	private int horizontal() {
		int h = 0;
		for (int i = 0; i < N - 1; i++) {
			int dRegion = 0;
			for (int j = 0; j < M; j++) {
				int dLocal = values[i][j] - values[i + 1][j];
				h += (dRegion >= 0) ^ (dLocal < 0) ? 0 : 1;
				dRegion = dLocal;
			}
		}
		return h;
	}

	private int vertical() {
		int v = 0;
		for (int j = 0; j < M - 1; j++) {
			for (int i = 0; i < N; i++) {
				
			}
		}
		return v;
	}

}
