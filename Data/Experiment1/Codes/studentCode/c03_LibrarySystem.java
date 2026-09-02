package code;

public class c03_LibrarySystem {
    private int maxBorrowLimit;  
    private int userBorrowedBooks; 
    private int bookStock;  

    public c03_LibrarySystem(int maxBorrowLimit, int initialStock) {
        this.maxBorrowLimit = maxBorrowLimit;
        this.userBorrowedBooks = 0;
        this.bookStock = initialStock;
    }

    public boolean borrowBook(int numBooks) {
        if (numBooks > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) <= maxBorrowLimit) {
            userBorrowedBooks += numBooks;
            bookStock -= numBooks;
            System.out.printf("Borrow successful! You now have %d books. Remaining stock: %d%n",
                              userBorrowedBooks, bookStock);
            return true;
        } else {
            System.out.println("Borrow failed! Either stock is insufficient or borrow limit exceeded.");
            return false;
        }
    }

    public int getUserBorrowedBooks() {
        return userBorrowedBooks;
    }

    public int getBookStock() {
        return bookStock;
    }

    public static void main(String[] args) {
    	
    	//testcase-VT:
    	c03_LibrarySystem library1 = new c03_LibrarySystem(3, 32);  
    	library1.borrowBook(38);  //numBooks > 0 && bookStock > 0 && numBooks > bookStock
    	c03_LibrarySystem library2 = new c03_LibrarySystem(2, 20);  
    	library2.borrowBook(7);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) > maxBorrowLimit
    	c03_LibrarySystem library3 = new c03_LibrarySystem(35, 30);  
    	library3.borrowBook(3);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) <= maxBorrowLimit
    	c03_LibrarySystem library4 = new c03_LibrarySystem(10, 30);  
    	library4.borrowBook(-3);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) > maxBorrowLimit
    	
    	//testcase-FT:
//    	c03_LibrarySystem library1 = new c03_LibrarySystem(2294398, 0);  
//    	library1.borrowBook(0);  //numBooks > 0 && bookStock > 0 && numBooks > bookStock
//    	c03_LibrarySystem library2 = new c03_LibrarySystem(-1808425884, 50331648);  
//    	library2.borrowBook(2);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) > maxBorrowLimit
//    	c03_LibrarySystem library3 = new c03_LibrarySystem(-1808425884, 1677918208);  
//    	library3.borrowBook(2);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) <= maxBorrowLimit
//    	c03_LibrarySystem library4 = new c03_LibrarySystem(-1808425884, 1677918208);  
//    	library4.borrowBook(11778);  //numBooks > 0 && bookStock > 0 && numBooks <= bookStock && (userBorrowedBooks + numBooks) > maxBorrowLimit
    	
    	//testcase-Z3:
//    	c03_LibrarySystem library1 = new c03_LibrarySystem(10, 7);  
//    	library1.borrowBook(3);  
//    	c03_LibrarySystem library2 = new c03_LibrarySystem(10, 4);  
//    	library2.borrowBook(5); 
//    	c03_LibrarySystem library3 = new c03_LibrarySystem(5, 10);  
//    	library3.borrowBook(3); 
//    	c03_LibrarySystem library4 = new c03_LibrarySystem(10, 6);  
//    	library4.borrowBook(0);  
    	
//    	UVT
//    	c03_LibrarySystem library1 = new c03_LibrarySystem(10, 7);  
//    	library1.borrowBook(38);  
//    	c03_LibrarySystem library2 = new c03_LibrarySystem(10, 4);  
//    	library2.borrowBook(7); 
//    	c03_LibrarySystem library3 = new c03_LibrarySystem(5, 10);  
//    	library3.borrowBook(3); 
//    	c03_LibrarySystem library4 = new c03_LibrarySystem(10, 6);  
//    	library4.borrowBook(-3);  
    
    }
}
