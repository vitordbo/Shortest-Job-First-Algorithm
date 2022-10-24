public class Processo {

    //Cada processo deve ter os seguintes atributos: id, nome, tempo de execução (que
    //simboliza a prioridade) e mensagem
    private int id;                
    private String nome;
    private String mensagem;
    private int tempoExecucao;
    private static int idProcesso = 0; // incrementar no construtor 

    //O tempo de execução de cada processo deve ser gerado aleatoriamente no momento de sua criação.
    public Processo(){
        this.id = ++idProcesso;
        nome = "Processo de id " + id;
        tempoExecucao = (int) (Math.random() * 20);
    }

    //Assim como métodos para manipular esses atributos obrigatórios
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    } 

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExec(int tempoExec) {
        if(tempoExec > 0){
            this.tempoExecucao = tempoExec;
            setMensagem(nome + " precisa de " + tempoExec + " segundos para terminar sua execução");
        }
        else{
            this.tempoExecucao = 0;
            setMensagem(nome + " terminou sua execução");
        }
    }

    //Quando um processo for selecionado para executar, deve escrever o conteúdo do
    //atributo mensagem
    //Quando outro processo for selecionado, o escalonador reinsere o processo que
    // acabou de sair com o tempo que restou na lista de prioridades
    public void colocarNaCPU(){
        setTempoExec( getTempoExecucao() - 3);
        System.out.println("\n\nExecutando: " + getNome()); 
        System.out.println("Mensagem: " + getMensagem()); 
    }
}

