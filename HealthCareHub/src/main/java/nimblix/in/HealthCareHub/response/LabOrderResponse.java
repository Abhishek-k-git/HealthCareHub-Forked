package nimblix.in.HealthCareHub.response;

import lombok.*;
import nimblix.in.HealthCareHub.model.LabOrderStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabOrderResponse {
    private Long id;
    private Long patientId;
    private Long doctorId;
    private String patientName;
    private String doctorName;

    private String testName;
    private LabOrderStatus status;
    private String result;

    private String createdTime;
    private String updatedTime;
}
