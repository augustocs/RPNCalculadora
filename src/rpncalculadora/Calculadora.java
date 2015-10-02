package rpncalculadora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package rpncalculadoraJava;

/**
 *
 * @author A.C.E.L
 */
public class Calculadora {

    public double somar(double nro1, double nro2)
    {
       return nro1+nro2;
    }
 
    public double subtrair(double nro1, double nro2){
        return nro1-nro2;
    }
   
    public double multiplicar(double nro1, double nro2){
        return nro1*nro2;
    }
   
    public double dividir(double nro1, double nro2){
        return nro2/nro1;
    }
    
    public double operacaoPorcent(double nro1, double nro2){
        return (nro1/100) * nro2;
        
    }

}
