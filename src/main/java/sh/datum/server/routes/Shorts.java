package sh.datum.server.routes;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.impl.RouterImpl;

public class Shorts extends RouterImpl {

    public Shorts(Vertx vertx) {
        super(vertx);
        handleRoot();
    }

    private void handleRoot() {
        this.get("/api/:security")
                .respond(ctx -> Future.succeededFuture(new JsonObject().put("message",
                        String.format("Welcome to Vert.x! Hope you have a great future trading %s on %s",
                                ctx.pathParam("security"), ctx.queryParam("exchange").get(0)))));
    }

}
