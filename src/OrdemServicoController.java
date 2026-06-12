public class OrdemServicoController {
    static OrdemServico[] lista = new OrdemServico[100];
    static int total = 0;

    public static void abrir() {
        OrdemServicoView.cabecalhoAbrir();

        String placa = OrdemServicoView.pedirPlaca();
        if (VeiculoController.buscar(placa) == -1) {
            OrdemServicoView.msgErroVeiculoNaoEncontrado();
            Helper.pressEnter();
            return;
        }

        String codMec = OrdemServicoView.pedirCodigoMecanico();
        if (MecanicoController.buscar(codMec) == -1) {
            OrdemServicoView.msgErroMecanicoNaoEncontrado();
            Helper.pressEnter();
            return;
        }

        String codPeca = OrdemServicoView.pedirCodigoPeca();
        int idxPeca = PecaController.buscar(codPeca);
        if (idxPeca == -1) {
            OrdemServicoView.msgErroPecaNaoEncontrada();
            Helper.pressEnter();
            return;
        }

        int qtd = OrdemServicoView.pedirQuantidadePeca();
        Peca peca = PecaController.lista[idxPeca];

        if (peca.quantidade < qtd) {
            OrdemServicoView.msgErroEstoqueInsuficiente(peca.descricao, qtd, peca.quantidade);
            Helper.pressEnter();
            return;
        }

        String numero  = OrdemServicoView.pedirNumero();
        double maoObra = OrdemServicoView.pedirMaoObra();

        peca.quantidade -= qtd;

        OrdemServico os = new OrdemServico();
        os.numero         = numero;
        os.placa          = placa;
        os.codigoMecanico = codMec;
        os.codigoPeca     = codPeca;
        os.quantidadePeca = qtd;
        os.maoObra        = maoObra;

        lista[total] = os;
        total++;

        Dados.salvar();

        OrdemServicoView.msgSucesso();
        Helper.pressEnter();
    }

    public static void listar() {
        OrdemServicoView.cabecalhoListar();

        String numero  = "";
        String placa   = "";
        String codMec  = "";
        String codPeca = "";
        int    qtd     = 0;
        double maoObra = 0;

        for (int i = 0; i < total; i++) {
            OrdemServico os = lista[i];
            numero  = os.numero;
            placa   = os.placa;
            codMec  = os.codigoMecanico;
            codPeca = os.codigoPeca;
            qtd     = os.quantidadePeca;
            maoObra = os.maoObra;
        }

        OrdemServicoView.mostrarTabela(numero, placa, codMec, codPeca, qtd, maoObra, total);
        Helper.pressEnter();
    }
}
