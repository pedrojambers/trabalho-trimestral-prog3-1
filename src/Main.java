import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 0;
        int op, agencia, nConta;
        Hashtable<String, ClientePF> clientes = new Hashtable<String, ClientePF>();
        Hashtable<Integer, ContaCorrente> listaContaCorrente = new Hashtable<Integer, ContaCorrente>();
        Random rand = new Random();
        Hashtable<Integer, ContaPoupanca> listaContaPoupanca = new Hashtable<Integer, ContaPoupanca>();
        Double valor;
        String senha;

        do {
            ClientePF cliente = new ClientePF();
            String cpf;
            ContaCorrente contaCorrente = new ContaCorrente();
            ContaPoupanca contaPoupanca = new ContaPoupanca();
            Validar validar = new Validar();


            System.out.println("\n[1] Cadastrar Pessoa Fisica");
            System.out.println("[2] Cadastrar Conta Corrente");
            System.out.println("[3] Cadastrar Conta Poupanca");
            System.out.println("[4] Depositar");
            System.out.println("[5] Sacar");
            System.out.println("[6] Transferir (nao funciona)");
            System.out.println("[7] Sair");
            System.out.println("");

            op = sc.nextInt();
            sc.nextLine();

            switch (op){
                case 1:
                    System.out.println("===Cadastro de Pessoa Fisica===");
                    System.out.print("CPF: ");
                    cliente.setCpf(sc.next());

                    System.out.print("Nome: ");
                    cliente.setNome(sc.next());

                    clientes.put(cliente.getCpf(), cliente);
                    System.out.println("Cadastro concluido!");
                    break;

                case 2:
                    System.out.println("===Cadastro de Conta Corrente===");
                    System.out.println("CPF: ");
                    cpf = sc.next();

                    if(clientes.containsKey(cpf)){
                        try {
                            for(Map.Entry<Integer, ContaCorrente> conta : listaContaCorrente.entrySet()){
                                if(conta.getValue().getCliente().getCpf().equals(cpf)){
                                    throw new RuntimeException("Conta corrente ja cadastrada!");
                                }
                            }

                            contaCorrente.setCliente(clientes.get(cpf));
                            contaCorrente.setnConta(rand.nextInt(1000));
                            contaCorrente.setCdAgencia(123);

                            System.out.println("Senha para criação da conta: ");
                            contaCorrente.setSenha(sc.next());

                            listaContaCorrente.put(contaCorrente.getnConta(), contaCorrente);
                            System.out.println("Cadastro concluido!");
                            System.out.println("Numero da conta: " + contaCorrente.getnConta());

                        } catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
                    } else{
                        System.out.println("CPF informado inexistente!");
                    }

                    break;

                case 3:
                    System.out.println("===Cadastro de Conta Poupanca===");
                    System.out.println("CPF: ");
                    cpf = sc.next();

                    if(clientes.containsKey(cpf)){
                        try {
                            for(Map.Entry<Integer, ContaPoupanca> conta : listaContaPoupanca.entrySet()){
                                if(conta.getValue().getCliente().getCpf().equals(cpf)){
                                    throw new RuntimeException("Conta poupanca ja cadastrada!");
                                }
                            }

                            contaPoupanca.setCliente(clientes.get(cpf));
                            contaPoupanca.setnConta(rand.nextInt(1000));
                            contaPoupanca.setCdAgencia(123);

                            System.out.println("Senha para criação da conta: ");
                            contaPoupanca.setSenha(sc.next());

                            listaContaPoupanca.put(contaCorrente.getnConta(), contaPoupanca);
                            System.out.println("Cadastro concluido!");
                            System.out.println("Numero da conta: " + contaPoupanca.getnConta());

                        } catch(RuntimeException e){
                            System.out.println(e.getMessage());
                        }
                    } else{
                        System.out.println("CPF informado inexistente!");
                    }

                    break;

                case 4:
                    System.out.println("===Despositar===");
                    System.out.println("CPF: ");
                    cpf = sc.next();

                    for(Map.Entry<String, ClientePF> hashClientes : clientes.entrySet()){
                        validar.validarCpf(hashClientes.getKey(), cpf);
                    }

                    System.out.println("Agencia: ");
                    agencia = sc.nextInt();
                    while (agencia != 123){
                        System.out.println("Agencia invalida!");

                    }

                    System.out.println("Numero da conta: ");
                    nConta = sc.nextInt();

                    validar.validarNconta(listaContaCorrente, nConta);
                    for(Map.Entry<Integer, ContaCorrente> conta : listaContaCorrente.entrySet()){
                        validar.validarCpf(conta.getValue().getCliente().getCpf(), cpf);
                    }

                    System.out.println("Valor do deposito: ");
                    valor = sc.nextDouble();

                    System.out.println("Senha: ");
                    senha = sc.next();
                    validar.validarSenha(listaContaCorrente.get(nConta).getSenha(), senha);

                    listaContaCorrente.get(nConta).depositar(valor);
                    System.out.println("Deposito concluido!");



                    break;

                case 5:
                    System.out.println("===Sacar===");
                    System.out.println("CPF: ");
                    cpf = sc.next();

                    for(Map.Entry<String, ClientePF> hashClientes : clientes.entrySet()){
                        validar.validarCpf(hashClientes.getKey(), cpf);
                    }

                    System.out.println("Agencia: ");
                    agencia = sc.nextInt();
                    while (agencia != 123){
                        System.out.println("Agencia invalida!");

                    }

                    System.out.println("Numero da conta: ");
                    nConta = sc.nextInt();

                    validar.validarNconta(listaContaCorrente, nConta);
                    for(Map.Entry<Integer, ContaCorrente> conta : listaContaCorrente.entrySet()){
                        validar.validarCpf(conta.getValue().getCliente().getCpf(), cpf);
                    }

                    System.out.println("Valor do saque: ");
                    valor = sc.nextDouble();

                    System.out.println("Senha: ");
                    senha = sc.next();
                    validar.validarSenha(listaContaCorrente.get(nConta).getSenha(), senha);

                    listaContaCorrente.get(nConta).sacar(valor);
                    System.out.println("Saque concluido!");

                    break;

                case 6:
                    System.out.println("===Transferir===");
                    System.out.println("CPF da conta de origem: ");
                    cpf = sc.next();

                    for(Map.Entry<String, ClientePF> hashClientes : clientes.entrySet()){
                        validar.validarCpf(hashClientes.getKey(), cpf);
                    }

                    System.out.println("Agencia da conta de origem: ");
                    agencia = sc.nextInt();
                    while (agencia != 123){
                        System.out.println("Agencia invalida!");

                    }

                    System.out.println("Numero da conta de origem: ");
                    nConta = sc.nextInt();
                    validar.validarNconta(listaContaCorrente, nConta);
                    for(Map.Entry<Integer, ContaCorrente> conta : listaContaCorrente.entrySet()){
                        validar.validarCpf(conta.getValue().getCliente().getCpf(), cpf);
                    }

                    System.out.println("Valor da transferencia: ");
                    valor = sc.nextDouble();

                    System.out.println();


                    System.out.println("Senha: ");
                    senha = sc.next();
                    validar.validarSenha(listaContaCorrente.get(nConta).getSenha(), senha);



                    listaContaCorrente.get(nConta).sacar(valor);
                    System.out.println("Saque concluido!");



                case 7:

                    break;

                default:

                    break;

            }

        } while (op != 7);
    }
}
