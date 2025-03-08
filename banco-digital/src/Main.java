import java.util.Scanner;
public class Main {
    private static Banco banco = new Banco();
    private static Scanner  scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== MENU DO BANCO =====");
            System.out.println("1. Adicionar Conta Corrente");
            System.out.println("2. Adicionar Conta Poupança");
            System.out.println("3. Mostrar Todas as Contas");
            System.out.println("4. Mostrar Todas as Contas Correntes");
            System.out.println("5. Mostrar Todas as Contas Poupança");
            System.out.println("6. Mostrar Conta Corrente com Maior Saldo");
            System.out.println("7. Mostrar Conta Poupança com Maior Saldo");
            System.out.println("8. Remover Conta");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do titular: ");
                    String nomeCC = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoCC = scanner.nextDouble();
                    banco.addContaCorrente(nomeCC, saldoCC);
                    System.out.println("Conta Corrente adicionada!");
                    break;
                case 2:
                    System.out.print("Nome do titular: ");
                    String nomeCP = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoCP = scanner.nextDouble();
                    banco.addContaPoupanca(nomeCP, saldoCP);
                    System.out.println("Conta Poupança adicionada!");
                    break;
                case 3:
                    banco.MostrarTodasConta();
                    break;
                case 4:
                    System.out.println("Contas Correntes: " + banco.mostrarTodasContaCorrente());
                    break;
                case 5:
                    System.out.println("Contas Poupança: " + banco.mostrarTodasContaPoupanca());
                    break;
                case 6:
                    System.out.println("Conta Corrente com maior saldo: " + banco.mostrarMaiorSaldoContaCorrente());
                    break;
                case 7:
                    System.out.println("Conta Poupança com maior saldo: " + banco.mostrarMaiorSaldoContaPoupanca());
                    break;
                case 8:
                    System.out.print("Número da agência da conta a ser removida: ");
                    int agencia = scanner.nextInt();
                    banco.removerConta(agencia);
                    System.out.println("Conta removida se existente.");
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 9);
        scanner.close();
    }
}
