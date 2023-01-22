package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.request.ClientRequest;
import jsvariedades.sales.dto.response.ClientResponse;
import jsvariedades.sales.enums.ClientStatus;
import jsvariedades.sales.model.ClientModel;

public final class ClienteMapper {

    public static ClientResponse clienteModelToClientResponse(ClientModel clientModel){
        return new ClientResponse()
                .setName(clientModel.getName())
                .setEmail(clientModel.getEmail())
                .setDocument(clientModel.getDocument())
                .setPhone(clientModel.getPhone())
                .setClientStatus(clientModel.getStatus());
    }

    public static ClientRequest clienteModelToClienteRequest(ClientModel clientModel){
        return new ClientRequest()
                .setName(clientModel.getName())
                .setEmail(clientModel.getEmail())
                .setDocument(clientModel.getDocument())
                .setPhone(clientModel.getPhone());
    }

    public static ClientModel clienteRequestToClienteModel(ClientRequest clientRequest){
        return new ClientModel()
                .setName(clientRequest.getName())
                .setEmail(clientRequest.getEmail())
                .setDocument(clientRequest.getDocument())
                .setPhone(clientRequest.getPhone())
                .setStatus(ClientStatus.ACTIVE);
    }
}
