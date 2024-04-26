import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        // se definen los datos del banco
        Banco banco = new Banco();
        banco.setNombre("Bco Loco");
        //
        System.out.println("*******************************");
        System.out.println("*** "+banco.getNombre()+ " ***");
        System.out.println("*** TDC = Tarjeta de Credito ***");
        System.out.println("********************************");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el limite de la TDC ");
        double limite=teclado.nextDouble();
        TarjetaDeCredito tdc = new TarjetaDeCredito(limite);
        // vamos al ciclo
        int salir=1;
        int cuenta=1;
        double consumo=0;
        //**
        while (salir != 0){
            System.out.println("Escriba la descripcion de la compra #"+cuenta+": ");
            String descripcion = teclado.next();
            System.out.println("Escriba el monto de la compra #"+cuenta+": ");
            double monto = teclado.nextDouble();
            double disponible= tdc.getSaldo();
            //**
            Compra compra = new Compra(descripcion, monto);
            //**
            boolean compraRealizada = tdc.lanzarCompra(compra);
            //**

            if(compraRealizada){
                System.out.println("Solicitud en proceso... ");
                System.out.println("Su saldo actual: "+ disponible + " y es sufieciente para realizar la compra... ");
                System.out.println("Compra Exitosa, su nuevo saldo es: "+ tdc.getSaldo());
                System.out.println("Escriba 1 si desea agregar otra compra, 0: para salir ");
                cuenta++;
                consumo+=monto;
                salir=teclado.nextInt();

            }
            else{
                System.out.println("Saldo insuficiente");
                salir=0;
            }
        }
        System.out.println("**********************************");
        System.out.println("***** HISTORIAL DE COMPRAS ******");
        System.out.println("1. Limite aprobado: "+limite);
        System.out.println("2. Monto consumido: "+consumo);
        System.out.println("3. Monto disponible: " +(limite-consumo));
        System.out.println("4. Número de compras: "+ (cuenta-1));
    }
}
