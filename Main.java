package P1;
import java.util.*;
public class Main {
    private static void showCommands() {
        System.out.println("help         - Afiseaza aceasta lista de comenzi");
        System.out.println("add          - Adauga o noua persoana (inscriere)");
        System.out.println("check        - Verifica daca o persoana este inscrisa la eveniment");
        System.out.println("remove       - Sterge o persoana existenta din lista");
        System.out.println("update       - Actualizeaza detaliile unei persoane");
        System.out.println("guests       - Lista de persoane care participa la eveniment");
        System.out.println("waitlist     - Persoanele din lista de asteptare");
        System.out.println("available    - Numarul de locuri libere");
        System.out.println("guests_no    - Numarul de persoane care participa la eveniment");
        System.out.println("waitlist_no  - Numarul de persoane din lista de asteptare");
        System.out.println("subscribe_no - Numarul total de persoane inscrise");
        System.out.println("search       - Cauta toti invitatii conform sirului de caractere introdus");
        System.out.println("quit         - Inchide aplicatia");
    }

    private static void addNewGuest(Scanner sc, GuestsList list) {
        // TO DO:
        String lastName = sc.nextLine();
        String firstName = sc.nextLine();
        String email = sc.nextLine();
        String phoneNumber = sc.nextLine();
        Guest newGuest = new Guest(lastName, firstName, email, phoneNumber);
        list.add(newGuest);
    }

    private static void checkGuest(Scanner sc, GuestsList list) {
        // TO DO:
        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                System.out.println(list.search(lastName,firstName));
                break;
            case 2:
                String email = sc.nextLine();
                System.out.println(list.search(2,email));
                break;
            case 3:
                String phoneNumber = sc.nextLine();
                System.out.println(list.search(3,phoneNumber));
                break;
            default:
                System.out.println("Available options are: 1, 2 and 3");
        }
    }

    private static void removeGuest(Scanner sc, GuestsList list) {
        // TO DO:
        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                list.remove(lastName, firstName);
                break;
            case 2:
                String email = sc.nextLine();
                list.remove(2, email);
                break;
            case 3:
                String phoneNumber = sc.nextLine();
                list.remove(3, phoneNumber);
                break;
            default:
                System.out.println("Available options are: 1, 2 and 3");
        }
    }

    private static void updateGuest(Scanner sc, GuestsList list) {
        // TO DO:
        Guest guest = new Guest();
        int opt = sc.nextInt();
        sc.nextLine();
        switch (opt) {
            case 1:
                String lastName = sc.nextLine();
                String firstName = sc.nextLine();
                guest = list.search(lastName,firstName);
                break;
            case 2:
                String email = sc.nextLine();
                guest = list.search(2,email);
                break;
            case 3:
                String phoneNumber = sc.nextLine();
                guest = list.search(3,phoneNumber);
                break;
        }
        int opt2 = sc.nextInt();
        sc.nextLine();

        switch (opt2) {
            case 1:
                String newLastName = sc.nextLine();
                guest.setLastName(newLastName);
                break;
            case 2:
                String newFirstName = sc.nextLine();
                guest.setFirstName(newFirstName);
                break;
            case 3:
                String newEmail = sc.nextLine();
                guest.setEmail(newEmail);
                break;
            case 4:
                String newPhoneNumber = sc.nextLine();
                guest.setPhoneNumber(newPhoneNumber);
                break;
        }
    }

    private static void searchList(Scanner sc, GuestsList list) {
        // TO DO:
        String s = sc.nextLine();
        List<Guest> x = list.partialSearch(s);
        if (x.size() != 0) {
            for(int i = 0; i < x.size(); i++) {
                System.out.println(x.get(i).toString());
            }
        } else {
            System.out.println("Nothing found");
        }


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();

        GuestsList list = new GuestsList(size);

        boolean running = true;
        while (running) {
            String command = scanner.nextLine();

            switch (command) {
                case "help":
                    showCommands();
                    break;
                case "add":
                    addNewGuest(scanner, list);
                    break;
                case "check":
                    checkGuest(scanner, list);
                    break;
                case "remove":
                    removeGuest(scanner, list);
                    break;
                case "update":
                    updateGuest(scanner, list);
                    break;
                case "guests":
                    list.showGuestsList();
                    break;
                case "waitlist":
                    list.showWaitingList();
                    break;
                case "available":
                    System.out.println("Numarul de locuri ramase: " + list.numberOfAvailableSpots());
                    break;
                case "guests_no":
                    System.out.println("Numarul de participanti: " + list.numberOfGuests());
                    break;
                case "waitlist_no":
                    System.out.println("Dimensiunea listei de asteptare: " + list.numberOfPeopleWaiting());
                    break;
                case "subscribe_no":
                    System.out.println("Numarul total de persoane: " + list.numberOfPeopleTotal());
                    break;
                case "search":
                    searchList(scanner, list);
                    break;
                case "quit":
                    System.out.println("Aplicatia se inchide...");
                    scanner.close();
                    running = false;
                    break;
                default:
                    System.out.println("Comanda introdusa nu este valida.");
                    System.out.println("Incercati inca o data.");
            }
        }
    }
}