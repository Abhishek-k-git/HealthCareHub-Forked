package nimblix.in.HealthCareHub.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import nimblix.in.HealthCareHub.model.LabOrderStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabOrderRequest {
    @NotNull(message = "Status is required")
    private LabOrderStatus status;
}