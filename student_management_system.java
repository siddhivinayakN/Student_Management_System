//student management

import java.util.Scanner;

class studentry {

    public static int ct = 0;
    //student data entering
    int[] ID = new int[50];
    String[] name = new String[50];
    String[] clas = new String[50];
    float[] mark = new float[50];
    long[] contact = new long[50];
    int[] presentiy = new int[50];
    static int fees = 20000;
    int[] fepaid = new int[50];

    float[] JAVA = new float[50];
    float[] RDBMS = new float[50];
    float[] DSA = new float[50];
    float[] CG = new float[50];
    float[] total = new float[50];
    float[] percent = new float[50];
//enter the marks in per subject

    //add data of student
    void studdata() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID : ");
            int newid = s.nextInt();
            for (int i = 0; i < ct; i++) {
                if (ID[i] == newid) {
                    System.out.println("Student allreday Eixists....!");
                    return;
                }
            }
            ID[ct] = newid;
            System.out.print("Enter Student name : ");
            s.nextLine();
            name[ct] = s.nextLine();

            System.out.print("Enter class : ");
            clas[ct] = s.nextLine();

            System.out.print("Enter 12th marks : ");
            mark[ct] = s.nextFloat();

            System.out.print("Enter ur contact number : ");
            contact[ct] = s.nextLong();

            System.out.print("presentiy(?/90) : ");
            presentiy[ct] = s.nextInt();

            System.out.print("Enter fees paid : ");
            fepaid[ct] = s.nextInt();
            ct++;
            System.out.println("student added successfully...!");
        } catch (Exception ex) {
            System.out.println("\t\t\tException occured!\n");
        }
    }

    void numofstudent() {
        System.out.println("----------------------------------\n" + ct + " : students are available\n----------------------------------");
    }

    void percent() //adding percentage
    {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("enter student ID to store marks : ");
            int mID = s.nextInt();

//change...............................................................................................................................................................
            for (int i = 0; i <= 50; i++) {
                if (ID[i] == mID) {
                    System.out.println("marks of java : ");
                    JAVA[i] = s.nextFloat();
                    System.out.println("marks of RBMS : ");
                    RDBMS[i] = s.nextFloat();
                    System.out.println("marks of DSA : ");
                    DSA[i] = s.nextFloat();
                    System.out.println("marks of CG : ");
                    CG[i] = s.nextFloat();
                    total[i] = JAVA[i] + RDBMS[i] + DSA[i] + CG[i];
                    percent[i] = total[i] / 4;
                    break;
                }

            }
        } catch (Exception ex) {
            System.out.println("\t\t\tstudent not found!\n");
        }

    }
//delet  
}

class printstud extends studentry {

    int stuchoise;

    void stoption(int ch) {
        stuchoise = ch;

        if (stuchoise == 1) {
            studdata();
        } else if (stuchoise == 2) {
            allstudent();
        } else if (stuchoise == 3) {
            percent();
        } else if (stuchoise == 4) {
            displaymk();
        } else if (stuchoise == 5) {
            searchstud();
        } else if (stuchoise == 6) {
            numofstudent();
        } else if (stuchoise == 7) {
            fee();
        } else if (stuchoise == 8) {
            updatestud();
        } else if (stuchoise == 9) {
            allstufee();
        } else if (stuchoise == 11) {
            delstud();
        }

    }

