package ���ݿ�ѧ.¹��.test01;

import java.util.Scanner;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Test01 {

	public static int[][] InputMap() {
		System.out.println("##################################");
		System.out.println("��������:");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = 0;
		int y = 0;
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = 0;
			}
		}
		System.out.println("Map1��ʼ����ɣ�");
		int m = 0;
		System.out.println("����Map1������ϵ������");
		m = sc.nextInt();
		System.out.println("����Map1������ϵ��");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					x = sc.nextInt();
				} else {
					y = sc.nextInt();
				}
			}
			map[x][y] = 1;
			map[y][x] = 1;
		}
		System.out.println("����Map1������ϵ����");
		System.out.println("##################################");
		return map;
	}

	public static void OutputMap(int[][] map) {
		System.out.println("���ͼ");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("�������");
		System.out.println("##################################");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("T1ʱ��");
		int[][] map1 = InputMap();
		OutputMap(map1);
		System.out.println("T1ʱ��");
		int[][] map2 = InputMap();
		OutputMap(map2);
		System.out.println("##################################");
		System.out.println("��ʼ�����");
		System.out.println("##################################");

		System.out.println("�������");
		int n = map1.length;
		int connectmap1[][] = new int[n][n];
		int connectmap2[][] = new int[n][n];

		/*
		 * ���������Ĺ�ͬ������
		 */
		for (int i = 0; i < n; i++) // i��ʾ����c��ÿһ��
			for (int j = 0; j < n; j++) { // j��ʾ����c��ÿһ��
				int tempmap1 = 0;
				int tempmap2 = 0;
				for (int k = 0; k < map1[i].length; k++) {// k��ʾ����a���кź�����b���к�
					tempmap1 += map1[i][k] * map1[k][j];
					tempmap2 += map2[i][k] * map2[k][j];
				}
				connectmap1[i][j] = tempmap1;
				connectmap2[i][j] = tempmap2;
			}
		///////////////////////////////////////////////////////////////////////////

		System.out.println("T1ʱ�� :��ϵͼ :");
		OutputMap(connectmap1);
		System.out.println("##################################");
		System.out.println("T2ʱ�� :��ϵͼ :");
		OutputMap(connectmap2);
		System.out.println("##################################");

		System.out.println();
		System.out.println("**************************************************");
		System.out.println();
		System.out.println("�������");
		System.out.println();
		System.out.println("##################################");
		System.out.println("1��������ӳ����������ǰ�������ѵ��˵ġ���ͬ���Ѹ������롰����һ�����г�Ϊ���ѵĸ��ʡ�֮��Ĺ�ϵ��  ");
		System.out.println();
		System.out.println("��һ�����г�Ϊ���ѵĸ��ʣ�");
		for (int num = 1; num < n; num++) {
			double a = 0;
			double b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (map1[i][j] == 0) {
						if (connectmap1[i][j] == num) {
							b++;
							if (map2[i][j] == 1) {
								a++;
							}
						}

					}
				}
			}
			if (b == 0) {
				System.out.println("�������ѣ���ͬ������Ϊ" + num + "������Ϊ" + b);
				System.out.println("T2ʱ�̳�Ϊ���ѵ�����Ϊ" + a);
				System.out.println("���ݲ����޷��������");
			} else {
				System.out.println("�������ѣ���ͬ������Ϊ" + num + "������Ϊ" + b);
				System.out.println("T2ʱ�̳�Ϊ���ѵ�����Ϊ" + a);
				System.out.println("����Ϊ��" + a / b);

			}
			System.out.println();
		}
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		System.out.println("2��Tʱ�̺�T+1ʱ�̵�ÿ���˵ľۼ�ϵ��");
		System.out.println();
		System.out.println("Tʱ��ÿ���˵ľۼ�ϵ��");
		System.out.println();
		for (int i = 0; i < n; i++) {
			int c = 0;
			for (int j = 0; j < n; j++) {
				if (map1[i][j] == 1) {
					for (int k = j; k < n; k++) {
						if (map1[i][k] == 1 && map1[j][k] == 1) {
							c++;
						}
					}
				}
			}

			System.out.println("�ڵ�" + i + "��������Ϊ" + connectmap1[i][i]);
			System.out.println("������������Ϊ" + c);
			System.out.println("�ڵ�" + i + "�ľۼ�ϵ��Ϊ" + (double) c / connectmap1[i][i]);
		}
		System.out.println();
		System.out.println("Tʱ��ÿ���˵ľۼ�ϵ��");
		System.out.println();
		for (int i = 0; i < n; i++) {
			int c = 0;
			for (int j = 0; j < n; j++) {
				if (map2[i][j] == 1) {
					for (int k = j; k < n; k++) {
						if (map2[i][k] == 1 && map2[j][k] == 1) {
							c++;
						}
					}
				}
			}

			System.out.println("�ڵ�" + i + "��������Ϊ" + connectmap2[i][i]);
			System.out.println("������������Ϊ" + c);
			System.out.println("�ڵ�" + i + "�ľۼ�ϵ��Ϊ" + (double) c / connectmap2[i][i]);
		}
		System.out.println();
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		
		System.out.println("3��Tʱ�̺�T+1ʱ�̵�ÿ���ߵĽ���");
		System.out.println();
		System.out.println("Tʱ��ÿ���ߵĽ���");
		
		
		/*
		 * �����������
		 */
		/*
		 * int map1class[]=new int[n+1]; for (int i = 1; i <= n; i++) {
		 * map1class[i]=-1; } map1class[2]=0; for (int i = 1; i <= n; i++) { for
		 * (int j = 1; j <= n; j++) { for (int k = 1; k <= n; k++) { if
		 * (map1[j][k]==1&&map1class[k]==-1&&map1class[j]>=0) {
		 * map1class[k]=map1class[j]+1; } } } } System.out.println("123"); for
		 * (int i = 1; i <= n; i++) { if (map1class[i]>=map1class[0]) {
		 * map1class[0]=map1class[i]; } System.out.println(map1class[i]+"  "+i);
		 * } /*
		 * 
		 * 
		 * 
		 */

	}

}
/*
 * ����// 7 11 0 1 0 5 0 6 1 2 1 5 2 5 3 4 3 6 4 5 4 6 5 6
 * 
 * 7 15 0 1 0 2 0 5 0 6 1 2 1 4 1 5 2 5 2 6 3 4 3 5 3 6 4 5 4 6 5 6
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
