/*
Guillermo Moreno Rivera y Luis Fernando Chávez Jiménez
02/February/2021
*/
import java.util.Scanner;
public class Calculadora{
    static double PI = 3.14159265;
    static int objetivoCifras = 0;
    static double cifras;
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
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
            switch(opc){
                case 1:
                break;
                case 2:
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
    public static double pow(double numero, double potencia){
        if(potencia == 0) return 1;
        if(potencia == 1) return numero;
        if (potencia == -1) return 1 / numero;
        double res = 1;
        for(int x = 1; x<potencia; x++){
            res = res * numero;
        }
        return res;
    }
}