    void updatestud()//do this 
    {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter Student ID : ");
            int uID = s.nextInt();

            if (uID < 0) {
                System.out.print("Student not found......!");
                return;
            }
            for (int i = 0; i <= 50; i++) {
                if (ID[i] == uID) {
                    System.out.print("Enter new Student ID : ");
                    ID[i] = s.nextInt();

                    System.out.print("Enter Student name : ");
                    s.nextLine();
                    name[i] = s.nextLine();

                    System.out.print("Enter class : ");
                    clas[i] = s.nextLine();

                    System.out.print("Enter 12th marks : ");
                    mark[i] = s.nextFloat();

                    System.out.print("Enter  ur contact number : ");
                    contact[i] = s.nextLong();

                    System.out.print("presentiy(?/90) : ");
                    presentiy[i] = s.nextInt();

                    System.out.print("Enter fees paid : ");
                    fepaid[i] = s.nextInt();
                    System.out.println("note: also reenter the stusent marks ......!");
                    break;

                }
            }
        } catch (Exception ex) {
            System.out.println("exception occured....!");
        }

    }

    static int count = 0;

    //accessing student data 
    void allstudent() {
        System.out.println("ID\tName\tClass\t12th Mark\tcontact no\tpresentiy(?/90)\tpaid fee\n-------------------------------------------------------------------------------- ");

        for (int i = 0; i < ct; i++) {
            if (ID[i] >= 1) {
                System.out.print(ID[i] + "\t" + name[i] + "\t" + clas[i] + "\t" + mark[i] + "%" + "\t\t" + contact[i] + "\t" + presentiy[i] + "Days" + "\t\t" + fepaid[i] + "/--" + "\n");
            }
        }
        if (ct == 0) {
            System.out.println("No data found.....!");
        }
    }

    //display marks
    void displaymk() {
        try {
            System.out.println("ID\tName\tJAVA\tRDBMS\tDSA\tCG\tTotal mark\tpercentage\n----------------------------------------------------------------------------");
            for (int i = 0; i < ct; i++) {

                if (ID[i] < 1) {
                    continue;
                }
                System.out.print(ID[i] + "\t" + name[i] + "\t" + JAVA[i] + "\t" + RDBMS[i] + "\t" + DSA[i] + "\t" + CG[i] + "\t" + total[i] + "\t\t" + percent[i] + "%" + "\n");
            }
        } catch (Exception ex) {
            System.out.println("student not found......!");
        }
        //no student found ......! 
    }

//delet student
    void delstud() {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Id to delete student : ");
            int rno = sc.nextInt();
            for (int i = 0; i < ID.length; i++) {
                int temp = ID[i];
                if (temp == rno) {
                    ID[i] = -1;
                    System.out.println("Student deleted!");
                    return;
                }
            }
        } catch (Exception ex) {
            System.out.println("student not found......!");
        }
    }

//search student
    void searchstud() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print("Enter student ID : ");
            int sID = s.nextInt();

            if (sID < 0) {
                System.out.print("student not found");
                return;
            }
            for (int j = 0; j <= 50; j++) {
                if (ID[j] == sID) {
                    System.out.println(" ID\tName\tClass\t12th Mark\tTotal marks\tpercentage\n----------------------------------------------------------------------------");
                    System.out.print(ID[j] + "\t" + name[j] + "\t" + clas[j] + "\t" + mark[j] + "\t\t" + total[j] + "\t\t" + percent[j] + "%" + "\n");
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("student not found......!");
        }

    }

    void fee() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.print(" Enter student ID to see his fees information : ");
            int fID = s.nextInt();
            //change
            if (fID < 0) {
                System.out.print("student not found ......");
                return;
            }
            for (int i = 0; i <= 50; i++) {
                if (fID == ID[i]) {
                    int[] painding = new int[50];
                    painding[i] = fees - fepaid[i];
                    System.out.println("paid by\t\ttotal fee\tpaid fee\tpending fee\n-----------------------------------------------------------");
                    System.out.println(name[i] + "\t\t" + fees + "\t\t" + fepaid[i] + "\t\t" + painding[i]);
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("student not found ......!");
        }
    }

    void allstufee() {
        System.out.println("ID\tName\ttotal fee\tpaid fee\tpending fee\n-----------------------------------------------------------");

        try {
            for (int i = 0; i < ct; i++) {
                int[] pd = new int[50];
                pd[i] = fees - fepaid[i];
                System.out.println(ID[i] + "\t" + name[i] + "\t" + fees + "\t\t" + fepaid[i] + "\t\t" + pd[i]);
            }
        } catch (Exception ex) {
            System.out.println("student not found......!");
        }
        //no student found ......! 
    }

}

//lib start..................................................
class Book {

    int bookID = 0;
    String title;
    String author;

    void inputBookDetails() {
        Scanner sc = new Scanner(System.in);
        try {

            System.out.print("Enter Book ID : ");
            int bnewid = sc.nextInt();
            if (bookID == bnewid) {
                System.out.println("used idddd");
                return;
            }

            bookID = bnewid;

            System.out.print("Enter Book Title : ");
            title = sc.nextLine();
            System.out.print("Enter Author Name : ");
            author = sc.nextLine();
            System.out.println("Book added successfully!");
        } catch (Exception ex) {
            System.out.println("Exception occured......!");
            return;
        }    //change .................
    }

