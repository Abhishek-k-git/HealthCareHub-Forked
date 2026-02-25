package nimblix.in.HealthCareHub.model;

import jakarta.persistence.*;
import lombok.*;
import nimblix.in.HealthCareHub.constants.HealthCareConstants;
import nimblix.in.HealthCareHub.utility.HealthCareUtil;

@Entity
@Table(name = "lab_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LabOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "test_name")
    private String testName;

    @Column(name="status", nullable=false) // {PENDING, COMPLETED}
    private String status;

    @Column(name = "result")
    private String result;

    @Column(name = "created_time")
    private String createdTime;

    @Column(name = "updated_time")
    private String updatedTime;

    @PrePersist
    protected void onCreate(){
        String now = HealthCareUtil.changeCurrentTimeToLocalDateFromGmtToISTInString();
        createdTime = now;
        updatedTime = now;
        validateStatus();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedTime = HealthCareUtil.changeCurrentTimeToLocalDateFromGmtToISTInString();
        validateStatus();
    }

    private void validateStatus() {
        if (status == null ||
                (!HealthCareConstants.PENDING.equals(status) &&
                        !HealthCareConstants.COMPLETED.equals(status))) {
            throw new IllegalArgumentException("Invalid lab order status");
        }
    }
}
