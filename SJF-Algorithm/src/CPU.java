public class CPU {
    public static void main(String[] args) throws InterruptedException{
        
        //O tempo de execução de cada processo deve ser gerado aleatoriamente no momento de
        //sua criação
        Escalonador escalonador = new Escalonador(); //Inicia o escalonador:
        Processo processo = null;
        int tick;  // o tempo que cada processo deve ter para executar na CPU fictícia é de três segundos
        
        // 4 processos iniciais => Quatro processos devem ser criados
        for(int i = 0; i < 4; i++){
            escalonador.inserir(new Processo());
        }
        escalonador.construirHeap();
        tick = 0;

        while(tick < 10){  // 10 segundos 

            processo = escalonador.remover();
            processo.colocarNaCPU();

            Thread.sleep(3000);
            tick = tick +3;

            escalonador.construirHeap();

            if(processo.getTempoExecucao() > 0){
                escalonador.inserir(processo);
            }
        }

        // mais 8 processos => Após 10 segundos, oito processos devem ser criados.
        for(int i = 0; i < 8; i++){
            escalonador.inserir(new Processo());
        }
        escalonador.construirHeap();
        tick = 0;

        while(tick < 10){  // 10 segundos 

            processo = escalonador.remover();
            processo.colocarNaCPU();

            Thread.sleep(5000);
            tick = tick +3;

            escalonador.construirHeap();

            if(processo.getTempoExecucao() > 0){
                escalonador.inserir(processo);
            }
        }

        
        // mais 16 processos => Após 10 segundos, 16 processos devem ser criados.
        for(int i = 0; i < 16; i++){
            escalonador.inserir(new Processo());
        }
        escalonador.construirHeap();
        tick = 0;

        while(tick < 10){  // 10 segundos 

            processo = escalonador.remover();
            processo.colocarNaCPU();

            Thread.sleep(3000);
            tick = tick +3;

            escalonador.construirHeap();

            if(processo.getTempoExecucao() > 0){
                escalonador.inserir(processo);
            }
        }
        
        System.out.println("\n----------- Execução Terminada -----------"); 
    }
}

