public class ListaDinamicaOrdenada {

    private No primeiro;
    private No ultimo;
    private int contadora;

    public ListaDinamicaOrdenada(){
        primeiro = null;
        ultimo = null;
        contadora = 0;
    }

    public void adicionar(String valor){
        contadora++;
        Main.No novo = new Main.No(valor);
        if(primeiro == null){
            primeiro = novo;
            ultimo = novo;
        }else{
            if(primeiro.dado.compareTo(valor) > 0){
                novo.proximo = primeiro;
                primeiro = novo;
            }else if (ultimo.dado.compareTo(valor) < 0){
                ultimo.proximo = novo;
                ultimo = novo;
            }else{
                Main.No aux = primeiro;
                while (aux != null){
                    if (aux.proximo.dado.compareTo(valor) > 0){
                        novo.proximo = aux.proximo;
                        aux.proximo = novo;
                        break;
                    }
                    aux = aux.proximo;
                }
            }
        }
    }

    public void remover(int posicao){
        if(primeiro != null && posicao >= 0 && posicao < contadora) {
            Main.No aux = primeiro;
            if(posicao == 0){
                primeiro = primeiro.proximo;
            }else {
                int i = 0;  //1
                while (i < posicao - 1) {
                    aux = aux.proximo;
                    i++;
                }
                aux.proximo = aux.proximo.proximo;
                if(posicao == contadora -1){
                    ultimo = aux;
                }
            }
            contadora--;
        }else{
            System.out.println("Posiçao invalida jovem");
        }
    }
    public boolean pesquisar(String valor){
        Main.No aux = primeiro;
        while (aux != null){
            if(aux.dado.equals(valor)){
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }
    public int pesquisarIndice(String valor){
        Main.No aux = primeiro;
        int i = 0;
        while (aux != null) {
            if(aux.dado.equals(valor)){
                return i;
            }
            i++;
            aux = aux.proximo;
        }
        return -1;
    }
    public String pesquisarElemento(int posicao) throws Exception{
        if(posicao >= 0 && posicao < contadora) {
            Main.No aux = primeiro;
            int i = 0;
            while (i < posicao) {
                aux = aux.proximo;
                i++;
            }
            return aux.dado;
        }else{
            throw new Exception("Posição inválida");
        }
    }
    public void exibir(){
        Main.No aux = primeiro;
        int n = 0;
        while (aux != null){
            if(n < tamanho() - 1){
                System.out.print(aux.dado + " ");
            }else{
                System.out.print(aux.dado);
            }
            aux = aux.proximo;
            n++;
        }
        System.out.println();
    }
    public int tamanho(){
        return contadora;
    }
}
