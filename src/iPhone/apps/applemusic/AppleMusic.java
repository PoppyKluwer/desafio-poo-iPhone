package iPhone.apps.applemusic;


import iPhone.sistema.IOS;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AppleMusic extends IOS {

    public void iniciarAppleMusic() {
        System.out.println();
        System.out.println("Bem vindo ao Apple Music, oque deseja escutar?");
        System.out.println();
        selecionarMusica();
    }

    private void selecionarMusica() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> artistas = new ArrayList<>();

        artistas.add("Froid");
        artistas.add("Yung Buda");
        artistas.add("Froid");

        ArrayList<String> musicas = new ArrayList<>();

        musicas.add("Indústria do Medo");
        musicas.add("Piloto");
        musicas.add("Fanfic");

        ArrayList<String> tempo = new ArrayList<>();

        tempo.add("3:00");
        tempo.add("3:34");
        tempo.add("3:23");

        while (true) {
            listaDeMusicas(musicas, artistas);

            System.out.println();
            System.out.println("Escolha a música de acordo com o número correspondente na lista");

            int escolha = scanner.nextInt();


            if (escolha > 0 && escolha <= musicas.size()) {
                try {
                    tocarOUpausar(escolha - 1, musicas, artistas, tempo);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            } else if (escolha == 0) {
                System.out.println("Saindo do menu de músicas.");
                break;
            } else {
                System.out.println("Escolha inválida. Tente Novamente");
                break;
            }
        }
    }

    private void listaDeMusicas(ArrayList<String> musicas, ArrayList<String> artistas) {

        for (int i = 0; i < musicas.size(); i++) {
            System.out.println((i + 1) + "  " + artistas.get(i) + " - " + musicas.get(i));
        }
        System.out.println();
        System.out.println("0 - Sair");
    }

    private boolean tocarOUpausar(int indice, ArrayList<String> musicas, ArrayList<String> artistas, ArrayList<String> tempo) throws IOException {

        boolean paused = false;
        boolean linhaEmBranco = false;

        String[] tempoSplit = tempo.get(indice).split(":");
        int minutos = Integer.parseInt(tempoSplit[0]);
        int segundos = Integer.parseInt(tempoSplit[1]);

        while (minutos > 0 || segundos > 0) {
            if (!linhaEmBranco) {
                System.out.println("");
            }

            while (true) {
                System.out.print("Digite 1 para pausar");
                System.out.print("\r[ Reproduzindo: " + "'" + musicas.get(indice) + "'" + " de " + artistas.get(indice) + " | " + String.format("%02d:%02d", minutos, segundos) + " de " + tempo.get(indice) + " percorridos ]" + "   (Digite 1 para pausar)          ");


                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                segundos--;
                if (segundos < 0) {
                    minutos--;
                    segundos = 59;
                }

                if (System.in.available() > 0) {
                    int input = System.in.read();
                    if (input == '1') {
                        paused = true;
                        System.out.println();
                        System.out.print("[ Reprodução de " + "'" + musicas.get(indice) + "'" + " de " + artistas.get(indice) + " pausada ] ");
                    }
                }

                if (paused) {
                    // Aguarda até que o usuário deseje retomar a reprodução
                    while (true) {
                        int input = System.in.read();
                        System.out.print("   (Digite 2 para retomar a reprodução)               ");
                        if (input == '2') {
                            paused = false;
                            break;
                        }
                    }
                }

                if (minutos == 0 && segundos == 0) {
                    boolean yes = false;
                    boolean no = false;
                    System.out.println("\nMúsica finalizada! Deseja ouvir novamente?");
                    selecionarMusica(); // Chama o método novamente
                    return true;
                }
             }
        } return false;
    }
}