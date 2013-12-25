import java.util.Date;
import java.util.Scanner;

public class LibraryManage {// 测试类
  private static int choice;

  public static void main(String[] args) throws Exception {
    Menu menu = new Menu();
    BookStack bookStack = new BookStack(10);// 实例一个容量为10的书架
    Rent rentPrice = new Rent(3);// 定义一本3元
    Book book1 = new Book("飘");// 为了测试方便先加入几本图书
    Book book2 = new Book("罗马假日");
    Book book3 = new Book("test", 1);
    bookStack.bookArray.add(book1);
    bookStack.bookArray.add(book2);
    bookStack.bookArray.add(book3);
    do {
      try {
        choice = menu.printMenu();
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        switch (choice) {
          case 1:
            if (bookStack.bookArray.size() != 10) {
              System.out.println("新增图书：");
              String name = input.next();
              bookStack.addBook(name);
              System.out.println("success！");
            }
            break;
          case 2:
            int status = 0;
            for (int i = 0; i < bookStack.bookArray.size(); i++) {
              if (bookStack.bookArray.get(i).getStatus() == 0) {
                System.out.println("图书ID：" + bookStack.bookArray.get(i).getId() + " 名字："
                    + bookStack.bookArray.get(i).bookName + "\t" + " 状态：在馆 " + "借出次数:"
                    + bookStack.bookArray.get(i).getRentCounts());
                status = 1;
              } else {
                System.out.println("图书ID：" + bookStack.bookArray.get(i).getId() + " 名字："
                    + bookStack.bookArray.get(i).bookName + "\t" + " 状态：借出 " + "借出次数:"
                    + bookStack.bookArray.get(i).getRentCounts());
                status = 1;
              }
              if (status == 0) {
                System.out.println("输入的名字不正确！");
              }
            }
            break;
          case 3: {// 删除图书
            System.out.println("输入名字：");
            String name = input.next();
            int status1 = 0;
            for (int i = 0; i < bookStack.bookArray.size(); i++)
              if (bookStack.bookArray.get(i).bookName.equals(name)) {
                bookStack.delBook(name);
                status1 = 1;
              }
            if (status1 == 0) {
              System.out.println("输入的名字不正确！");
            }
          }
            break;
          case 4:// 借书
            System.out.println("输入名字：");
            String name1 = input.next();
            bookStack.checkOut(name1);
            break;
          case 5:// 还书
            System.out.println("输入名字：");
            Date time = new Date();
            String name2 = input.next();
            Book temp = bookStack.checkIn(name2);
            System.out.println("size" + temp.record.size());
            System.out.println("借书费用为： "
                + temp.record.get(temp.record.size() - 1).rentFee(time.getTime(),
                    rentPrice.getRentPrice(temp.getBookLevel())));
            break;
          case 6:// 续借
            System.out.println("输入名字：");
            String name3 = input.next();
            bookStack.reBorrow(name3);
        }
      } catch (Exception ex) {
        System.out.println("输入错误！");
      }
    } while (choice != 7);
  }
}
