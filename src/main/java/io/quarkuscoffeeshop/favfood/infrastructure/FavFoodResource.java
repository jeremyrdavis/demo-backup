package io.quarkuscoffeeshop.favfood.infrastructure;

import io.quarkuscoffeeshop.domain.OrderInCommand;
import io.quarkuscoffeeshop.favfood.domain.FavFoodOrder;
import io.quarkuscoffeeshop.favfood.domain.FavFoodOrderHandler;
import io.quarkuscoffeeshop.infrastructure.RESTService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/FavFood")
public class FavFoodResource {

    Logger logger = LoggerFactory.getLogger(FavFoodResource.class);

    @Inject @RestClient
    RESTService restService;

    @POST
    public Response placeOrder(final FavFoodOrder favFoodOrder) {
        logger.debug("received {}", favFoodOrder);
        OrderInCommand orderInCommand = FavFoodOrderHandler.handleFavFoodOrder(favFoodOrder);
        logger.debug("sending {}", orderInCommand);
        restService.placeOrder(orderInCommand);
        logger.debug("order sent");
        return Response.accepted().build();
    }
}
