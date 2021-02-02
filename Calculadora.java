/*
Guillermo Moreno Rivera y Luis Fernando Chávez Jiménez
02/February/2021
*/
import java.util.Scanner;
public class Calculadora{
    double PI = 3.14159265;
    public static void main (String []args){
        Scanner sc = new Scanner(System.in);
        int opc = 1;
        while(opc != 0){
            System.out.println("1.- Calcular seno");
            System.out.println("2.- Calcular coseno");
            System.out.println("3.- Calcular logaritmo");
            System.out.println("4.- Calcular raíz cuadrada");
            System.out.println("5.- Calcular exponencial");
            System.out.println("0.- Salir");
            System.out.println("Ingrese una opción: ");
            opc = sc.nextInt();
            switch(opc){
                case 1:

                break;
                case 2:
                break;
                case 3:
                break;
                case 4:
                break;
                case 5:
                break;
                case 0:
                break;
                default:
                break;
            }
        }
        sc.close();
    }
    public double toRadian(double cant){
        return (cant * (PI/180));
    }
}