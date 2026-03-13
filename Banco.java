import javax.swing.*;
import java.awt.*;

class CuentaBancaria {

    private int saldo = 1000;
    private JTextArea area;

    public CuentaBancaria(JTextArea area){
        this.area = area;
    }

    public synchronized void retirar(String cliente, int monto){

        if(saldo >= monto){
            area.append(cliente + " retiró " + monto + "\n");
            saldo -= monto;
            area.append("Saldo actual: " + saldo + "\n\n");
        }else{
            area.append(cliente + " no pudo retirar. Saldo insuficiente\n\n");
        }
    }
}

class Cliente implements Runnable{

    private CuentaBancaria cuenta;
    private String nombre;

    public Cliente(CuentaBancaria cuenta, String nombre){
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    public void run(){
        cuenta.retirar(nombre,400);
    }
}

public class Banco extends JFrame{

    private JTextArea area;
    private JButton boton;

    public Banco(){

        setTitle("Simulación Banco");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        area = new JTextArea();
        boton = new JButton("Retirar Dinero");

        boton.addActionListener(e -> ejecutar());

        add(new JScrollPane(area),BorderLayout.CENTER);
        add(boton,BorderLayout.SOUTH);
    }

    public void ejecutar(){

        area.setText("");

        CuentaBancaria cuenta = new CuentaBancaria(area);

        Thread c1 = new Thread(new Cliente(cuenta,"Cliente 1"));
        Thread c2 = new Thread(new Cliente(cuenta,"Cliente 2"));
        Thread c3 = new Thread(new Cliente(cuenta,"Cliente 3"));

        c1.start();
        c2.start();
        c3.start();
    }

    public static void main(String[] args){
        new Banco().setVisible(true);
    }
}
