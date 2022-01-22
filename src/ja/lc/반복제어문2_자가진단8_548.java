package ja.lc;

public class 반복제어문2_자가진단8_548 {

	public static void main(String[] args) {
		for(int i = 2; i < 5; i++) {
			for(int j = 1; j < 6; j++) {
				if(i * j >= 10) {
					System.out.print(i + " * " + j + " = " + i * j + "   ");
				}
				else {
					System.out.print(i + " * " + j + " =  " + i * j + "   ");
				}
			}
			System.out.println();
		}
	}
}