package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> to_do_list;
    ToDoList() {
        this.to_do_list = new ArrayList<>();

    }

    public void LIST(){
        for(int i = 0; i < this.to_do_list.size(); i++){
            System.out.println(i+1 + ". " + to_do_list.get(i));
        }
    }

    public void ADD(String deal){
        this.to_do_list.add(deal);
    }

    public void ADD(int index, String deal) {
        this.to_do_list.add(index-1,deal);
    }

    public void EDIT(int index, String deal) {
        this.to_do_list.remove(index-1);
        this.to_do_list.add(index-1,deal);
    }

    public void DELETE(int index) {
        this.to_do_list.remove(index-1);
    }

    public void parse(String text) {
        text = text.trim();
        if(text.matches("LIST")){
            LIST();
        }
        else if(text.matches("^ADD\\s+\\d+\\s+.+")){
            //ADD *номер* *дело*
            text = text.substring(3).trim();
            String[] arr = text.split("\\s");
            for (int i = 0; i < arr.length; i++) { arr[i] = arr[i].trim(); }
            int index = Integer.parseInt(arr[0]);
            String s = "";
            for (int i = 1; i < arr.length; i++) {
                s+=arr[i] + " ";
            }
            ADD(index,s);
        }
        else if (text.matches("^ADD\\s+.+")) {
            text = text.substring(3).trim();
            ADD(text);
        }
        else if(text.matches("^EDIT\\s+\\d+\\s+.+")) {
            String[] arr = text.split("\\s");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].trim();
            }
            int index = Integer.parseInt(arr[1]);
            String s = "";
            for (int i = 2; i < arr.length; i++) {
                s += arr[i] + " ";
            }
            EDIT(index, s);
        } else if (text.matches("^DELETE\\s+\\d+")) {
            String[] arr = text.split("\\s");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].trim();
            }
            int index = Integer.parseInt(arr[1]);
            DELETE(index);
        } else {
            System.out.println("Неправильный ввод");
        }

    }
}

class ToDoListLoader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
        breakpoint:
        while (true) {
            System.out.println("LIST");
            System.out.println("ADD");
            System.out.println("EDIT");
            System.out.println("DELETE");
            System.out.println("EXIT");
            String input = in.nextLine();
            if(input.matches("EXIT")){
                break breakpoint;
            }
            else{
                toDoList.parse(input);
            }
        }
    }
}



