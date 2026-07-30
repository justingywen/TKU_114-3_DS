import java.util.ArrayList;

public class BookAlgorithms {

    public static void mergeSortById(Book[] books) {
        if (books == null || books.length < 2) return;
        Book[] temp = new Book[books.length];
        mergeSortById(books, temp, 0, books.length - 1);
    }

    private static void mergeSortById(Book[] books, Book[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortById(books, temp, left, mid);
        mergeSortById(books, temp, mid + 1, right);
        mergeId(books, temp, left, mid, right);
    }

    private static void mergeId(Book[] books, Book[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (books[i].getId().compareTo(books[j].getId()) <= 0) {
                temp[k++] = books[i++];
            } else {
                temp[k++] = books[j++];
            }
        }
        while (i <= mid) temp[k++] = books[i++];
        while (j <= right) temp[k++] = books[j++];
        for (int index = left; index <= right; index++) books[index] = temp[index];
    }

    public static void mergeSortByBorrowCountDesc(Book[] books) {
        if (books == null || books.length < 2) return;
        Book[] temp = new Book[books.length];
        mergeSortByBorrowCountDesc(books, temp, 0, books.length - 1);
    }

    private static void mergeSortByBorrowCountDesc(Book[] books, Book[] temp, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortByBorrowCountDesc(books, temp, left, mid);
        mergeSortByBorrowCountDesc(books, temp, mid + 1, right);
        mergeBorrowCountDesc(books, temp, left, mid, right);
    }

    private static void mergeBorrowCountDesc(Book[] books, Book[] temp, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (books[i].getBorrowCount() >= books[j].getBorrowCount()) {
                temp[k++] = books[i++];
            } else {
                temp[k++] = books[j++];
            }
        }
        while (i <= mid) temp[k++] = books[i++];
        while (j <= right) temp[k++] = books[j++];
        for (int index = left; index <= right; index++) books[index] = temp[index];
    }

    public static int binarySearchById(Book[] books, String targetId) {
        if (books == null || targetId == null) return -1;
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = targetId.compareTo(books[mid].getId());
            if (cmp == 0) return mid;
            if (cmp < 0) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    public static ArrayList<Book> findByCategory(ArrayList<Book> books, String category) {
        ArrayList<Book> results = new ArrayList<>();
        if (books == null || category == null) return results;
        for (Book b : books) {
            if (b.getCategory().equalsIgnoreCase(category.trim())) {
                results.add(b);
            }
        }
        return results;
    }

    public static boolean containsId(ArrayList<Book> books, String id) {
        if (books == null || id == null) return false;
        for (Book b : books) {
            if (b.getId().equalsIgnoreCase(id.trim())) return true;
        }
        return false;
    }
}