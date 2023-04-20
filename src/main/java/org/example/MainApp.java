package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.records.Carte;

import java.io.*;
import java.util.*;

public class MainApp {
    public static void scriere(Map<Integer, Carte> map) throws IOException {

            var mapper=new ObjectMapper();
            var file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,map);

    }
    public static Map<Integer, Carte> citire() throws IOException{
            var file = new File("src/main/resources/carti.json");
            var mapper = new ObjectMapper();
            var map = mapper.readValue(file, new TypeReference<Map<Integer, Carte>>() {
            });
            return map;
    }
    public static void main(String[] args) throws IOException {
        Map<Integer, Carte> map = new HashMap<Integer, Carte>();
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        map = citire();
        var entriyset = map.entrySet();
        var it = entriyset.iterator();

       do{
            System.out.println("---Meniu---");
            System.out.println("0)Iesire");
            System.out.println("1) Să se afișeze colecția (se vor afișa atât cheile cât şi valorile, utilizând inferenţa tipului\n" +
                    "pentru variabilele locale).\n" +
                    "2) Să se șteargă o carte din colecția Map\n" +
                    "3) Să se adauge o carte la colecția Map (se va utiliza metoda putIfAbsent)\n" +
                    "4) Sa se salveze în fișierul JSON modificările făcute asupra colecției\n" +
                    "5) Să se creeze o colecție Set<Carte> care extrage din colecția Map cărțile autorului\n" +
                    "Yual Noah Harari. Se va utiliza Stream API şi colectori. Se va afișa colecția creată cu\n" +
                    "ajutorul metodei forEach.\n" +
                    "6) Să se afișeze ordonat după titlul cărți elementele din colecția Set folosind Stream API,\n" +
                    "expresii Lambda şi referințe la metode.\n" +
                    "7) Să se afișeze datele celei mai vechi cărți din colecția Set folosind Stream API şi clasa\n" +
                    "Optional. ");
            System.out.println("Dati optiunea: ");
            int opt = scanner.nextInt();
            switch (opt){
                default:
                    System.out.println("Optiune invalida");
                    break;
                case 0: System.exit(0);
                case 1:
                    System.out.println(map);
                break;
                case 2:
                    System.out.println("Dati titlul cartii de sters");
                    String nume = reader.readLine();

                    while(it.hasNext()){

                        var m = it.next();
                        String tit = m.getValue().titlul();
                        if(nume.equalsIgnoreCase(tit)){
                            it.remove();
                        }
                    }
                break;
                case 3:
                    System.out.println("Dati titlul: ");
                    String ntit = reader.readLine();
                    System.out.println("Dati autorul: ");
                    String naut = reader.readLine();
                    System.out.println("Dati anul: ");
                    int nan = scanner.nextInt();

                    map.putIfAbsent(map.size()+1, new Carte(ntit, naut, nan));
                    break;
                case 4:
                    scriere(map);
                    break;

                case 5:
                    if(map.)


            }
        }while(true);
    }


}
