import java.util.ArrayList;
import java.util.List;

public class Escalonador {
    List<Processo> listaDeProcessos; // uma lista que é um array dinâmico

    // Construtores
    public Escalonador(){
        listaDeProcessos = new ArrayList<Processo>();
    }

    public Escalonador(List<Processo> listaDeProcessos){
        this.listaDeProcessos = listaDeProcessos;
    }

    //O algoritmo SJF é não-preemptivo. Portanto, um processo vai passar os três
    //segundos em execução e depois volta pra lista de prioridades.

    // Se o tempo restante de um processo for menor do que três segundos, o escalonador
    // deve retirá-lo, não reinserí-lo mais na lista e selecionar outro processo.

    // O escalonador deve ir decrementando o tempo de execução restante enquanto o
    // processo estiver em execução

    // Método auxiliar que retorna o piso
    int piso(double numero){
        return (int)numero;
    }

    public void heapsort(){
        int tamLista =  listaDeProcessos.size();
        int tam = tamLista;
        Processo tmp = null;
        construirHeap();

        for(int i = tamLista - 1; i >= 0; i--){
           /* coloca o primeiro no fim do heap e decrementa o tamanho do heap */
            tmp = listaDeProcessos.get(i);
            listaDeProcessos.set(i, listaDeProcessos.get(0));
            listaDeProcessos.set(0, tmp);

            // descer 
            tam--;
            descer(0, tam);
        }
    }

    // Métodos para subir e descer elementos.
    void subir(int index){
        int j = (index - 1) / 2; // índice do pai de i
 
        if (j >= 0 && listaDeProcessos.get(index).getTempoExecucao() < listaDeProcessos.get(j).getTempoExecucao()) {
          Processo temp = listaDeProcessos.get(index);  // usada na troca de posições dos elementos
          listaDeProcessos.set(index, listaDeProcessos.get(j));
          listaDeProcessos.set(j, temp);
    
         // verificar se o j recém gerado sobe (recursivamente)
          subir(j);
        }
    }

    void descer(int i, int tam){
        int j = 2 * i + 1; //índice do filho de i

        if (j >= tam)
          return;
    
         // verificar se o índice é válido
        if (j < listaDeProcessos.size() - 1) {
          if (listaDeProcessos.get(j).getTempoExecucao() > listaDeProcessos.get(j + 1).getTempoExecucao())
            j++;
        }
    
        // caso o filho sejam maior que o pai, trocar suas posições
        if (listaDeProcessos.get(j).getTempoExecucao() < listaDeProcessos.get(i).getTempoExecucao()) {
          Processo temp = listaDeProcessos.get(i); // variável usada na troca de posições dos elementos
          listaDeProcessos.set(i, listaDeProcessos.get(j));
          listaDeProcessos.set(j, temp);
    
          descer(j, tam);
        }
    }

    public void construirHeap(){
        int ultimoIndex = listaDeProcessos.size() - 1;
        
        for (int i = piso(ultimoIndex / 2); i >= 0; i--){
            descer(i,  listaDeProcessos.size());
        }
    }

    public void inserir(Processo novo){
        if(isEmpty()){
            listaDeProcessos.add(novo);
        } else {
            listaDeProcessos.add(novo);
            subir( listaDeProcessos.size() - 1);
        }
    }
       
    Processo remover(){
        Processo processoRetirado;
        if ( listaDeProcessos.size() != 0){ // evitar erros        
            processoRetirado = listaDeProcessos.get(0);
            listaDeProcessos.set(0, listaDeProcessos.get( listaDeProcessos.size() - 1));
            listaDeProcessos.remove(listaDeProcessos.get( listaDeProcessos.size() - 1));
            descer(0,  listaDeProcessos.size());
            
            return processoRetirado;
        } else {
            return null;
        }
    }  

    boolean isEmpty(){
        return listaDeProcessos.isEmpty();
    }

}

