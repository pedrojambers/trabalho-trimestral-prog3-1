public class ContaPoupanca extends Conta{

    @Override
    public ClientePF getCliente(){
        return super.getCliente();
    }

    @Override
    public void setCliente(ClientePF cliente){
        super.setCliente(cliente);
    }

    @Override
    public int getCdAgencia() {
        return super.getCdAgencia();
    }

    @Override
    public void setCdAgencia(int cdAgencia) {
        super.setCdAgencia(cdAgencia);
    }

    @Override
    public int getnConta() {
        return super.getnConta();
    }

    @Override
    public void setnConta(int nConta) {
        super.setnConta(nConta);
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public void setSenha(String senha) {
        super.setSenha(senha);
    }

    public void depositar(Double valor){
        if(valor < 0){
            throw new RuntimeException("Valor Negativo não pode ser depositado!");

        }

        this.saldo += valor;
    }

    public void sacar(Double valor){
        if(valor > this.saldo){
            throw new RuntimeException("Valor de saque não pode ser maior que o saldo da conta!");

        }

        this.saldo -= valor;
    }

    public void transferir(Double valor){
        if(valor > this.saldo){
            throw new RuntimeException("Valor para tranferencia nao pode ser maior que o saldo da conta");
        }

        this.saldo -= valor;
    }

    @Override
    Double getSaldo() {
        return this.saldo;
    }
}
