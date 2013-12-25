/**
 * 租金类 包括租金的基本类型价格
 */
class Rent {
  private double rentPrice;// 租金单价

  public double getRentPrice(int bookRentLevel) throws Exception {
    if (bookRentLevel == 1)
      return rentPrice + 2;
    else if (bookRentLevel == 0)
      return rentPrice;
    else
      throw new Exception();//需要抛异常～
  }

  public Rent() {//默认为1
    this.rentPrice = 1;
  }

  public Rent(double rentPrice) {//可以用户定义
    this.rentPrice = rentPrice;
  }
}
