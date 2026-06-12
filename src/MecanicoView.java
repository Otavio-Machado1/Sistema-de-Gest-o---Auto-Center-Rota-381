import java.util.Scanner;

public class MecanicoView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void cabecalhoCadastro() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  CADASTRAR MECÂNICO");
        System.out.println("============================================");
    }

    public static void cabecalhoListar() {
        System.out.println();
        System.out.println("============================================");
        System.out.println("  MECÂNICOS CADASTRADOS");
        System.out.println("============================================");
    }

    public static String pedirCodigo() {
        System.out.print("  Código: ");
        return scanner.nextLine().trim();
    }

    public static String pedirNome() {
        System.out.print("  Nome: ");
        return scanner.nextLine().trim();
    }

    public static String pedirEspecialidade() {
        int escolha = 0;
        do {
            System.out.println();
            System.out.println("  Especialidade:");
            System.out.println("  1. Motor");
            System.out.println("  2. Suspensão");
            System.out.println("  3. Elétrica");
            System.out.println("  4. Funilaria");
            System.out.print("  > ");
            try {
                escolha = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                escolha = 0;
            }
            if (escolha < 1 || escolha > 4) {
                System.out.println("  ! Opção inválida.");
            }
        } while (escolha < 1 || escolha > 4);

        switch (escolha) {
            case 1:  return "Motor";
            case 2:  return "Suspensão";
            case 3:  return "Elétrica";
            default: return "Funilaria";
        }
    }

    public static void msgSucesso() {
        System.out.println();
        System.out.println("  Mecânico cadastrado com sucesso!");
    }

    public static void msgErroLimite() {
        System.out.println("  ! Limite de mecânicos atingido.");
    }

    public static void msgErroDuplicado() {
        System.out.println("  ! Código já cadastrado.");
    }

    public static void msgNenhum() {
        System.out.println("  Nenhum mecânico cadastrado.");
    }

    public static void mostrarTabela(String codigo, String nome, String especialidade, int total) {
        System.out.printf("  %-10s  %-25s  %-15s%n", "CÓDIGO", "NOME", "ESPECIALIDADE");
        System.out.println("  --------------------------------------------------");
        for (int i = 0; i < total; i++) {
            Mecanico m = MecanicoController.lista[i];
            System.out.printf("  %-10s  %-25s  %-15s%n", m.codigo, m.nome, m.especialidade);
        }
    }
}
