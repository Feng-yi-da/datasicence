package 数据科学.鹿旭东.test01;

import java.util.Scanner;

import org.w3c.dom.css.ElementCSSInlineStyle;

public class Test01 {

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
			map[x][y] = 1;
			map[y][x] = 1;
		}
		System.out.println("输入Map1关联关系结束");
		System.out.println("##################################");
		return map;
	}

	public static void OutputMap(int[][] map) {
		System.out.println("输出图");
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("结束输出");
		System.out.println("##################################");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("T1时刻");
		int[][] map1 = InputMap();
		OutputMap(map1);
		System.out.println("T1时刻");
		int[][] map2 = InputMap();
		OutputMap(map2);
		System.out.println("##################################");
		System.out.println("初始化完成");
		System.out.println("##################################");

		System.out.println("矩阵相乘");
		int n = map1.length;
		int connectmap1[][] = new int[n][n];
		int connectmap2[][] = new int[n][n];

		/*
		 * 矩阵相乘求的共同朋友数
		 */
		for (int i = 0; i < n; i++) // i表示数组c的每一行
			for (int j = 0; j < n; j++) { // j表示数组c的每一列
				int tempmap1 = 0;
				int tempmap2 = 0;
				for (int k = 0; k < map1[i].length; k++) {// k表示数组a的列号和数组b的行号
					tempmap1 += map1[i][k] * map1[k][j];
					tempmap2 += map2[i][k] * map2[k][j];
				}
				connectmap1[i][j] = tempmap1;
				connectmap2[i][j] = tempmap2;
			}
		///////////////////////////////////////////////////////////////////////////

		System.out.println("T1时刻 :关系图 :");
		OutputMap(connectmap1);
		System.out.println("##################################");
		System.out.println("T2时刻 :关系图 :");
		OutputMap(connectmap2);
		System.out.println("##################################");

		System.out.println();
		System.out.println("**************************************************");
		System.out.println();
		System.out.println("答案输出：");
		System.out.println();
		System.out.println("##################################");
		System.out.println("1）给出反映出的两个当前不是朋友的人的“共同朋友个数”与“在下一快照中成为朋友的概率”之间的关系。  ");
		System.out.println();
		System.out.println("下一快照中成为朋友的概率：");
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
				System.out.println("不是朋友，共同朋友数为" + num + "的人数为" + b);
				System.out.println("T2时刻成为朋友的人数为" + a);
				System.out.println("数据不足无法求出概率");
			} else {
				System.out.println("不是朋友，共同朋友数为" + num + "的人数为" + b);
				System.out.println("T2时刻成为朋友的人数为" + a);
				System.out.println("概率为：" + a / b);

			}
			System.out.println();
		}
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		System.out.println("2）T时刻和T+1时刻的每个人的聚集系数");
		System.out.println();
		System.out.println("T时刻每个人的聚集系数");
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

			System.out.println("节点" + i + "的朋友数为" + connectmap1[i][i]);
			System.out.println("朋友是朋友数为" + c);
			System.out.println("节点" + i + "的聚集系数为" + (double) c / connectmap1[i][i]);
		}
		System.out.println();
		System.out.println("T时刻每个人的聚集系数");
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

			System.out.println("节点" + i + "的朋友数为" + connectmap2[i][i]);
			System.out.println("朋友是朋友数为" + c);
			System.out.println("节点" + i + "的聚集系数为" + (double) c / connectmap2[i][i]);
		}
		System.out.println();
		System.out.println();
		System.out.println("##################################");
		System.out.println();
		
		System.out.println("3）T时刻和T+1时刻的每条边的介数");
		System.out.println();
		System.out.println("T时刻每条边的介数");
		
		
		/*
		 * 宽度优先搜索
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
 * 测试// 7 11 0 1 0 5 0 6 1 2 1 5 2 5 3 4 3 6 4 5 4 6 5 6
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
