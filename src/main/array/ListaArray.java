package array;

/* Marcelo Augusto de Barros Araújo */
import list.EstruturaElementar;

public class ListaArray implements EstruturaElementar {

    private int[] array;
    private int indice_final;

    public ListaArray() {
        array = new int[1];
        indice_final = 0;
    }

    @Override
    public boolean buscaElemento(int valor) {
        for (int i = 0; i < indice_final; i++) {
            if (array[i] == valor) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int buscaIndice(int valor) {
        if ((valor < 0) || (valor >= indice_final)) {
            return -1;
        }
        return array[valor];
    }

    @Override
    public int minimo() {
        if (indice_final == 0) {
            return -1;
        }

        int min = array[0];
        int i = 1;
        while (i < indice_final) {
            if (array[i] < min) {
                min = array[i];
            }
            i++;
        }

        return min;
    }

    @Override
    public int maximo() {
        if (indice_final == 0) {
            return -1;
        }

        int max = array[0];
        int i = 1;
        while (i < indice_final) {
            if (array[i] > max) {
                max = array[i];
            }
            i++;
        }

        return max;
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
        if ((valor > -1) && (valor < indice_final - 1)) {
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
                recebeArray[i] = array[i - 1];
            }
            array = recebeArray;
            indice_final++;
        }
    }

    @Override
    public void insereInicio(int valor) {
        int[] recebeArray = new int[array.length + 1];

        for (int i = indice_final; i > 0; i--)
            recebeArray[i] = array[i - 1];

        recebeArray[0] = valor;

        array = recebeArray;
        indice_final++;
    }

    @Override
    public void insereFim(int valor) {
        if (indice_final >= array.length) {
            int[] recebeArray = new int[array.length + 1];
            for (int i = 0; i < array.length; i++) {
                recebeArray[i] = array[i];
            }
            array = recebeArray;
            array[indice_final] = valor;
            indice_final += 1;
        } else {
            array[indice_final] = valor;
            indice_final++;
        }
    }

    @Override
    public void remove(int valor) {
        if (remove(valor, false)) {
            remove(valor);
        }
    }

    private boolean remove(int valor, boolean b) {
        int pos = buscaIndice(valor);
        if (pos != -1) {
            for (int i = pos; i < indice_final - 1; i++) {
                array[i] = array[i + 1];
            }
            indice_final--;
            return true;
        }
        return false;
    }

    @Override
    public void removeIndice(int indice) {
        if ((indice >= 0) && (indice < indice_final)) {
            int i = indice;
            while (i < indice_final - 1) {
                array[i] = array[i + 1];
                i++;
            }
            indice_final--;
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