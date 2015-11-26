import java.util.*;

public class SalesTaxes {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //create an empty ArrayList for product objects
    ArrayList<String> productList = new ArrayList<String>();
    //read input and add to ArrayList
    while (scan.hasNextLine()) {
      productList.add(scan.nextLine());
    }
    scan.close();
    String[] products = new String[productList.size()];
    productList.toArray(products);
    Product[] list = new Product[products.length];
    for (int i=0; i<list.length; i++) {
      String temp = "";
      int j=0;
      int q=products[i].charAt(j);
      boolean t = true;
      boolean imp = false;
      boolean at = false;
      while (at == false) {
        temp = temp + products[i].charAt(j);
        j++;

        if (products[i].charAt(j)==('i')) {
          if (products[i].charAt(j+1)==('m')) {
            if (products[i].charAt(j+2)==('p')) {
              imp = true;
            }
          }
        }

        if (products[i].charAt(j)==('b')) {
          if (products[i].charAt(j+1)==('o')) {
            if (products[i].charAt(j+2)==('o')) {
              if (products[i].charAt(j+3)==('k')) {
                t = false;
              }
            }
          }
        }

        if (products[i].charAt(j)==('c')) {
          if (products[i].charAt(j+1)==('h')) {
            if (products[i].charAt(j+2)==('o')) {
              if (products[i].charAt(j+3)==('c')) {
                t = false;
              }
            }
          }
        }

        if (products[i].charAt(j)==('p')) {
          if (products[i].charAt(j+1)==('i')) {
            if (products[i].charAt(j+2)==('l')) {
              if (products[i].charAt(j+3)==('l')) {
                t = false;
              }
            }
          }
        }


        if (products[i].charAt(j)==(' ')) {
          if (products[i].charAt(j+1)==('a')) {
            if (products[i].charAt(j+2)==('t')) {
              if (products[i].charAt(j+3)==(' ')) {
                at = true;
              }
            }
          }
        }

      }

      String p = "";

      for (int k=j+4; k<products[i].length(); k++) {
        p = p + products[i].charAt(k);
      }
      double pr = Double.parseDouble(p);
      list[i] = new Product(q, t, imp, pr, temp);
    }


  double price = 0.0;
  double taxes = 0.0;
  double total = 0.0;
  double itemtotal = 0.0;
  for (int m=0; m<list.length; m++) {
    price = list[m].price;
    itemtotal = price;
    if (list[m].imported) {
      double importtax = .05*price;
      importtax = Math.ceil(importtax/.05) * .05;
      itemtotal = itemtotal + importtax;
      taxes = taxes + importtax;
    }

    if (list[m].tax) {
      double tax = .1*price;
      tax = Math.ceil(tax/.05) * .05;
      itemtotal = itemtotal + tax;
      taxes = taxes + tax;
    }

    total = total + itemtotal;
    System.out.print(list[m].name + ": ");
    System.out.printf("%.2f",itemtotal);
    System.out.println();
  }

  System.out.print("Sales Taxes: ");
  System.out.printf("%.2f",taxes);
  System.out.println();
  System.out.print("Total: ");
  System.out.printf("%.2f",total);
}
}
