import java.util.ArrayList;
import java.util.Date;

/**
 * 图书类 
 * 包括名字，状态，借出次数
 * 属性 包括记录卡 租金类别
 * */
class Book {
  public String bookName;// 名字
  private int status = 0;// 图书当前状态，默认为0在馆可借，借出为1
  private int rentCounts = 0;// 图书借阅次数
  private int bookRentLevel = 0;// 图书租金级别,默认为0,高级为1
  private Sequence sequence;//定义一个图书序列号
  private String Id;
  ArrayList<Record> record=new ArrayList<Record>(); //规定泛型类型 
  
  public Book(String name) {// 只有名字的构造器
    this.bookName = name;
    this.sequence=new Sequence();
    this.Id=sequence.toString();
    this.bookRentLevel=0;
  }

  public Book(String name, int bookRentLevel) {// 带图书级别的构造器
    this.bookName = name;
    this.bookRentLevel = bookRentLevel;
    this.sequence=new Sequence();
    this.Id=sequence.toString();
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public int getRentCounts() {
    return rentCounts;
  }

  public void setRentCounts() {
    this.rentCounts++;
  }

  public int getBookLevel() {
    return bookRentLevel;
  }

  public void setBookLevel(int bookLevel) {
    this.bookRentLevel = bookLevel;
  }
  public String getId(){
    return Id;
  }
  
  public Record newRecord(){
    return new Book.Record();
  }
  
  /**
   *  记录卡类 包括借出日期，归还日期，图书名字
   * */
 class Record {
    private long checkOutTime;
    private long defaultCheckInTime;
    private long checkInTime;
    private double totalPrice;
    Date date=new Date();
    public Record(){
      
      this.checkOutTime=date.getTime();
      this.checkInTime=0;
      this.totalPrice=0;
      this.defaultCheckInTime=checkOutTime+15*24*60*60*1000;
    }
    public void setCheckOutTime(long checkOutTime) {
      this.checkOutTime = checkOutTime;
    }

    public long getCheckInTime() {
      return checkInTime;
    }
    public void setCheckInTime(long checkInTime) {
      this.checkInTime = checkInTime;
    }
   
    public double rentFee(long chechInTime,double rentPrice){//根据日期计算费用      
      totalPrice= ((chechInTime-checkOutTime)/(24*60*60*1000)+1)*rentPrice;//測試方便 先加一
      System.out.println("总共借阅天数： "+((chechInTime-checkOutTime)/(24*60*60*1000)+1));
      return totalPrice;
    }
    
  }

}