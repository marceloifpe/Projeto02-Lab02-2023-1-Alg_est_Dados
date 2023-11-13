package array;
/*Marcelo Augusto de Barros Araújo. */
import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar{

    private int[] array;
    private int indice_final;

    public ListaArray() {

    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < indice_final; i++) {
            if (array[i] == valor){
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if ((valor < 0) || (valor >= indice_final)){
            return -1;
        }
        return array[valor];
    }

    @Override
    public int minimo() {
        if (indice_final == 0) {
            return Integer.MAX_VALUE; // Valor padrão para array vazio
        }

        int valorMinimo = array[0];
        for (int i = 1; i < indice_final; i++) {
            if (array[i] < valorMinimo) {
                valorMinimo = array[i];
            }
        }
        return valorMinimo;
    }

    @Override
    public int maximo() {
        if (indice_final == 0) {
            return Integer.MIN_VALUE; // Valor padrão para array vazio
        }

        int valorMaximo = array[0];
        for (int i = 1; i < indice_final; i++) {
            if (array[i] > valorMaximo) {
                valorMaximo = array[i];
            }
        }
        return valorMaximo;
    }

     @Override
    public int predecessor(int valor) {
        if ((valor > 1) && (valor < indice_final)) {
            return array[valor - 1];
        } else {
            return -1;
        }
    }

    @Override
    public int sucessor(int valor) {
        if ((valor > -1) && (valor < indice_final-1)) {
            return array[valor + 1];
        } else {
            return -1;
        }
    }

    @Override
    public void insereElemento(int valor) {
        insereInicio(valor);
    }

    @Override
    public void insereElementoPosicao(int valor, int buscaIndice) {
        if (buscaIndice < indice_final) {
            int[] recebeArray = new int[array.length + 1];
            for (int i = 0; i < buscaIndice; i++) {
                recebeArray[i] = array[i];
            }
            recebeArray[buscaIndice] = valor;
            for (int i = buscaIndice + 1; i < indice_final; i++) {
                recebeArray[i] = array[i-1];
            }
            array = recebeArray;
            indice_final ++;
        }
    }

    @Override
    public void insereInicio(int valor) {
        if (indice_final >= array.length) {
            int [] listatemp = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                listatemp[i+1] = array[i];
            }
            array = listatemp;
            array[0] = valor;
            indice_final += 1;
        } else {
            for (int i = (indice_final -1); i >= 0; i--) {
                array[i] = array[i-1];
            }
            array[0] = valor;
            indice_final += 1;
        }
    }
    @Override
    public void insereFim(int valor) {
        if (indice_final >= array.length) {
            int [] recebeArray = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                recebeArray[i] = array[i];
            }
            array = recebeArray;
            array[indice_final] = valor;
            indice_final += 1;
        } else {
            array[indice_final] = valor;
            indice_final += 1;
        }
    }

    @Override
    public void remove(int valor) {
        if (remove(valor, false)){
            remove(valor);
        }
    }

    private boolean remove(int valor, boolean b){
        int posicao = buscaIndice(valor);
        if (posicao != -1) {
            for (int i = posicao; i < indice_final - 1; i++) {
                array[i] = array[i + 1];
            }
            indice_final -= 1;
            return true;
        }
        return false;
    }


    @Override
    public void removeIndice(int indice) {
        if ((indice >= 0) && (indice < indice_final)) {
            for (int i = indice; i < indice_final - 1; i++) {
                array[i] = array[i + 1];
            }
            indice_final -= 1;
        }
    }


    @Override
    public void removeInicio() {
        removeIndice(0);
    }

    @Override
    public void removeFim() {
        removeIndice(indice_final - 1);
    }
    
}