    void displayBook() {
        System.out.println(bookID + "\t" + title + "\t" + author);
    }
}

// Child class: Library (inherits Book)
class Library extends Book {

    Book[] books = new Book[50];
    int count = 0;

    // to add book
    // to add book
    void addBook() {
        if (count >= 50) {
            System.out.println("Library is full");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID : ");
        int newBookID = sc.nextInt();

        // Check...........................
        for (int i = 0; i < count; i++) {
            if (books[i].bookID == newBookID) {
                System.out.println("Book id already exists..............!");
                return;
            }
        }

        sc.nextLine();

        Book b = new Book();
        b.bookID = newBookID;

        System.out.print("Enter Book Title : ");
        b.title = sc.nextLine();

        System.out.print("Enter Author Name : ");
        b.author = sc.nextLine();

        books[count++] = b;
        System.out.println("Book added successfully!");
    }

    // Search Book
    void searchBook() {
        if (count == 0) {
            System.out.println("books are not available.....!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book ID to search : ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (books[i].bookID == id) {
                System.out.println("Book Found : ");
                System.out.println("BookID\tTitle\tAuthor\n----------------------");

                books[i].displayBook();
                return;
            }
        }
        System.out.println("Book not found!");
    }

    // Display all books
    void displayAllBooks() {
        if (count == 0) {
            System.out.println("Library is Empty");
            return;
        }

        System.out.println("All Books in Library : ");
        System.out.println("BookID\tTitle\tAuthor\n----------------------");

        for (int i = 0; i < count; i++) {
            if (books[i] != null) {
                books[i].displayBook();
            }
        }
    }

    //del book
    void delbook() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Id to delete book : ");
            int bno = sc.nextInt();
            for (int i = 0; i < count; i++) {
                int temp = books[i].bookID;
                if (temp == bno) {
                    books[i] = null;
                    System.out.println("book deleted!");
                    return;
                }
            }
        } catch (Exception ex) {
            System.out.println("book not found......!");
        }
    }

}

//lib end....................................................
class student_management_system {

    public static void main(String ar[]) {
        student_management_system stud = new student_management_system();
        studentry ent = new studentry();
        printstud pr = new printstud();
        Library library = new Library();
        Scanner s = new Scanner(System.in);
        char rept;
        char again = 'c';
        while (again == 'c') {

            int dept;
            System.out.println("select any department :  \n 1 - student managment \n 2 - librariy \n 3 - Exit  \n selected: ");
            dept = s.nextInt();
            if (dept == 1) {
                rept = 'y';
                while (rept == 'y') {
                    System.out.println("  which operation you want to do :  \n 1 - add student\n 2 - display students \n 3 - add exam score \n 4 - display exam score \n 5 - search student \n 6 - how meny students are available \n 7 - fees information  \n 8 - update student  \n 9 - fee details list \n 11 - delete student");

                    int stchoise = s.nextInt();
                    pr.stoption(stchoise);

                    System.out.print("\n*Want any service further within Students(y/n) : ");
                    rept = s.next().charAt(0);
                }
            }

            if (dept == 2) {

                char agai = 'y';

                while (agai == 'y') {
                    System.out.println("\nLibrary Operations:");
                    System.out.println("1. Add Book");
                    System.out.println("2. Search Book");
                    System.out.println("3. Display All Books");
                    System.out.println("4. Delete Books");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    Scanner sc = new Scanner(System.in);
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            library.addBook();
                            break;
                        case 2:
                            library.searchBook();
                            break;
                        case 3:
                            library.displayAllBooks();
                            break;
                        case 4:
                            library.delbook();
                            break;
                        case 5:
                            break;

                        default:
                            System.out.println("Wrong input...............!");
                            break;

                    }
                    System.out.println("Do you want to continue operations : (y/n)");
                    agai = s.next().charAt(0);

                }
            }
            System.out.println("Do you want to continue operations : (c/e)");
            again = s.next().charAt(0);
        }
    }
}
