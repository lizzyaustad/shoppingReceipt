public class Product {

  int quantity; //number purchased
  boolean tax; //false=exempt; true=has sales tax
  boolean imported; //false=domestic; true=imported;
  double price; //price of item
  String name; //name of product


  public Product(int q, boolean t, boolean imp, double p, String n) {
    quantity=q;
    tax=t;
    imported=imp;
    price=p;
    name=n;
  }

}
