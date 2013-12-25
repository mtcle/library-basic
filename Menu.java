import java.util.Scanner;

/**
 * 菜单类 主要负责打印菜单 以及后期扩展
 * 
 */
class Menu {
  public int printMenu() {
    /**
     * 提供一个打印方法 返回值为int型
     */
    String str = new String();
    str =
        "*****欢迎使用图书管理系统*****\n--------------------------\n     1.新增图书\n     2.查看图书\n     3.删除图书\n     4.借出图书\n     5.归还图书\n     6.续借图书\n     7.退出系统\n-------------------------\n     请选择：\n";
    System.out.print(str);
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    return input.nextInt();
  }
}
