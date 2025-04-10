import java.util.Scanner;

public class Desafio {
    public static void presentation(String name, double balance, String account) {
        String customerData = """
            *********************************
            Nome:           %s
            Tipo de conta:  %s
            Saldo inicial:  R$ %.2f
            *********************************
            
            """;
        System.out.printf(customerData, name, account, balance);
    }

    public static void operations(double balance) {
        int i = 0;
        double amountToReceive;
        double amountToWithdraw;
        Scanner sc = new Scanner(System.in);

        String options = """
            \nOperações
           
            1 - Consultar saldos
            2 - Receber valor
            3 - Transferir valor
            4 - Sair
           
            Digite a opção desejada:\s""";

        while (i != 4) {
            System.out.print(options);
            i = sc.nextInt();

            switch (i) {
                case 1:
                    System.out.printf("O saldo atual é R$%.2f\n", balance);
                    break;
                case 2:
                    System.out.print("Valor a receber: R$");
                    amountToReceive = sc.nextDouble();
                    balance += amountToReceive;
                    System.out.printf("Novo saldo: R$%.2f", balance);
                    break;
                case 3:
                    System.out.print("Valor que deseja transferir: R$");
                    amountToWithdraw = sc.nextDouble();

                    if (amountToWithdraw > balance) {
                        System.out.printf("O valor é maior do que o saldo! Digite um valor menor ou igual a R$%.2f!\n", balance);
                    } else {
                        balance -= amountToWithdraw;
                        System.out.printf("Novo saldo: R$%.2f", balance);
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Insira uma opção válida!");
            }
        }
    }

    public static void main(String[] args) {
        String customerName = "Lucas Santos";
        double customerInitialBalance = 2083.33;
        String accountType = "Corrente";

        presentation(customerName, customerInitialBalance, accountType);
        operations(customerInitialBalance);
    }
}
