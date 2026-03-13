import javax.swing.*;
import java.awt.*;

class Sumador implements Runnable {

    private int inicio;
    private int fin;
    private long suma = 0;
    private JTextArea area;

    public Sumador(int inicio, int fin, JTextArea area) {
        this.inicio = inicio;
        this.fin = fin;
        this.area = area;
    }

    public void run() {
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }

        area.append("Hilo " + inicio + " - " + fin + " = " + suma + "\n");
    }

    public long getSuma() {
        return suma;
    }
}

public class FrontendParalelismo extends JFrame {

    private JTextArea resultado;
    private JButton boton;

    public FrontendParalelismo() {

        setTitle("Paralelismo - Suma con Hilos");
        setSize(400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resultado = new JTextArea();
        boton = new JButton("Calcular Suma");

        boton.addActionListener(e -> ejecutar());

        add(new JScrollPane(resultado), BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
    }

    public void ejecutar(){

        resultado.setText("");

        Sumador s1 = new Sumador(1,250000,resultado);
        Sumador s2 = new Sumador(250001,500000,resultado);
        Sumador s3 = new Sumador(500001,750000,resultado);
        Sumador s4 = new Sumador(750001,1000000,resultado);

        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        Thread t3 = new Thread(s3);
        Thread t4 = new Thread(s4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try{
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(Exception e){}

        long total = s1.getSuma()+s2.getSuma()+s3.getSuma()+s4.getSuma();

        resultado.append("\nSuma Total = " + total);
    }

    public static void main(String[] args) {
        new FrontendParalelismo().setVisible(true);
    }
}