import java.util.Scanner;

public class JogoMenu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hp = 100; // HP inicial
        int xp = 0;   // XP inicial
        boolean rodando = true;

        while (rodando && hp >= 0) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Instruções");
            System.out.println("2 - Jogar");
            System.out.println("3 - Créditos");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Instruções
                    System.out.println("\n===== INSTRUÇÕES =====");
                    System.out.println("Explore para ganhar pontos de XP e descanse para recuperar HP.");
                    System.out.println("Se seu HP chegar a 0 ou menos, seu personagem morre e o jogo acaba.\n");
                    break;

                case 2:
                    // Jogar -> submenu
                    boolean noSubmenu = true;
                    while (noSubmenu && hp >= 0) {
                        System.out.println("\n===== JOGAR =====");
                        System.out.println("HP atual: " + hp);
                        System.out.println("XP atual: " + xp);
                        System.out.println("1 - Explorar");
                        System.out.println("2 - Descansar");
                        System.out.println("3 - Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");

                        int opcaoJogo = scanner.nextInt();

                        switch (opcaoJogo) {
                            case 1:
                                // Explorar: -10 HP, +20 XP
                                hp -= 10;
                                xp += 20;
                                System.out.println("\nVocê explorou uma área perigosa!");
                                System.out.println("HP -10, XP +20.");
                                System.out.println("HP atual: " + hp + ", XP atual: " + xp);

                                if (hp < 0) {
                                    System.out.println("\nSeu HP ficou abaixo de 0.");
                                    System.out.println("Seu personagem morreu. Fim de jogo!");
                                    // Sai do submenu e do jogo
                                    noSubmenu = false;
                                    rodando = false;
                                }
                                break;

                            case 2:
                                // Descansar: +15 HP
                                hp += 15;
                                System.out.println("\nVocê descansou e recuperou forças.");
                                System.out.println("HP +15.");
                                System.out.println("HP atual: " + hp + ", XP atual: " + xp);
                                break;

                            case 3:
                                // Voltar ao menu principal
                                System.out.println("\nVoltando ao menu principal...\n");
                                noSubmenu = false;
                                break;

                            default:
                                System.out.println("\nOpção inválida no submenu. Tente novamente.\n");
                        }
                    }
                    break;

                case 3:
                    // Créditos
                    System.out.println("\n===== CRÉDITOS =====");
                    System.out.println("Jogo de exemplo desenvolvido para atividade de Java.");
                    System.out.println("Autor: (seu nome aqui)\n");
                    break;

                case 4:
                    // Sair
                    System.out.println("\nSaindo do jogo. Até mais!");
                    rodando = false;
                    break;

                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
            }

            // Verifica morte fora do submenu (caso queira reforçar a condição)
            if (hp < 0) {
                System.out.println("Seu personagem está morto. O jogo será encerrado.");
                rodando = false;
            }
        }

        scanner.close();
    }
}