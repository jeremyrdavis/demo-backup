package io.quarkuscoffeeshop.infrastructure;

import io.quarkuscoffeeshop.domain.OrderInCommand;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletionStage;

@Path("/order")
@RegisterRestClient
public interface RESTService {

    @POST
    CompletionStage<Response> placeOrder(final OrderInCommand orderInCommand);
}
