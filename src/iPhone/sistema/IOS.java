package iPhone.sistema;

import iPhone.apps.applemusic.AppleMusic;
import iPhone.apps.safari.Safari;
import iPhone.apps.telefone.Telefone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IOS {
    public void iniciarSistema() throws IOException {
        System.out.println("Olá, sou um proptype de um IOS, não é o muito oque posso fazer por aqui, o que deseja fazer?");
        System.out.println("Digite o número correspondente ao aplicativo que deseja executar");

        String Aplicativos[] = {"\n1 - AppleMusic", "2 - Safari", "3 - Telefone\n"};
        for(String Aplicativo : Aplicativos) {
            System.out.println(Aplicativo);
        }
        abrirApps();

    }

    public void abrirApps() throws IOException {

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        if (input > 3) {
            System.out.println("Opção inválida! Por favor digite um número correspondente aos aplicativos da disponíveis");
        }

        switch (input) {
            case 1: {
                AppleMusic appleMusic = new AppleMusic();
                appleMusic.iniciarAppleMusic();
            }
            case 2: {
                Safari safari = new Safari();
                safari.iniciarSafari();
                break;
            }
            case 3: {
                Telefone telefone = new Telefone();
                telefone.iniciarTelefone();
            }
        }
    }
}

