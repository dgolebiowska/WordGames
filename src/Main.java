import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

//        System.out.println("hello world");
        String[] words = {"zegar", "lampa", "obrazek", "kwiat", "tomek", "stół", "tablica"};
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int fails = 0;//liczba możliwych błędów
        int round = 0;
        // while (true)// cały czas wygrywa
        while (fails <= 3) {
            String word = words[random.nextInt(words.length)];
            String hashWord = word;


            for (int i = 0; i < round; i += 5) {
                char randomChar = hashWord.charAt(random.nextInt(hashWord.length()));
                if (randomChar == '*') {
                    i--;
                    continue;
                }
                hashWord = hashWord.replaceFirst(String.valueOf(randomChar), "*");
            }


            System.out.println("twoje wylosowane słowo " + hashWord);
            System.out.println("podaj słowo");
            String response = sc.next();
            if (word.equalsIgnoreCase(response)) {
                System.out.println("gratulacje");
                round++;
            } else {
                System.out.println("nie udało się odgadnąć");
                fails++;//fajl jeden mniej
            }
        }
        System.out.println("koniec gry twoje punkty: " + (round - fails));

    }

}
