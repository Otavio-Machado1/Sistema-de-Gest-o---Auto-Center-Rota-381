import java.io.*;

public class Dados {
    private static final String DIR      = "dados/";
    private static final String MECANICOS = DIR + "mecanicos.csv";
    private static final String VEICULOS  = DIR + "veiculos.csv";
    private static final String PECAS     = DIR + "pecas.csv";
    private static final String ORDENS    = DIR + "ordens.csv";

    public static void carregar() {
        new File(DIR).mkdirs();
        carregarMecanicos();
        carregarVeiculos();
        carregarPecas();
        carregarOrdens();
    }

    public static void salvar() {
        new File(DIR).mkdirs();
        salvarMecanicos();
        salvarVeiculos();
        salvarPecas();
        salvarOrdens();
    }

    // ── MECÂNICOS ────────────────────────────────────────────────────────────

    private static void salvarMecanicos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MECANICOS))) {
            for (int i = 0; i < MecanicoController.total; i++) {
                Mecanico m = MecanicoController.lista[i];
                pw.println(m.codigo + ";" + m.nome + ";" + m.especialidade);
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao salvar mecânicos: " + e.getMessage());
        }
    }

    private static void carregarMecanicos() {
        File f = new File(MECANICOS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            MecanicoController.total = 0;
            while ((linha = br.readLine()) != null && MecanicoController.total < 100) {
                String[] p = linha.split(";", -1);
                if (p.length < 3) continue;
                Mecanico m = new Mecanico();
                m.codigo        = p[0];
                m.nome          = p[1];
                m.especialidade = p[2];
                MecanicoController.lista[MecanicoController.total++] = m;
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao carregar mecânicos: " + e.getMessage());
        }
    }

    // ── VEÍCULOS ─────────────────────────────────────────────────────────────

    private static void salvarVeiculos() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(VEICULOS))) {
            for (int i = 0; i < VeiculoController.total; i++) {
                Veiculo v = VeiculoController.lista[i];
                pw.println(v.placa + ";" + v.nomeDono + ";" + v.modelo);
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao salvar veículos: " + e.getMessage());
        }
    }

    private static void carregarVeiculos() {
        File f = new File(VEICULOS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            VeiculoController.total = 0;
            while ((linha = br.readLine()) != null && VeiculoController.total < 100) {
                String[] p = linha.split(";", -1);
                if (p.length < 3) continue;
                Veiculo v = new Veiculo();
                v.placa    = p[0];
                v.nomeDono = p[1];
                v.modelo   = p[2];
                VeiculoController.lista[VeiculoController.total++] = v;
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao carregar veículos: " + e.getMessage());
        }
    }

    // ── PEÇAS ────────────────────────────────────────────────────────────────

    private static void salvarPecas() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(PECAS))) {
            for (int i = 0; i < PecaController.total; i++) {
                Peca p = PecaController.lista[i];
                pw.println(p.codigo + ";" + p.descricao + ";" + p.quantidade + ";" + p.preco);
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao salvar peças: " + e.getMessage());
        }
    }

    private static void carregarPecas() {
        File f = new File(PECAS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            PecaController.total = 0;
            while ((linha = br.readLine()) != null && PecaController.total < 100) {
                String[] p = linha.split(";", -1);
                if (p.length < 4) continue;
                Peca peca = new Peca();
                peca.codigo     = p[0];
                peca.descricao  = p[1];
                peca.quantidade = Integer.parseInt(p[2]);
                peca.preco      = Double.parseDouble(p[3]);
                PecaController.lista[PecaController.total++] = peca;
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao carregar peças: " + e.getMessage());
        }
    }

    // ── ORDENS DE SERVIÇO ────────────────────────────────────────────────────

    private static void salvarOrdens() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ORDENS))) {
            for (int i = 0; i < OrdemServicoController.total; i++) {
                OrdemServico os = OrdemServicoController.lista[i];
                pw.println(os.numero + ";" + os.placa + ";" + os.codigoMecanico + ";" +
                           os.codigoPeca + ";" + os.quantidadePeca + ";" + os.maoObra);
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao salvar ordens: " + e.getMessage());
        }
    }

    private static void carregarOrdens() {
        File f = new File(ORDENS);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String linha;
            OrdemServicoController.total = 0;
            while ((linha = br.readLine()) != null && OrdemServicoController.total < 100) {
                String[] p = linha.split(";", -1);
                if (p.length < 6) continue;
                OrdemServico os = new OrdemServico();
                os.numero         = p[0];
                os.placa          = p[1];
                os.codigoMecanico = p[2];
                os.codigoPeca     = p[3];
                os.quantidadePeca = Integer.parseInt(p[4]);
                os.maoObra        = Double.parseDouble(p[5]);
                OrdemServicoController.lista[OrdemServicoController.total++] = os;
            }
        } catch (IOException e) {
            System.out.println("  ! Erro ao carregar ordens: " + e.getMessage());
        }
    }
}
