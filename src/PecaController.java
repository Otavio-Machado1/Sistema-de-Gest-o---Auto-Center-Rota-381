public class PecaController {
    static Peca[] lista = new Peca[100];
    static int total = 0;

    public static void cadastrar() {
        PecaView.cabecalhoCadastro();

        Peca p = new Peca();
        p.codigo     = PecaView.pedirCodigo();
        p.descricao  = PecaView.pedirDescricao();
        p.quantidade = PecaView.pedirQuantidade();
        p.preco      = PecaView.pedirPreco();

        lista[total] = p;
        total++;

        Dados.salvar();

        PecaView.msgSucesso();
        Helper.pressEnter();
    }

    public static void listar() {
        PecaView.cabecalhoListar();

        String codigo    = "";
        String descricao = "";
        int    quantidade = 0;
        double preco     = 0;

        for (int i = 0; i < total; i++) {
            Peca p = lista[i];
            codigo     = p.codigo;
            descricao  = p.descricao;
            quantidade = p.quantidade;
            preco      = p.preco;
        }

        PecaView.mostrarTabela(codigo, descricao, quantidade, preco, total);
        Helper.pressEnter();
    }

    public static int buscar(String codigo) {
        for (int i = 0; i < total; i++) {
            if (lista[i].codigo.equals(codigo)) return i;
        }
        return -1;
    }
}
