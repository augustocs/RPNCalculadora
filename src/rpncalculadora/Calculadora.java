package rpncalculadora;

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