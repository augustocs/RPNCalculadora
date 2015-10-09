package rpncalculadora;

import com.sun.org.omg.CORBA.ParDescriptionSeqHelper;
import java.util.Scanner;
//import sun.io.Converters;

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
 
    public double desempilhar() {
        double nro=0;
        
        //pop
        if (pilhaVazia()) { 
            return 0; 
        }
        Object loNro = this.pilha[this.posicaoPilha--];
        
        double lnNRO = (double)loNro;
        
        if (!loNro.equals(null)){
            nro = (double) loNro;
        }else{
            nro = 0;
        }        
        return nro;
    } 

    public void empilhar(Object valor) { 
        // push
        if (this.posicaoPilha < this.pilha.length - 1) {
           this.pilha[++posicaoPilha] = valor; 
        } 
    }
    
    public static boolean verifNro (String s) {  
    try {  
        Long.parseLong (s);   
        return true;  
    } catch (NumberFormatException ex) {  
        return false;  
    }  
}  
    public void Calculos() throws Exception {
        
        String condicao="S";
        double resultado = 0;
        Pilha p = new Pilha();

        do
        {  
            Calculadora calc = new Calculadora();
            Scanner sc = new Scanner(System.in);

            System.out.println("Calculadora RPN\nDigite as opções disponiveis: \n");
            System.out.println(" - Digite um numero:\n");
            System.out.println(" - Digite a operacao:\n");
            System.out.println(" - Tecle enter:\n");
            System.out.println(" C = Cancelar:\n");
            System.out.println("Opcao: ");
            String str = sc.nextLine();
            
            boolean validNro = verifNro(str);
            double lNro = 0;
            double lNro2 = 0;
            
            //  NUMERO
            if(validNro){
                p.empilhar(Double.parseDouble(str));
            }   else   {
                                
                switch (str) {
                    //ENTER
                    case "":
                        double num = p.desempilhar();
                        p.empilhar(num);
                        p.empilhar(num);
                        break;
                    //OPERACAO
                    case "+":
                        System.out.println("Funcao SOMAR:\n");
                        
                        lNro = p.desempilhar();
                        lNro2 = p.desempilhar();
                
                        resultado = calc.somar(lNro, lNro2);
                        p.empilhar(resultado);
                        break;

                    case "-":  //subtrair
                        System.out.println("Funcao SUBTRACAO:\n");

                        lNro = p.desempilhar();
                        lNro2 = p.desempilhar();
                        
                        resultado = calc.subtrair(lNro2, lNro);
                        p.empilhar(resultado);                    
                        break;

                    case "*":  //multiplicar
                        System.out.println("Funcao MULTIPLICACAO:\n");
                        
                        lNro = p.desempilhar();
                        lNro2 = p.desempilhar();
                        
                        resultado = calc.multiplicar(lNro, lNro2);
                        p.empilhar(resultado);
                        break;

                    case "/":  //dividir
                        System.out.println("Funcao DIVISAO:\n");

                        lNro = p.desempilhar();
                        lNro2 = p.desempilhar();
                        
                        resultado = calc.dividir(lNro, lNro2);
                        p.empilhar(resultado);
                        break;

                    case "%":  // porcentagem
                        System.out.println("Funcao PORCENTAGEM:\n");
                        
                        lNro = p.desempilhar();
                        lNro2 = p.desempilhar();
                        
                        resultado = calc.operacaoPorcent(lNro, lNro2);
                        p.empilhar(resultado);  

                        break;
                    case "C":
                        resultado = -1;
                        break;
                    case "c":
                        resultado = -1;
                        break;
                    default:
                        System.out.println("Operador não identificado (+, -, /, *, %)");
                        break;                   
                }
                if (resultado >= 0){
                     //Exibir resultado
                     System.out.println("Resultado:" + resultado +"\n\n");
                 }
            }
            
            if(str.toUpperCase().equals("C")){
                System.out.println("Calculadora finalizada");
                condicao = "N";
            }
            
        } while( !"N".equals(condicao) );        
    }
}