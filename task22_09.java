package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String filename = reader.readLine();
        reader.close();
        BufferedReader reader1 = new BufferedReader( new FileReader(filename));
        String[] StrMass ;

        StrMass = reader1.readLine().split(" ");
        reader1.close();

        StringBuilder result = getLine(StrMass);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) throws IOException {
        if (words == null || words.length==0) {return new StringBuilder();}

        List<String> list_of_words = new ArrayList<>();
        list_of_words.addAll(Arrays.asList(words));

        Collections.sort(list_of_words);

        // Устанавливаем 1-ый элемент строки согласно заданию, при этом выдергиваем его из списка
        StringBuilder result =new StringBuilder(list_of_words.get(0));
        list_of_words.remove(0);

        StringBuilder additional = new StringBuilder("");

        while(list_of_words.size()>0){
            for (int i=0;i<list_of_words.size();i++) {
              //  проходим по списку слов до тех пор пока не находим подходящий, если он подходит выдергиваем его из списка
                if (list_of_words.get(i).substring(0,1).toLowerCase().equals(result.substring(result.length()-1).toLowerCase().toString()))
                {
                    result.append(" ").append(list_of_words.get(i));
                    list_of_words.remove(i);
                    break;
                }
                //  если в списке не нашлось подходящего слова, то закидываем элементы списка начиная с последнего в строку для не подходящих слов 
                if(i==list_of_words.size()-1){additional.append(" ").append(list_of_words.get(i)); list_of_words.remove(i);}
            }
        }

        return result.append(additional);
    }
}
