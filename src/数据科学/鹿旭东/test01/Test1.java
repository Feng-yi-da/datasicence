package 数据科学.鹿旭东.test01;

import java.util.Scanner;

public class Test1 {

	public static int[][] InputMap() {
		System.out.println("##################################");
		System.out.println("输入点对数:");
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
		System.out.println("Map1初始化完成！");
		int m = 0;
		System.out.println("输入Map1关联关系对数：");
		m = sc.nextInt();
		System.out.println("输入Map1关联关系：");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < 2; j++) {
				if (j == 0) {
					x = sc.nextInt();
				} else {
					y = sc.nextInt();
				}
			}
			map[x - 1][y - 1] = 1;
			map[y - 1][x - 1] = 1;
		}
		System.out.println("输入Map1关联关系结束");
		System.out.println("##################################");
		return map;
	}

	/*
	 * 输出邻接矩阵
	 */
	public static void OutputMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * 输出图（邻接矩阵）
	 */
	public static void OutputMap(double[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	/*
	 * 输出图（邻接矩阵）
	 */
	public static void OutputMap(int[] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.print(map[i] + " ");
		}
		System.out.println();
	}

	/*
	 * 输出图（邻接矩阵）
	 */
	public static void OutputMap(double[] map) {
		for (int i = 0; i < map.length; i++) {
			System.out.print(map[i] + " ");
		}
		System.out.println();
	}

	public static int[][] MatrixMult(int[][] x, int[][] y) {
		int[][] result = new int[x.length][x.length];
		int n = x.length;
		for (int i = 0; i < n; i++) // i表示数组c的每一行
			for (int j = 0; j < n; j++) { // j表示数组c的每一列
				int tempmap1 = 0;
				for (int k = 0; k < n; k++) {// k表示数组a的列号和数组b的行号
					tempmap1 += x[i][k] * y[k][j];
				}
				result[i][j] = tempmap1;
			}
		System.out.println("$$$$$$$$$$$$$$$$$44");
		OutputMap(result);
		return result;
	}

	/*
	 * 网络分层
	 */
	public static int[] mapclass(int[][] map, int root) {
		int mapclass[] = new int[map.length];
		for (int i = 0; i < map.length; i++) {
			mapclass[i] = -1;
		}
		mapclass[root - 1] = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < mapclass.length; j++) {
				if (mapclass[j] == i) {
					for (int j2 = 0; j2 < map[j].length; j2++) {
						if (map[j][j2] == 1 && mapclass[j2] == -1) {
							mapclass[j2] = mapclass[j] + 1;
						}
					}
				}
			}
		}
		return mapclass;
	}

	/*
	 * 最短路径条数
	 */
	public static double[][] pathnum(int[][] map, int root) {
		double[][] pathnum = new double[map.length][2];
		int[] mapclass = mapclass(map, root);

		for (int i = 0; i < pathnum.length; i++) {
			pathnum[i][0] = mapclass[i];
			pathnum[i][1] = 0;
		}
		pathnum[root - 1][1] = 1;
		for (int i = 1; i < mapclass.length; i++) {
			for (int j = 0; j < mapclass.length; j++) {
				if (pathnum[j][0] == i) {
					int num = 0;
					for (int j2 = 0; j2 < mapclass.length; j2++) {
						if (map[j][j2] == 1 && pathnum[j2][0] == i - 1) {
							num += pathnum[j2][1];
						}
					}
					pathnum[j][1] = num;
				}
			}
		}
		pathnum[root - 1][1] = 0;
		return pathnum;
	}

	/*
	 * 边介数
	 */
	public static double[][] pathweigth(int[][] map, int root) {
		double[][] pathweigth = new double[map.length][map.length];
		double[] nodeweigth = new double[map.length];
		double[][] pathnum = pathnum(map, root);
		for (int i = 0; i < nodeweigth.length; i++) {
			nodeweigth[i] = 1;
		}
		for (int i = pathnum.length; i > 0; i--) {
			for (int j = 0; j < pathnum.length; j++) {
				if (pathnum[j][0] == i) {
					for (int j2 = 0; j2 < pathnum.length; j2++) {
						if (map[j][j2] == 1 && pathnum[j2][0] == i - 1) {
							if (j2 == root - 1) {
								pathnum[j2][1] = 1;
							}
							pathweigth[j2][j] = pathweigth[j][j2] = nodeweigth[j] * (pathnum[j2][1] / pathnum[j][1]);
							nodeweigth[j2] += pathweigth[j][j2];
						}
					}
				}
			}
		}
		return pathweigth;
	}

	public static void Question01(int[][] map1, int[][] map2) {
		int n = map1.length;
		System.out.println("矩阵相乘");
		int connectMap1[][] = MatrixMult(map1, map1);
		int connectMap2[][] = MatrixMult(map2, map2);
		System.out.println("****************************************************");
		System.out.println("下一快照中成为朋友的概率：");
		for (int num = 0; num < n; num++) {
			double a = 0;
			double b = 0;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					if (map1[i][j] == 0) {
						if (connectMap1[i][j] == num) {
							b++;
							if (map2[i][j] == 1) {
								a++;
							}
						}
					}
				}
			}
			if (b == 0) {
				System.out.println("不是朋友，共同朋友数为" + num + "信息不全，无法计算概率");
			} else {
				System.out.println("不是朋友，共同朋友数为" + num + "的人数为" + b);
				System.out.println("T2时刻成为朋友的人数为" + a);
				System.out.println("不是朋友，共同朋友数为" + num + "的人在下一次快照成为朋友的概率为：" + a / b);
			}
		}

	}

	public static void Question02(int[][] map1, int[][] map2) {
		int n = map1.length;
		int connectMap1[][] = MatrixMult(map1, map1);
		int connectMap2[][] = MatrixMult(map2, map2);
		System.out.println("****************************************************");
		for (int i = 1; i < n; i++) {
			double c = 0;
			for (int j = 1; j < n; j++) {
				if (map1[i][j] == 1) {
					for (int k = j + 1; k < n; k++) {
						if (map1[j][k] == 1 && map1[i][k] == 1) {
							c++;
						}
					}
				}
			}

			int coupleNum = 0;
			for (int j = 1; j <= connectMap1[i][i]; j++) {
				coupleNum = j + coupleNum;
			}
			System.out.println("节点" + i + "的朋友总对数为" + coupleNum);
			System.out.println("是朋友的数" + c);
			System.out.println("节点" + i + "的聚集系数为" + c / coupleNum);
		}
		System.out.println("****************************************************");
	}

	public static void Question03(int[][] map) {
		double [][] pathtatolweight = new double[map.length][map.length];

		for (int i = 0; i < pathtatolweight.length; i++) {
			double[][] pathweight = pathweigth(map, i + 1);
			for (int j = 0; j < pathweight.length; j++) {
				for (int j2 = 0; j2 < pathweight.length; j2++) {
					pathtatolweight[j][j2] += pathweight[j][j2];
				}
			}
		}
		for (int i = 0; i < pathtatolweight.length; i++) {
			for (int j = i+1; j < pathtatolweight.length; j++) {
				System.out.println("点"+i+" 点"+j+" 相连的边的介数为 " +pathtatolweight[i][j]/2);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("T1时刻");
		int[][] map1 = InputMap();
		System.out.println("T2时刻");
		int[][] map2 = InputMap();
		System.out.println("output time 1 map :");
		OutputMap(map1);
		System.out.println();
		System.out.println("output time 2 map :");
		OutputMap(map2);
		System.out.println("###########################");
		System.out.println("问题一");
		Question01(map1, map2);
		System.out.println("###########################");
		System.out.println("问题二");
		Question02(map1, map2);
		System.out.println("###########################");
		System.out.println("问题三");
		Question03(map1);
		System.out.println("###########################");
		Question03(map2);
	}

}

/*
 * 测试//map1 7 11 1 2 1 6 1 7 2 3 2 6 3 6 3 7 4 5 4 7 5 6 6 7
 * 
 * map2 7 15 1 2 1 3 1 6 1 7 2 3 2 5 2 6 3 6 3 7 4 5 4 6 4 7 5 6 5 7 6 7
 * 
 * map (实验三）11 16 1 2 1 3 1 4 1 5 2 3 2 6 3 6 4 7 4 8 5 8 6 9 7 9 7 10 8 10 9 11 10 11
 * 
 */
