package org.br.mineradora.message;

import jakarta.enterprise.context.ApplicationScoped;
import org.br.mineradora.dto.QuotationDTO;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class KafkaEvents {

    private final Logger log = LoggerFactory.getLogger(KafkaEvents.class);

    @Channel("quotation-channel") // Canal que tem acesso ao tópico do Kafka
    Emitter<QuotationDTO> quotationRequestEmitter; //Emissor que vai enviar msg para dentro do tópico Kafka

    public void sendNweKafkaEvent(QuotationDTO quotation){

        log.info("-- Enviando Cotacao para Topico Kafka --");
        quotationRequestEmitter.send(quotation).toCompletableFuture().join();
    }
}
