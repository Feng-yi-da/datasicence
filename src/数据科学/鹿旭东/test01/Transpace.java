package 数据科学.鹿旭东.test01;

import java.util.Scanner;

public class Transpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("input the node number :");
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println("input the nodeconnect number :");
		int m = sc.nextInt();
		
		int x=0;
		int y=0;
		int[] [] map = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++){
			for (int j = 1; j <= n; j++) {
				map[i][j] = 0;
			}
		}
		System.out.println("map creat end");
		
		System.out.println("input the node number :");
		for(int i = 1; i <= m; i++){
			for (int j = 1; j <= 2; j++) {
				if (j==1) {
					x=sc.nextInt();
				}else{
					y=sc.nextInt();
				}
			}
			map[x][y] =1;
		}
		System.out.println("input end");
		
		for(int i = 1; i <= n; i++){
			for (int j = 1; j <= n; j++) {
				System.out.print(map[i][j]+"\t");
			}
		}
		
	}

}
