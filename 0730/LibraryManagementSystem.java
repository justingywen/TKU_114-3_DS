import java.util.ArrayList;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();

        addBook(library, new Book("B103", "Java Programming", "Tech", 120));
        addBook(library, new Book("B101", "Python Guide", "Tech", 450));
        addBook(library, new Book("B105", "World History", "History", 80));
        addBook(library, new Book("B102", "Economics 101", "Business", 300));
        addBook(library, new Book("B101", "Duplicate Book", "Tech", 99));

        Book[] booksById = library.toArray(new Book[0]);
        BookAlgorithms.mergeSortById(booksById);

        System.out.println("\n依編號升冪排序：");
        for (Book b : booksById) System.out.println(b);

        Book[] booksByBorrow = library.toArray(new Book[0]);
        BookAlgorithms.mergeSortByBorrowCountDesc(booksByBorrow);

        System.out.println("\n依借閱次數降冪排序：");
        for (Book b : booksByBorrow) System.out.println(b);

        System.out.println("\nBinary Search 查詢 B102：");
        int idx = BookAlgorithms.binarySearchById(booksById, "B102");
        System.out.println(idx != -1 ? booksById[idx] : "找不到");

        System.out.println("\nSequential Search 查詢分類 Tech：");
        for (Book b : BookAlgorithms.findByCategory(library, "Tech")) {
            System.out.println(b);
        }

        System.out.println("\n測試空資料搜尋：");
        System.out.println("結果：" + BookAlgorithms.binarySearchById(new Book[0], "B999"));
    }

    public static boolean addBook(ArrayList<Book> library, Book book) {
        if (BookAlgorithms.containsId(library, book.getId())) {
            System.out.println("新增失敗：書籍編號 " + book.getId() + " 已存在！");
            return false;
        }
        library.add(book);
        System.out.println("成功新增書籍：" + book);
        return true;
    }
}