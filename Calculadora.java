/*
Guillermo Moreno Rivera y Luis Fernando Chávez Jiménez
02/February/2021
*/

import java.util.Scanner;
public class Calculadora{
    static double PI = 3.14159265;
    static int objetivoCifras = 0;
    static double errorMeta = 0;
    static double errorAproximado = 0;
    static double cifras;
    static Scanner sc = new Scanner(System.in);
    public static void main (String []args){
        
        int opc = 1;
        while(opc != 0){
            System.out.println("1.- Calcular seno");
            System.out.println("2.- Calcular coseno");
            System.out.println("3.- Calcular logaritmo");
            System.out.println("4.- Calcular raíz cuadrada");
            System.out.println("5.- Calcular exponencial");
            System.out.println("6.- Cambiar presición");
            System.out.println("0.- Salir");
            System.out.println("Ingrese una opción: ");
            opc = sc.nextInt();
            double x = 0;
            //Evalua que se haya1 ingresado las cifras significativas antes de comenzar el programa
            if(opc != 6){
                while(objetivoCifras == 0){
                    System.out.print("Primero tiene que ingresar el número de cifras significativas precisas: ");
                    objetivoCifras = sc.nextInt();
                    errorMeta = eS(objetivoCifras);
                }

            }
            switch(opc){
                case 1:
                    System.out.print("Ingrese su valor x para hacer el cálculo: ");
                    x = gradosRad(sc.nextDouble());
                    System.out.println("Su resultado es: " + seno(x));
                    break;
                case 2:
                    //System.out.print("Ingrese su valor x para hacer el cálculo: ");
                    //x = gradosRad(sc.nextDouble());
                    System.out.println(coseno(toRadian(60)));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.print("Ingrese el número de cifras significativas precisas: ");
                    objetivoCifras = sc.nextInt();
                    errorMeta = eS(objetivoCifras);
                    break;
                case 0:
                    System.out.println("Cadena");
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
    //Calculo seno de x
    public static double seno(double n){
        double eA = 10;
        double temp = 0;
        double tempSuma = 0;
        double tempSumaA =0;
        int c = 0;
        while(eA > errorMeta){
            temp = (pow(-1, c) / factorial((2*c)+1) * pow(n, (2*c) + 1));
            if(c == 0){
                tempSuma = temp;
            } else {    
                tempSumaA = tempSuma;
                tempSuma = tempSuma + temp;
                eA = calEA(tempSuma, tempSumaA);

            }
            c++;
        }
        return tempSuma;  
    }

    //Calcula EA
    public static double calEA(double VV, double VA){
        return ((absD(VV -VA)) / VV ) * 100;
    }
    //Pregunta si el cálculo será en gradaos o en radianes
    public static double gradosRad(double x){
        double a = 0;
        int opcA = 0;
        while(opcA != -1){
            System.out.println("El valor de x se encuentra en:");
            System.out.println("1. x en radianes");
            System.out.println("2. x en grados");
            System.out.print("Ingrese su respuesta: ");
            opcA = sc.nextInt();
            switch (opcA) {
                case 1:
                    a = x;
                    opcA = -1;
                    break;
                case 2:
                    a = toRadian(x);
                    opcA = -1;
                    break;
                default:
                    break;
            }
        }
        return a;
    }

    //Convierte una cantidad de grados a radianes.
    public static double toRadian(double cant){
        return (cant * (PI/180));
    }

    //Calcula el factorial de un número.
    public static double factorial(int x){
        int fact = 1;
        while(x>0){
            fact = fact * x;
            x--;
        }
        return fact;
    }
    public static double coseno(double x){
        double sumando, sumatoria = 0, precision = 0.0001d;
        // limite superior, iteracion de la sumatoria
        int n = 0; 
        do {
            sumando = pow(-1, n) / factorial(2 * n) * pow(x, 2*n);
            sumatoria = sumatoria + sumando;
            n = n + 1;
        } while (Math.abs(sumando) > precision);
        return sumatoria;
    } 
    //Eleva a la potencia de un número positivo
    public static double pow(double numero, double potencia){
        if(potencia == 0) return 1;
        if(potencia == 1) return numero;
        if (potencia == -1) return 1 / numero;
        double res = numero;
        for(int x = 1; x<potencia; x++){
            res = res * numero;
        }
        return res;
    }

    //Calcula el valor absoluto de un número con punto decimal
    public static double absD(double n){
        double a;
        if(n > 0) a = n;
        else a = n * (-1);
        return a;
    }
    //Eleva a la potencia de un numero negativo
    public static double powN(double n, double p){
        p = absD(p);
        double a = 1;
        for (int i = 0; i < p; i++) {
            a = n * a;  
        }
        return 1/a ;
    }
    //Calcula el error meta con las cifras deseadas
    public static double eS(double cifras){
        double a = 0;
        if(cifras > 2){
            a = powN(10, 2-cifras);
        } else a = pow(10, 2-cifras);
        return 0.5f * a;
    }
}
