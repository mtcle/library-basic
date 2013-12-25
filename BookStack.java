import java.util.ArrayList;
import java.util.Date;


/**
 * 
 * 书架类 包括书架容量属性 包括方法：删除，添加，查看，借出，归还，续借
 **/
class BookStack {

  // Book firstBook = new Book("test");
  private int bookStackSize;
  ArrayList<Book> bookArray = new ArrayList<>();// 声明一个数组链表用于存储多本图书

  public BookStack(int bookStatckSize) {// 构造方法
    this.bookStackSize = bookStatckSize;
  }

  public int getBookStackSize() {
    return bookStackSize;
  }

  public void setBookStackSize(int bookStackSize) {
    this.bookStackSize = bookStackSize;
  }

  public void delBook(String name) {// 删除图书
    for (int i = 0; i < bookArray.size(); i++) {
      if (bookArray.get(i).bookName.equals(name) && (bookArray.get(i).getStatus() == 0)) {
        bookArray.remove(i); // 通过名字删除图书
        System.out.println("delete success!");
      }
    }

  }


  public void addBook(String name) {// 增加图书
    Book book = new Book(name);
    bookArray.add(book);
  }



  public Book viewBook(int i) {// 查看图书
    return bookArray.get(i);// 返回该图书
  }

  public void checkOut(String name) throws Exception {// 借书
    try {
      for (int i = 0; i < bookArray.size(); i++) {
        if (bookArray.get(i).bookName.equals(name) && (bookArray.get(i).getStatus() == 0)) {
          bookArray.get(i).setRentCounts();// 增加图书借出次数
          bookArray.get(i).setStatus(1);// 修改图书状态
          System.out.println("check out success!");
          bookArray.get(i).record.add(bookArray.get(i).newRecord());//调用book类的方法来new一个他的内部类record
          break;
        }
      }
    } catch (Exception ex) {
      System.out.println("输入不正确，重写输入！");
    }

  }

  public Book checkIn(String name) throws Exception {// 还书
    Book temp = null;
    int aa=0;
    for (int i = 0; i < bookArray.size(); i++) {
      try {
        if (bookArray.get(i).bookName.equals(name) && (bookArray.get(i).getStatus() == 1)) {
          bookArray.get(i).setStatus(0);// 还书后修改图书状态
          temp = bookArray.get(i);// 返回该图书
          aa=1;
        }
      } catch (Exception ex) {
        System.out.println("你输入的还书信息不正确！");
      }
    }
    if (aa==0){System.out.println("輸入錯誤！");}
    return temp;


  }

  public void reBorrow(String name) {// 续借
    for (int i = 0; i < bookArray.size(); i++) {
      if (bookArray.get(i).bookName.equals(name) && (bookArray.get(i).getStatus() == 1)) {
        bookArray.get(i).record.get(i).setCheckInTime(30);
      }
    }
  }
}
