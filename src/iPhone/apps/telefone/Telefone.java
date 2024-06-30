package iPhone.apps.telefone;



import iPhone.sistema.IOS;

import java.util.Random;
import java.util.Scanner;

public class Telefone extends IOS {

    public void iniciarTelefone () {

        ligacaoRandom();

         Scanner scanner = new Scanner(System.in);

        System.out.println("\nOque deseja fazer?");
        String opcoes [] = {"\n1 - Ligar" , "2 - Ouvir correio de voz\n"};
        for (String opcao : opcoes) {
            System.out.println(opcao);
        }

        int input = scanner.nextInt();
        if (input == 1) {
            ligar();
        } else if (input == 2) {
            iniciarCorreioVoz();
        }
    }

    public void ligar() {
        try {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite aqui o número a ligar");
        System.out.println("(DDD + Número)\n");

        String numero = scanner.next();
        String DDD = numero.substring(0, 2);
        String prefixo = numero.substring(2, 7);
        String sufixo = numero.substring(7);

            if (numero.length() != 11){
                throw new NumeroErradoException();
            }

            System.out.println("\nDiscando para +" + DDD + " " + prefixo + "-" + sufixo);

        } catch (NumeroErradoException e) {
            System.out.println("Numero inválido. Por favor tente novamente");
            ligar();
        }
        System.out.println("Discando...");
        discando();
    }

    private static void atender() {
        System.out.println("ligação atendida!");
    }

    private static void iniciarCorreioVoz() {
        System.out.println("");
    }

    private boolean ligacaoRandom () {
        Scanner scanner = new Scanner(System.in);

                boolean ligacao = true;
                if (ligacao){
                    System.out.println("ligação de " + ligacaoAleatoria()+ " deseja atender?");
                    String Opcoes[] = {"\n    1 - ATENDER  " + "  2 - RECUSAR\n"};
                    System.out.println("Digite o número de acordo com a função que deseja realizar");
                    for (String Opcao : Opcoes) {
                        System.out.println(Opcao);
                    }


                    int input = scanner.nextInt();

                    if (input == 1){
                        atender();
                    } else if ( input == 2) {
                        System.out.println("Ligação recusada");
                    } else {
                        System.out.println("Ligação perdida! Você agora tem um correio de voz, deseja ouvir?");
                        System.out.println("Digite 1 caso deseje escutar, 2 caso não queira escutar");

                        input = scanner.nextInt();

                        if (input == 1){
                            iniciarCorreioVoz();
                        } else if ( input == 2) {
                            System.out.println("Correio de voz recusado!");
                        }
                    }
                }
                //negando o ato de continuar tocando
                return !ligacao;
    }

    private String ligacaoAleatoria() {

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        // First three digits (area code)
        sb.append(random.nextInt(10)); // Range: 200-999
        sb.append(random.nextInt(10));
        sb.append(" ");

        // Next three digits
        sb.append(random.nextInt(10)); // Primeiro dígito
        sb.append(random.nextInt(10)); // Segundo dígito
        sb.append(random.nextInt(10)); // Terceiro dígito
        sb.append(random.nextInt(10)); // Quarto dígito
        sb.append("-");

        // Last four digits
        sb.append(random.nextInt(10)); // Primeiro dígito
        sb.append(random.nextInt(10)); // Segundo dígito
        sb.append(random.nextInt(10)); // Terceiro dígito
        sb.append(random.nextInt(10)); // Quarto dígito
        sb.append(random.nextInt(10)); // Quarto dígito

        return sb.toString();
    }


    public boolean discando() {
        try {
        boolean atendeu = new Random().nextInt(3) == 1;
            Thread.sleep(5000);
            if (!atendeu){
                System.out.println("\nALÔ?");
            }
            else {
                System.out.println("\nLigação não atendida, tente novamente");
                ligar();
            }
            //negando o ato de continuar tocando
            return !atendeu;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
