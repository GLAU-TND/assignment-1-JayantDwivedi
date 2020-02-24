package Menu;

import DataStructures.MyLinkedList;
import Node.Node;
import Person.Person;

import java.util.Scanner;

public class Menu {
    private MyLinkedList<Person> linkedList;
    private Scanner scan;

    public Menu() {
        scan = new Scanner(System.in);
        linkedList = new MyLinkedList<>();
    }

    public int showChoice() {
        System.out.println("Welcome to  Contact List App\n" +
                "Press 1 to add a new contact\n" +
                "Press 2 to view all contacts\n" +
                "Press 3 to search for a contact\n" +
                "Press 4 to delete a contact\n" +
                "Press 5 to exit program");
        return scan.nextInt();
    }

    public void addChoice() {
        Person Person = new Person();
        String name;
        System.out.println("You have chosen to add a new contact: \n" +
                "Please enter the name of the Person\n");
        scan.nextLine();

        System.out.print("First Name: ");
        name = scan.nextLine().trim();
        Person.setFirstName(name);

        System.out.print("Last Name: ");
        name = scan.nextLine().trim();
        Person.setLastName(name);

        String number;
        System.out.print("Contact Number: ");
        number = scan.nextLine().trim();
        Person.setPhoneNumbers(number);

        char c;
        System.out.print("Would you like to add another contact number? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        while (c == 'y') {
            System.out.print("Contact Number: ");
            number = scan.nextLine().trim();
            Person.setPhoneNumbers(number);

            System.out.print("Would you like to add another contact number? (y/n): ");
            c = scan.nextLine().trim().charAt(0);
        }


        String email = null;
        System.out.print("Would you like to add email address? (y/n): ");
        c = scan.nextLine().trim().charAt(0);
        if (c == 'y') {
            System.out.print("Email Address: ");
            email = scan.nextLine().trim();
            Person.setEmailID(email);
        } else {
            Person.setEmailID("");
        }

        Node<Person> Node = new Node<Person>();
        Node.setData(Person);
        linkedList.insert(Node);
    }

    private void sortList(MyLinkedList<Person> linkedList) {
        linkedList.sort();
    }

    public void viewChoice() {
        sortList(linkedList);
        while (true) {
            Node<Person> Node = linkedList.getObject();
            if (Node == null)
                break;
            System.out.println(Node.getData());
        }
    }

    public void searchChoice() {
        int counter = 0;
        System.out.print("You could search for a contact from their first names: ");
        scan.nextLine();
        String name = scan.nextLine().trim();

        while (true) {
            Node<Person> Node = linkedList.getObject();
            if (Node == null)
                break;
            if (Node.getData().getFirstName().compareTo(name) == 0)
                counter++;
        }

        System.out.println(counter + " match found!");
        while (true) {
            Node<Person> Node = linkedList.getObject();
            if (Node == null)
                break;
            if (Node.getData().getFirstName().compareTo(name) == 0)
                System.out.println(Node.getData());
        }
    }

    public void deleteChoice() {
        System.out.println("Here are all your contacts:");
        int i = 1;
        while (true) {
            Node<Person> Node = linkedList.getObject();
            if (Node == null)
                break;
            System.out.println(i + ". " + Node.getData().getFirstName() + " " + Node.getData().getLastName());
            i++;
        }
        System.out.print("Press the number against the contact to delete it: ");
        int position = scan.nextInt();
        Person Person = linkedList.delete(position).getData();

        System.out.println(Person.getFirstName() + " " + Person.getLastName() + "'s contact deleted from list!");
    }

    public void exitChoice() {
        System.out.println("Exiting");
    }
}