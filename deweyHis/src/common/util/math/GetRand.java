package common.util.math;

public class GetRand {
	
	/**
	 * 返回一个随机数 范围为0到n-1之间
	 * @param n
	 * @return
	 */
	public static int randomInt(int n) {
		return (int)(Math.random()*n);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 从0—9中选4个不同随机数
		int[] anArray = new int[10];
		for (int i = 0; i < 10; i++) {
			anArray[i] = i;
		}
		int[] rand = new int[4];
		for (int i = 0; i < 4;) {
			int j = randomInt(anArray.length);
			System.out.println(j);
			if (j < (10 - i)) {
				rand[i] = anArray[j];
				anArray[j] = anArray[9 - i];
				anArray[9 - i] = rand[i];
				i++;
			}
		}
		
		System.out.println(rand[0] + "    " +rand[1] + "   " +  rand[2] + "   "  + rand[3] + "   ");
	}
}
