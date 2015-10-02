package rpncalculadora;

//package rpncalculadoraJava;

import java.util.Scanner;

public class Pilha {
    
    // criando a pilha
    public Object[] pilha; 
    public int posicaoPilha;
    
    public Pilha() {
        this.posicaoPilha = -1; // indica que esta nula, vazia, pois posição um indica que contém informação this.pilha = new Object[1000]; // criando uma pilha com 1000 posições 
        this.pilha = new Object[10]; // cirando uma pilha de 10 posições
    }
    
    public boolean pilhaVazia() {
        if (this.posicaoPilha == -1) { 
            return true; 
        } 
        return false;
    } 

    public int tamanho() { 
        if (this.pilhaVazia()) { 
            return 0;

        } 
        return this.posicaoPilha + 1; 
    }

    public Object exibeUltimoValor(){ 
        if (this.pilhaVazia()) { 
            return null; 
        }
        return this.pilha[this.posicaoPilha];
    }
 
    public Object desempilhar() {
        //pop
        if (pilhaVazia()) { 
            return null; 
        }
        return this.pilha[this.posicaoPilha--];
    } 

    public void empilhar(Object valor) { 
        // push
        if (this.posicaoPilha < this.pilha.length - 1) {

           this.pilha[++posicaoPilha] = valor; 
        } 
    }
    
    public void menuPrincipal() throws Exception {
        
        String condicao="N";
        double resultado = 0;
        Pilha p = new Pilha();
        String opcao = "";

        do
        {  
            Calculadora calc = new Calculadora();
            Scanner sc = new Scanner(System.in);

            System.out.println("Calculadora RPN\n\n");

            System.out.println("Digite um numero: \n");
            double nro1 = sc.nextDouble();
            p.empilhar(nro1);

            System.out.println("Digite o segundo numero: \n");
            double nro2 = sc.nextDouble();
            p.empilhar(nro2);

            System.out.println("Digite o operador: \n");
            opcao = sc.next();

           switch (opcao)
            {
                case "+":

                 p.desempilhar();
                 System.out.println("Soma\n");
                 p.desempilhar();

                 resultado = calc.somar(nro1, nro2);
                 p.empilhar(resultado);

                    break;

                case "-":  //subtrair
                    p.desempilhar();
                    System.out.println("Subtração\n");
                    p.desempilhar();

                    resultado = calc.subtrair(nro1, nro2);
                    p.empilhar(resultado);                    
                    break;

                case "*":  //multiplicar
                    p.desempilhar();
                    System.out.println("Multiplicação\n");
                    p.desempilhar();

                    resultado = calc.multiplicar(nro1, nro2);
                    p.empilhar(resultado);
                    break;

                case "/":  //dividir
                    p.desempilhar();
                    System.out.println("Divisão\n");
                    p.desempilhar();

                    resultado = calc.dividir(nro1, nro2);
                    p.empilhar(resultado);
                    break;

                case "%":  // porcentagem
                    p.desempilhar();
                    System.out.println("Porcentagem\n");
                    p.desempilhar();

                    resultado = calc.operacaoPorcent(nro1, nro2);
                    p.empilhar(resultado);  
                    
                    //System.out.println(p.exibeUltimoValor());
                    break;

                default:
                    System.out.println("Informe um operador correto");
                    break;                   
            }

           if (resultado >= 0){
                //Exibir resultado
                System.out.println("Resultado:" + resultado +"\n\n");
            }

            System.out.println("Realizar nova operacao SIM (S) ou NAO (N)\n");
            Scanner sc2 = new Scanner(System.in);
            condicao = sc2.nextLine().toUpperCase();
            } while( !"N".equals(condicao) );        
    }
}
