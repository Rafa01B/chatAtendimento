package chatAtendimento_concorrente;

public class ChatSimulacao {

    public static void main(String[] args) {

        FilaAtendimento fila = new FilaAtendimento();

        // atendentes (threads)
        Atendente atendente1 = new Atendente(1, fila); // Rafinha
        Atendente atendente2 = new Atendente(2, fila); // JhuBulachinha
        Atendente atendente3 = new Atendente(3, fila); // Larissa 

        // inicia as threads
        atendente1.start();
        atendente2.start();
        atendente3.start();

         // Simula clientes entrando no chat
        for (int i = 1; i <= 10; i++) {

            Cliente cliente = new Cliente(
                    i,
                    "Preciso de ajuda com meu pedido. Çocorro!"
            );

            fila.adicionarCliente(cliente);

            try {

                // intervalo entre clientes entrando
                Thread.sleep(1000); // 1 segundo = 1000 ms 

            } catch (InterruptedException e) {
                e.printStackTrace(); 
            }
        }
    }
}