package org.br.mineradora.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.br.mineradora.dto.CurrencyPriceDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/last")
@RegisterRestClient //Serviço Rest
@ApplicationScoped //Contextualiza a Interface, informando que ela faz parte do Quarkus
public interface CurrencyPriceClient {

    @GET
    @Path("/{pair}") // {pair} = variável
    CurrencyPriceDTO getPriceByPair(@PathParam("pair") String pair);
}
