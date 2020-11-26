package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();
        breakPoint:
        while (true) {
            String something = in.nextLine();
            if(something.matches("LIST")){
                phoneBook.printBook();
            }
            else if(something.matches("EXIT")){
                break breakPoint;
            }
            else if(PhoneBook.isName(something)){
                String mayNumber = in.nextLine();
                if(PhoneBook.isPhoneNumber(mayNumber)){
                    phoneBook.addContact(something, mayNumber);
                }
                else{
                    System.out.println("Неправильный ввод");
                }
            }
            else if(PhoneBook.isPhoneNumber(something)){
                String mayName = in.nextLine();
                if(PhoneBook.isName(mayName)){
                    phoneBook.addContact(mayName, something);
                }
                else{
                    System.out.println("Неправильный ввод");
                }
            }

            else{
                System.out.println("Неправильный ввод");
            }
        }
    }
}

