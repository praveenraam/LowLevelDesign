package Services;

import Models.Books;
import Models.Member;

import java.util.Scanner;

public class Inphandler {

    static Scanner inputGather = new Scanner(System.in);

    public void start(){

        while(true){

            String output1 = "Press No " +
                    "\n - Enter 1 for Member Login" +
                    "\n - Enter 2 for Librarian Login" +
                    "\n - Enter 3 for Login Member"
                    /* + "\n - Enter 4 for Add book" +
                    "\n - Enter 5 for Remove book" */
                    ;

            System.out.println(output1);

            int inp1 = inputGather.nextInt();
            inputGather.nextLine();

            if(inp1 == 1){

                String output2 = "Enter the email : ";
                System.out.println(output2);
                String email = inputGather.nextLine();

                String output3 = "Enter the password : ";
                System.out.println(output3);
                String password = inputGather.nextLine();

                Member currMember = Member.checkLogin(email,password);

                if(currMember != null) {
                    while (true) {

                        String output4 = "Press No " +
                                "\n - Enter 1 Checkout Book" +
                                "\n - Enter 2 Return Book " +
                                "\n - Enter 3 to logout";
                        System.out.println(output4);
                        int inp2 = inputGather.nextInt();
                        inputGather.nextLine();

                        if (inp2 == 1) {

                            String output5 = "Enter the book name : ";
                            System.out.println(output5);
                            String bookName = inputGather.nextLine();

                            Books book = Books.searchBook(bookName);

                            if(book == null){
                                System.out.println("No book found");
                                continue;
                            }
                            else if(book.getCurrHolder() == null){
                                System.out.println("Book already borrowed");
                                continue;
                            }

                            book.setCurrHolder(currMember);
                            currMember.borrowBook(book);
                            System.out.println("Book is given");

                        } else if (inp2 == 2) {

                            String output5 = "Enter the book name : ";
                            System.out.println(output5);
                            String bookName = inputGather.nextLine();

                            Books book = Books.searchBook(bookName);
                            if(book == null){
                                System.out.println("No book found");
                                continue;
                            }
                            book.setCurrHolder(null);
                            currMember.returnBook(book);
                            System.out.println("Book is returned");

                        }
                        else if (inp2 == 3) {
                            break;
                        }
                        else {
                            System.out.println("Give a valid input");
                        }
                    }
                }
                else{
                    System.out.println("Enter valid credentials");
                }

            }
            else if(inp1 == 2){

            }
            else if(inp1 == 3){



            }
            else if(inp1 == 4){

                String output2 = "Enter the book name : ";
                System.out.println(output2);
                String bookName = inputGather.nextLine();

                String output3 = "Enter the author : ";
                System.out.println(output3);
                String authorName = inputGather.nextLine();

                Books newBook = new Books(bookName,authorName);
                System.out.println("Book Id is " + newBook.getId());
            }
            else if(inp1 == 5){

                String output2 = "Enter the book Id : ";
                System.out.println(output2);
                Long id = inputGather.nextLong();
                inputGather.nextLine();

            }
            else{
                System.out.println("Give valid input");
            }
        }

    }


}
