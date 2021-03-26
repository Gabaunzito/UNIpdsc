package pdsc_aula25.pkg02.pkg21;

import java.util.Scanner;

public class aumentoSalario {

    public static void main(String[] args) {
        
        int salario, bonificacao, aux, novoSalario = 0;

        Scanner teclado = new Scanner (System.in);
        
        System.out.print("Informe o salario do funcionario: ");
        salario = teclado.nextInt();

        System.out.println(salario);
        
        if(salario <= 800){
            
            bonificacao = salario*5/10;
            System.out.println(bonificacao);
            novoSalario = salario + bonificacao;
            System.out.println("O novo salario do funcionario é de: R$" + novoSalario);

            
        }else if (salario >= 800 && salario <= 1300){
            
            bonificacao = salario*(12/100);
            System.out.println(bonificacao);
            novoSalario = salario + bonificacao;
            System.out.println("O novo salario do funcionario é de: R$" + novoSalario);

        }else{
            System.out.println("Você não esta apto a receber aumento. seu salario continua: R$ " + salario);            
        }
        
        
    }
}
