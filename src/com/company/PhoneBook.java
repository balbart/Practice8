package com.company;

import java.util.*;

public class PhoneBook {
    Map<String, String> phoneBook = new HashMap<>();//key - name, value - phone number

    PhoneBook(){}

    public void addContact(String name, String phoneNumber){
        if(isName(name) && isPhoneNumber(phoneNumber)){
            name = capitalize(name);
            phoneNumber = parseNumber(phoneNumber);
            if(!(phoneBook.containsValue(phoneNumber) || phoneBook.containsKey(name))){
                phoneBook.put(name, phoneNumber);
                System.out.println("Номер успешно добавлен");
                sortMap();
            }
            else{
                System.out.println("Номер и/или Имя уже есть в книге");
            }
        }
        else{
            System.out.println("Неправильный ввод");;
        }

    }

    public void printBook() {

        for(Map.Entry<String,String> entry: this.phoneBook.entrySet()){
            System.out.println("Имя: \"" + entry.getKey() + "\" Номер телефона: \"" + entry.getValue() + "\"");
        }
    }

    public static boolean isName(String mayBeName) {
        if(mayBeName.matches("[a-zA-Zа-яА-Я]+")){
            return true;
        }
        else{
            return false;
        }
    }


    public static boolean isPhoneNumber(String mayBePhoneNumber) {
        if (mayBePhoneNumber.matches("^[+]?[7-8]?\\s?[(-]?[0-9]{3}[)-]?\\s?[0-9]{3}[-]?[0-9]{2}[-]?[0-9]{2}$")) {
            return true;
        } else {
            return false;
        }
    }


    private String capitalize(String s){
        String buff = s.substring(0,1).toUpperCase();
        buff+=s.substring(1).toLowerCase();
        return buff;
    }


    private String parseNumber(String text){
        ArrayList<Character> arrayList = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            if((int)text.charAt(i) >47 && (int)text.charAt(i)< 58){
                arrayList.add(text.charAt(i));
            }
        }
        String parsedNumber = "+7 (";
        if(arrayList.size() == 10){
            for(int i = 0; i < 3; i++){
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+=") ";
            for (int i = 3; i < 6; i++) {
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+="-";
            for(int i = 6; i < 8; i++){
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+= "-";
            for (int i = 8; i < 10; i++) {
                parsedNumber += arrayList.get(i);
            }
        }
        else if(arrayList.size() == 11){
            arrayList.remove(0);
            for(int i = 0; i < 3; i++){
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+=") ";
            for (int i = 3; i < 6; i++) {
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+="-";
            for(int i = 6; i < 8; i++){
                parsedNumber+=arrayList.get(i);
            }
            parsedNumber+= "-";
            for (int i = 8; i < 10; i++) {
                parsedNumber += arrayList.get(i);
            }
        }
        return parsedNumber;
    }


    private void sortMap(){
        this.phoneBook = new TreeMap<>(this.phoneBook);
    }
}
