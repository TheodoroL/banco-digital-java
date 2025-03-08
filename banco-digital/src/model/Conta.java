package model;

public abstract class Conta {
    protected String nome;
    protected int agencia;
    protected double saldo;

    public Conta(String nome, int agencia, double saldo) {
        this.nome = nome;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public void sacar(double valor){
        if(valor > this.saldo || this.saldo <=0){
            System.out.println("saldo não suficiente");
            return;
        }
        this.saldo-=valor;
    }
    public void depositar(double valor){
        if(valor <= 0){
            System.out.println("porfavor, deposita um número maior que zero :)");
            return;
        }
        this.saldo+=valor;
    }
    public void transferir(double valor, Conta conta ){
        if(valor > this.saldo || this.saldo <=0){
            System.out.println("saldo não suficiente");
            return;
        }
        this.sacar(valor);
        conta.depositar(valor);
    }
    public String getNome() {
        return nome;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                '}';
    }
}
