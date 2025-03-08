import model.Conta;
import model.ContaCorrente;
import model.ContaPoupanca;

import java.util.*;


public class Banco {
    private Random randomAgencia;
    List<Conta> listaConta;
    public Banco (){
        this.listaConta = new ArrayList<>();
        this.randomAgencia = new Random();
    }
    public  void addContaCorrente(String nome, double saldo ){
        this.listaConta.add(new ContaCorrente( nome, this.randomAgencia.nextInt(100), saldo));
    }

    public void addContaPoupanca(String nome, double saldo ){
        this.listaConta.add(new ContaPoupanca( nome, this.randomAgencia.nextInt(100), saldo));
    }

    public List<ContaCorrente> mostrarTodasContaCorrente(){
        return this.listaConta.stream()
                .filter((conta)-> conta instanceof ContaCorrente)
                .map(c -> (ContaCorrente) c)
                .toList();
    }

    public List<ContaPoupanca> mostrarTodasContaPoupanca(){
        return this.listaConta.stream()
                .filter((conta)-> conta instanceof ContaPoupanca)
                .map(c -> (ContaPoupanca) c)
                .toList();
    }

    public ContaCorrente mostrarMaiorSaldoContaCorrente(){
        List<ContaCorrente> lista = mostrarTodasContaCorrente();
        return lista.stream().max(new ComparatorSaldo()).orElseThrow();
    }

    public ContaPoupanca mostrarMaiorSaldoContaPoupanca(){
        List<ContaPoupanca> lista = mostrarTodasContaPoupanca();
        return lista.stream().max(new ComparatorSaldo()).orElseThrow();
    }

    public void removerConta(int agencia){
        if(this.listaConta.isEmpty()){
            System.out.println("não tem nenhuma conta");
            return;
        }
        for(var conta : this.listaConta){
            if(conta.getAgencia() == agencia){
                this.listaConta.remove(conta);
                break;
            }
        }
    }
    public  void MostrarTodasConta(){
        System.out.println(this.listaConta);
    }

}
class ComparatorSaldo implements Comparator<Conta> {
    @Override
    public int compare(Conta o1, Conta o2) {
        return Double.compare(o1.getSaldo(), o2.getSaldo());
    }

}