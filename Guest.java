package P1;

import java.util.Scanner;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Guest {

    public String lastName;
    public String firstName;
    public String email;
    public String phoneNumber;

    public Guest() {

    }
    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void setLastName(String newLastName) {
        this.lastName = newLastName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Guest guestObj = (Guest) o;

        if (this.lastName.equals(guestObj.lastName) && this.firstName.equals(guestObj.firstName) &&
            this.email.equals(guestObj.email) && this.phoneNumber.equals(guestObj.phoneNumber)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }

    @Override
    public String toString() {
        // TO DO:
        return "Nume: " + this.lastName + " " + this.firstName + ", Email: " + this.email
                + ", Telefon: " + this.phoneNumber;
    }

    public String fullName() {
        // TO DO:
        return this.lastName + " " + this.firstName;
    }

}
