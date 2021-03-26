package pdsc_aula25.pkg02.pkg21;

import java.util.Scanner;

public class valoresIABC {
    
    public static void main(String[] args) {
       
        //Declarando variaveis
        int numI;
        double numA, numB, numC, maior, meio, menor;

        //Iniciando Variveis maior, meio e menor
        maior = 0;
        meio = 0;
        menor = 0;

        //iniciando o objeto importado (Scanner) numa variavel
        Scanner teclado = new Scanner (System.in);
        
        
        //Recebendo os numeros
        System.out.println("Digite 3 numeros diferentes: ");

        System.out.print("Nummero 1: ");
        numA = teclado.nextDouble();

        System.out.print("Nummero 2: ");
        numB = teclado.nextDouble();

        System.out.print("Nummero 3: ");
        numC = teclado.nextDouble();

        //Receber a opção
        System.out.print("Escolha uma opção (1, 2 ou 3) ");
        numI = teclado.nextInt();


        //Verificando NUMERO A
        if(numA > numB && numA > numC){
            maior = numA;
        }else if(numA < numB && numA < numC){
            menor = numA;                
        }else{
            meio = numA;
        }
        //Verificando NUMERO B
        if(numB > numA && numB > numC){
            maior = numB;
        }else if(numB < numA && numB < numC){
            menor = numB;                
        }else{
            meio = numB;
        }
        //Verificando NUMERO C
        if(numC > numB && numC > numA){
            maior = numC;
        }else if(numC < numB && numC < numA){
            menor = numC;                
        }else{
            meio = numC;
        }

        
        if(numI == 1){ //se opção 1
            System.out.println("Ordem crescente: " + maior + ", " + meio + " e " + menor);

        }else if (numI == 2){ //se opção 2
            System.out.println("Ordem decrescente: " + menor + ", " + meio + " e " + maior);

        }else if (numI == 3) { //se opção 3
            System.out.println("Maior no meio: " + meio + ", " + maior + " e " + menor);

        }else{ //qualquer outra opção 
            System.out.println("Opção invalida");

        }
    }
}
