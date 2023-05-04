package P1;
import java.util.*;
public class GuestsList {

    public int guestsCapacity;
    public ArrayList<Guest> listaParticipare = new ArrayList<>();
    public ArrayList<Guest> listaAsteptare = new ArrayList<>();

    public GuestsList(int guestsCapacity) {
        this.guestsCapacity = guestsCapacity;
    }

    /**
     * Add a new, unique guest to the list.
     *
     * @param g the guest to be added
     */
    public void add(Guest g) {
        // TO DO:
        if (listaParticipare.size() != guestsCapacity) {
            listaParticipare.add(g);
            System.out.println("[" + g.lastName + " " + g.firstName + "]" +
                    " Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
        } else {
            listaAsteptare.add(g);
            System.out.println("[" + g.lastName + " " + g.firstName + "]" +
                    " Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
                    (listaAsteptare.size()) + ". Te vom notifica daca un loc devine disponibil.");
        }
    }

    /**
     * Check if someone is already registered (either as a guest, or on the waiting
     * list).
     *
     * @param g the guest we are searching for
     * @return true if present, false if not
     */
    private boolean isOnTheListAlready(Guest g) {
        // TO DO:
        for (Guest guest : listaParticipare) {
            if (g.equals(guest)) {
                return true;
            }
        }

        for (Guest guest : listaAsteptare) {
            if (g.equals(guest)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Search for a guest based on first and last name. Return the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return the guest if found, null if not
     */
    public Guest search(String lastName, String firstName) {
        // TO DO:
        for(Guest guest : listaParticipare) {
            if (firstName.equalsIgnoreCase(guest.firstName) && lastName.equalsIgnoreCase(guest.lastName)) {
                return guest;
            }
        }
        for(Guest guest : listaAsteptare) {
            if (firstName.equalsIgnoreCase(guest.firstName) && lastName.equalsIgnoreCase(guest.lastName)) {
                return guest;
            }
        }
        return null;
    }

    /**
     * Search for a guest based on email or phone number. Return the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return the guest if found, null if not
     */

    public Guest search(int opt, String match) {
        // TO DO:
        switch(opt) {
            case 2:
                for(Guest guest : listaParticipare) {
                    if (guest.email.equals(match)) {
                        return guest;
                    }
                }
                for(Guest guest : listaAsteptare) {
                    if (guest.email.equals(match)) {
                        return guest;
                    }
                }
                break;
            case 3:
                for(Guest guest : listaParticipare) {
                    if (guest.phoneNumber.equals(match)) {
                        return guest;
                    }
                }
                for(Guest guest : listaAsteptare) {
                    if (guest.phoneNumber.equals(match)) {
                        return guest;
                    }
                }
                break;
            default:
                return null;

        }
        return null;
    }

    /**
     * Remove a guest based on first and last name. Remove the first result.
     *
     * @param firstName first name of the guest
     * @param lastName  last name of the guest
     * @return true if removed, false if not
     */
    public boolean remove(String lastName, String firstName) {
        // TO DO:
        if (listaParticipare != null) {
            for(Guest guest : listaParticipare) {
                if (firstName.equals(guest.firstName) && lastName.equals(guest.lastName)) {
                    listaParticipare.remove(guest);
                    removeAndAdd();
                    return true;
                }
            }
        }
        return false;
    }

    public void removeAndAdd() {
        if (listaAsteptare.size() != 0) {
            listaParticipare.add(listaAsteptare.get(0));
            System.out.println("Felicitari " + listaAsteptare.get(0).lastName + " " +
                    listaAsteptare.get(0).firstName + "! Locul tau la eveniment este confirmat. Te asteptam!");
            listaAsteptare.remove(0);
        }
    }

    /**
     * Remove a guest based on email or phone number. Remove the first result.
     *
     * @param opt   option to use for searching: 2 for email, 3 for phone number
     * @param match the match we are searching for
     * @return true if removed, false if not
     */
    public boolean remove(int opt, String match) {
        // TO DO:
        switch (opt) {
            case 2:
                if (listaParticipare != null) {
                    for (Guest guest : listaParticipare) {
                        if (guest.email.equals(match)) {
                            listaParticipare.remove(guest);
                            removeAndAdd();
                            return true;
                        }
                    }
                    return false;
                }

                if (listaAsteptare != null) {
                    for(Guest guest : listaAsteptare) {
                        if (guest.email.equals(match)) {
                            listaAsteptare.remove(guest);
                            return true;
                        }
                    }
                    return false;
                }
            case 3:
                if (listaParticipare != null) {
                    for (Guest guest : listaParticipare) {
                        if (guest.phoneNumber.equals(match)) {
                            listaParticipare.remove(guest);
                            removeAndAdd();
                            return true;
                        }
                    }
                    return false;
                }
                if (listaAsteptare != null) {
                    for (Guest guest : listaAsteptare) {
                        if (guest.phoneNumber.equals(match)) {
                            listaAsteptare.remove(guest);
                            return true;
                        }
                    }
                    return false;
                }
        }
        return false;
    }

    // Show the list of guests.
    public void showGuestsList() {
        // TO DO:
        if (listaParticipare.size() == 0) {
            System.out.println("Nothing found");
        } else {
            int index = 1;
            for (Guest guest : listaParticipare) {
                System.out.println(index + ". " + guest.toString());
                index++;
            }
        }
    }

    // Show the people on the waiting list.
    public void showWaitingList() {
        // TO DO:
        if (listaAsteptare.size() == 0) {
            System.out.println("Lista de asteptare este goala...");
        } else {
            int index = 1;
            for (Guest guest : listaAsteptare) {
                System.out.println(index + ". " + guest.toString());
                index++;
            }
        }
    }

    /**
     * Show how many free spots are left.
     *
     * @return the number of spots left for guests
     */
    public int numberOfAvailableSpots() {
        // TO DO:
        return this.guestsCapacity - listaParticipare.size();
    }

    /**
     * Show how many guests there are.
     *
     * @return the number of guests
     */
    public int numberOfGuests() {
        // TO DO:
        return listaParticipare.size();
    }

    /**
     * Show how many people are on the waiting list.
     *
     * @return number of people on the waiting list
     */
    public int numberOfPeopleWaiting() {
        // TO DO:
        return listaAsteptare.size();
    }

    /**
     * Show how many people there are in total, including guests.
     *
     * @return how many people there are in total
     */
    public int numberOfPeopleTotal() {
        // TO DO:
        return listaAsteptare.size() + listaParticipare.size();
    }

    /**
     * Find all people based on a partial value search.
     *
     * @param match the match we are looking for
     * @return a list of people matching the criteria
     */
    public List<Guest> partialSearch(String match) {
        // TO DO:
        List<Guest> matches = new ArrayList<>();
        for (Guest guest : listaParticipare) {
            if (guest.firstName.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.lastName.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.email.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.phoneNumber.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }
        }

        for (Guest guest : listaAsteptare) {
            if (guest.firstName.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.lastName.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.email.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }else if (guest.phoneNumber.toLowerCase().contains(match.toLowerCase())) {
                matches.add(guest);
            }
        }
        return matches;
    }
}
