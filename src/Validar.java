import java.util.Hashtable;

public class Validar {
    public void validarCpf(String cpfCorreto, String cpf){
        if(!cpfCorreto.equals(cpf)){
            System.out.println("CPF incorreto!");
        }
    }

    public void validarNconta(Hashtable conta, int nConta){
        if(!conta.containsKey(nConta)){
            throw new RuntimeException("Número de conta incorreto!");
        }
    }

    public void validarSenha(String senhaCorreta, String senha){
        if(!senhaCorreta.equals(senha)){
            throw new RuntimeException("Senha Incorreta!");
        }
    }
}
