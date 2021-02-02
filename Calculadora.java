/*
Guillermo Moreno Rivera y Luis Fernando Chávez Jiménez
02/February/2021
*/
import java.util.Scanner;
public class Calculadora{
    double PI = 3.14159265;
    static int errorMeta = 0;
    static double aproxAct = 0, aproxAnt = 0;
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        
        System.out.print("Ingrese el número de cifras significativas precisas que desea en las operaciones: ");
        errorMeta = sc.nextInt();
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
                    System.out.println("Cálculo del seno");
                    aproxAnt = 1;
                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 6:
                    System.out.print("Ingrese el número de cifras significativas precisas: ");
                    errorMeta = sc.nextInt();
                break;
                case 0:
                break;
                default:
                break;
            }
        }
        sc.close();
    }
    //Convierte una cantidad de grados a radianes.
    public double toRadian(double cant){
        return (cant * (PI/180));
    }
    //Calcula el error meta
    public double decimalErrorMeta(int errorMeta){
        return .5*(10^(2-errorMeta));
    }
    //Calcula el error actual.
    public double errorActual(double aproxAct, double aproxAnt){
        return (aproxAct-aproxAnt)/aproxAct;
    }
    public double seno(int x, int aproxAnte){
        int n = 0;
        do{
            aproxAct = (((-1)^n)*(x^(2*(n + 1))))/factorial((2*n)+1);
        }while(errorActual(aproxAct, aproxAnt)<decimalErrorMeta(errorMeta));
        return aproxAct;
    }
    public double factorial(int x){
        int fact = 1;
        while(x>0){
            fact = fact * x;
            x--;
        }
        return fact;
    }
}
