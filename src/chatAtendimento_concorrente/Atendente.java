package chatAtendimento_concorrente;

import java.util.Random;

/*≽₍^. .^₎⟆*/


public class Atendente extends Thread {

    private int id;
    private FilaAtendimento fila; 

    public Atendente(int id, FilaAtendimento fila) {
        this.id = id;
        this.fila = fila;
    }
    
    public Atendente() {
    	
    }
    
    @Override
    public void run() {

        Random random = new Random();

        while (true) {

            // Pega um cliente da fila
            Cliente cliente = fila.pegarCliente();

            System.out.println("Atendente " + id +
                    " iniciou atendimento do Cliente " +
                    cliente.getId());

            System.out.println("Cliente " + cliente.getId() +
                    ": " + cliente.getMensagem());

            System.out.println("Atendente " + id +
                    ": Estou verificando sua solicitação...");

            try {

                // Simula tempo de atendimento
                int tempoAtendimento = random.nextInt(3000) + 2000;
                Thread.sleep(tempoAtendimento);

            } catch (InterruptedException e) { // exeção de interrupção (caso a thread dê ruim) 
                e.printStackTrace();
            }

            System.out.println("Atendente " + id +
                    " finalizou atendimento do Cliente " +
                    cliente.getId());

            System.out.println("---------------------------------");
        }
    }
}