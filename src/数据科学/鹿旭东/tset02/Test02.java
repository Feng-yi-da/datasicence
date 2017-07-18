package ���ݿ�ѧ.¹��.tset02;

import java.util.LinkedList;
import java.util.Scanner;


public class Test02 {

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
		System.out.println("Map��ʼ����ɣ�");
		int m = 0;
		System.out.println("����Map������ϵ������");
		m = sc.nextInt();
		System.out.println("����Map������ϵ��");
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= 2; j++) {
				if (j == 1) {
					x = sc.nextInt();
				} else {
					y = sc.nextInt();
				}
			}
			map[x - 1][y - 1] = 1;
			map[y - 1][x - 1] = 1;
		}
		System.out.println("����Map������ϵ����");
		System.out.println("##################################");
		OutputMap(map);
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

	public static void OutputMap(int[] map) {
		System.out.println("���ͼ");
		for (int i = 0; i < map.length; i++) {
			System.out.print(map[i] + " ");

		}
		System.out.println();
		System.out.println("�������");
		System.out.println("##################################");
	}

	/*
	 * ��ͼ�ֲ�
	 * 
	 */
	public static int[] Layered(int[][] map, int x) {
		int[] result = new int[map.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}
		result[x] = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				
				for (int k = 0; k < map.length; k++) {
					if (map[j][k] == 1 && result[k] == -1 && result[j] >= 0 && result[j] <= 6) {
						result[k] = result[j] + 1;
					}
				}
				
			}
		}
		return result;
	}

	/*
	 * �ж��Ƿ��ϡ����ȿռ䡱���ۣ��Ƿ���ھ������6�Ľڵ�
	 */
	public static void SixDimensionalVerification(int[][] map) {
		// TODO Auto-generated constructor stub
		
		for (int i = 0; i < map.length; i++) {
			int[] temp = Layered(map, i);
			//�ýڵ㣬���ϡ����ȿռ䡱���۵Ľ��
			LinkedList<Integer> re1 = new LinkedList<>();
			//��ýڵ���ͨ·�Ľ��
			LinkedList<Integer> re2 = new LinkedList<>();
			for (int j = 0; j < temp.length; j++) {
				
				if (temp[j]>0 && temp[j] <= 6) {
					re1.add(j);	
				}
				
				if (temp[j]>0) {
					re2.add(j);
				}
			}
			System.out.println("�ڵ㣺"+(i+1)+" �������ȿռ�Ľ����ռ�ı���Ϊ��"+((double) re1.size() / re2.size()));
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = InputMap();
		
		SixDimensionalVerification(map);
	}

	/*
	 * 
	 *��������1 ������������
	 * 7 11 1 2 1 6 1 7 2 3 2 6 3 6 3 7 4 5 4 7 5 6 6 7
	 * 
	 * ��������2  ��������������
	 * 8 7 1 2 2 3 3 4 4 5 5 6 6 7 7 8
	 * 
	 * 
	 */
}
