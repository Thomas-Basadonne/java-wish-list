package org.lessons.java.christmas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListaRegaliNatale {
    public static void main(String[] args) {
        ArrayList<String> listaRegali = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci i regali nella lista.");
        String regalo;
        do {
            System.out.print("Inserisci il nome del regalo: ");
            regalo = scanner.nextLine();

            listaRegali.add(regalo);
            System.out.println("Lunghezza della lista: " + listaRegali.size());

            System.out.print("Vuoi aggiungere un altro regalo? (y/n): ");
            String continua = scanner.nextLine();
            if (continua.equalsIgnoreCase("n")) {
                break;
            }
        } while (true);

        Collections.sort(listaRegali);

        System.out.println("Lista dei regali ordinata:");
        for (String regaloOrdinato : listaRegali) {
            System.out.println(regaloOrdinato);
        }

        // Salvataggio su file
        File file = new File("gifts.txt");
        try (FileWriter writer = new FileWriter(file)) {
            for (String regaloSalvato : listaRegali) {
                writer.write(regaloSalvato + "\n");
            }
            System.out.println("Lista dei regali salvata su file.");
        } catch (IOException e) {
            throw new RuntimeException("Errore durante la scrittura su file.", e);
        }
    }
}
