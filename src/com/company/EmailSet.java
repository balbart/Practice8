package com.company;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class EmailSet {
    private TreeSet<String> emails;
    private String regex_add = "^ADD\\s+\\w+[@]\\w+[.]\\w+$";
    private String regex_list = "LIST";
    EmailSet() {
        this.emails = new TreeSet<>();
    }

    public void ADD(String email) {
            this.emails.add(email);
    }

    public void LIST() {
        Iterator iterator = this.emails.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    public String[] parse(String text){
        String[] arr = text.split("\\s");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].trim();
        }
        return arr;
    }

    public void command(String text){
        text = text.trim();
        if(text.matches(this.regex_add)){
            String[] arr = parse(text);
            ADD(arr[1]);
        }
        else if(text.matches(this.regex_list)){
            LIST();
        }
        else{
            System.out.println("неправильный ввод");
        }
    }

}

class EmailSetLoader{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EmailSet emailSet = new EmailSet();
        while(true){
            String input = in.nextLine();
            if(input.matches("EXIT")){
                break;
            }
            else{
                emailSet.command(input);
            }
        }
    }
}
