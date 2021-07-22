package support.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import support.model.enums.Priority;
import support.model.enums.Severity;
import support.model.enums.State;

@AllArgsConstructor
@Getter
public class TicketCreationRequest implements TicketRequest{

    private final String name;
    private final long productId;
    private final String description;
    private final Severity severity;
    private final String creator;
    private final String clientId;
    private final State state;
    private final Priority priority;
}
