package iPhone.apps.safari;

import iPhone.sistema.IOS;

import java.util.Scanner;

public class Safari extends IOS {

    public void iniciarSafari () {
        exibirPagina();
    }
    public void exibirPagina() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao Safari!!");
        String Opcoes[] = {"\n1 - ABRIR NOVA ABA", "2 - ATUALIZAR PÁGINA\n"};
        System.out.println("Digite o número de acordo com a função que deseja realizar (serviços ainda incompletos)");
        for (String Opcao : Opcoes) {
            System.out.println(Opcao);
        }



        int input = 0;
        input = scanner.nextInt();

        switch (input){
            case 1: {
                adicionarNovaAba();
                break;
            }
            case 2: {
                atualizarPagina();
                break;
            }
        }
    }

    static void adicionarNovaAba() {
        System.out.println("Nova aba aberta!!");

        String Opcoes[] = {"\n1 - ABRIR NOVA ABA", "2 - ATUALIZAR PÁGINA\n"};
        System.out.println("Digite o número de acordo com a função que deseja realizar");
        for (String Opcao : Opcoes) {
            System.out.println(Opcao);
        }

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        switch (input){
            case 1: {
                adicionarNovaAba();
                break;
            }
            case 2: {
                atualizarPagina();
                break;
            }
        }
    }

    static void atualizarPagina() {
        System.out.println("Atualizando página...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Página atualizada !\n");

        String Opcoes[] = {"\n1 - ABRIR NOVA ABA", "2 - ATUALIZAR PÁGINA\n"};
        System.out.println("Digite o número de acordo com a função que deseja realizar");
        for (String Opcao : Opcoes) {
            System.out.println(Opcao);
        }

        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();

        switch (input){
            case 1: {
                adicionarNovaAba();
                break;
            }
            case 2: {
                atualizarPagina();
                break;
            }
        }
    }
}
