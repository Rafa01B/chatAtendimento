package chatAtendimento_concorrente;

import java.util.LinkedList;
import java.util.Queue;

public class FilaAtendimento {

    private Queue<Cliente> fila;

    public FilaAtendimento() {
        fila = new LinkedList<>();
    }

    public synchronized void adicionarCliente(Cliente cliente) {

        fila.add(cliente);

        System.out.println("Cliente " + cliente.getId() + " entrou no chat.");

        // Notifica threads que estejam esperando clientes
        notifyAll();
    }

    public synchronized Cliente pegarCliente() {

        while (fila.isEmpty()) {
            try {
                // Caso não haja clientes, o atendente espera
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return fila.poll();
    }
}