import java.util.ArrayList;
import java.util.Scanner;
public class LibraryManagementSystem {
    static final int MAX_BOOKS = 100;
    public static int removeDuplicates(Book[] books, int n) {
        if (n == 0) {
            return 0;
        }
        int writeIndex = 1;
        for (int i = 1; i < n; i++) {
            if (books[i].bookId != books[writeIndex - 1].bookId) {
                books[writeIndex] = books[i];
                writeIndex = writeIndex + 1;
            }
        }
        return writeIndex;
    }

    public static void searchByTitle(Book[] books, int count, String query) {
        String queryLower = query.toLowerCase();
        ArrayList<Book> results = new ArrayList<Book>();
        for (int i = 0; i < count; i++) {
            String titleLower = books[i].title.toLowerCase();
            if (titleLower.contains(queryLower)) {
                results.add(books[i]);
            }
        }
        if (results.size() == 0) {
            System.out.println("No books found matching '" + query + "'");
            return;
        }
        System.out.println("Search Results for '" + query + "':");
        for (int i = 0; i < results.size(); i++) {
            Book b = results.get(i);
            System.out.println("- Found: [" + b.bookId + "] " + b.title + " (Rs. " + b.price + ")");
        }
    }

    public static void sortByPrice(Book[] books, int count) {
        int swapCount = 0;
        for (int i = 0; i < count - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < count; j++) {
                if (books[j].price < books[minIndex].price) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Book temp = books[i];
                books[i] = books[minIndex];
                books[minIndex] = temp;
                swapCount = swapCount + 1;
            }
        }
        System.out.println("Books Sorted by Price:");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". [" + books[i].bookId + "] " + books[i].title + " - Rs. " + books[i].price);
        }
        System.out.println("Total Swaps: " + swapCount);
    }

    public static int searchByPrice(Book[] books, int count, double targetPrice) {
        int low = 0;
        int high = count - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (books[mid].price == targetPrice) {
                return mid;
            } else if (books[mid].price < targetPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int minBooksForTargetCost(Book[] books, int count, double targetCost) {
        int left = 0;
        double currentSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < count; right++) {
            currentSum = currentSum + books[right].price;
            while (currentSum >= targetCost) {
                int windowLength = right - left + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                }
                currentSum = currentSum - books[left].price;
                left = left + 1;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLength;
        }
    }
    public static int addBook(Book[] books, int count, Scanner sc) {

        if (count >= MAX_BOOKS) {
            System.out.println("Library is full! Cannot add more books.");
            return count;
        }

        System.out.print("Enter Book ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = Double.parseDouble(sc.nextLine());

        books[count] = new Book(id, title, author, price);
        count = count + 1;
        System.out.println("Book added successfully!");
        return count;
    }
    public static void viewAllBooks(Book[] books, int count) {
        if (count == 0) {
            System.out.println("No books in the library yet.");
            return;
        }
        System.out.println("---- All Books in Library ----");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". [" + books[i].bookId + "] " + books[i].title
                    + " by " + books[i].author + " - Rs. " + books[i].price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[MAX_BOOKS];
        int count = 0;
        System.out.print("How many books do you want to enter initially? ");
        int initialCount = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < initialCount; i++) {
            System.out.println("Enter details for Book " + (i + 1) + ":");
            count = addBook(books, count, sc);
        }
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("========= LIBRARY MENU =========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Remove Duplicate Books");
            System.out.println("4. Search Books by Title");
            System.out.println("5. Sort Books by Price");
            System.out.println("6. Search Book by Exact Price");
            System.out.println("7. Minimum Consecutive Books for Target Cost");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            if (choice == 1) {
                String again = "y";
                while (again.equalsIgnoreCase("y")) {
                    count = addBook(books, count, sc);
                    System.out.print("Add another book? (y/n): ");
                    again = sc.nextLine();
                }
            } else if (choice == 2) {
                viewAllBooks(books, count);
            } else if (choice == 3) {
                count = removeDuplicates(books, count);
                System.out.println("Duplicates removed. New unique count: " + count);
                viewAllBooks(books, count);
            } else if (choice == 4) {
                System.out.print("Enter title (or part of title) to search: ");
                String query = sc.nextLine();
                searchByTitle(books, count, query);
            } else if (choice == 5) {
                sortByPrice(books, count);
            } else if (choice == 6) {
                System.out.print("Enter price to search: ");
                double targetPrice = Double.parseDouble(sc.nextLine());
                int index = searchByPrice(books, count, targetPrice);
                if (index != -1) {
                    System.out.println("Book found at index " + index + ": [" + books[index].bookId + "] "
                            + books[index].title + " (Rs. " + books[index].price + ")");
                } else {
                    System.out.println("Book not found. (Tip: Sort first using option 5 for correct results)");
                }
            } else if (choice == 7) {
                System.out.print("Enter target cost (S): ");
                double targetCost = Double.parseDouble(sc.nextLine());
                int minBooks = minBooksForTargetCost(books, count, targetCost);
                if (minBooks == 0) {
                    System.out.println("No combination of consecutive books reaches that target cost.");
                } else {
                    System.out.println("Minimum Consecutive Books Needed: " + minBooks);
                }
            } else if (choice == 8) {
                running = false;
                System.out.println("Exiting the Library Management System. Goodbye!");
            } else {
                System.out.println("Invalid choice! Please enter a number between 1 and 8.");
            }
        }
        sc.close();
    }
}