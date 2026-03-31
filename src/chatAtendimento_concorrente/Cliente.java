package chatAtendimento_concorrente;

public class Cliente {

    private int id;
    private String mensagem;

    public Cliente(int id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }
}