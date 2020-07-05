
public class Mensagem {

    private String Mensagem;
    private String Remetente;

    public Mensagem(String Mensagem, String Remetente) {
        this.Mensagem = Mensagem;
        this.Remetente = Remetente;
    }

    Mensagem() {

    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.Mensagem = Mensagem;
    }

    public String getRemetente() {
        return Remetente;
    }

    public void setRemetente(String Remetente) {
        this.Remetente = Remetente;
    }

}
