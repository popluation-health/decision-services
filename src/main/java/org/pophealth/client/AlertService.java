package org.pophealth.client;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.pophealth.model.Alert;

@RegisterRestClient
public interface AlertService {

    @POST
    @Path("/alert")
    @Consumes(MediaType.APPLICATION_JSON)
    void issueAlert(Alert alert);



}
