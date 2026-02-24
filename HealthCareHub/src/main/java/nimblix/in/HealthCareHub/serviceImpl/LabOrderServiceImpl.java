package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.LabOrder;
import nimblix.in.HealthCareHub.model.LabOrderStatus;
import nimblix.in.HealthCareHub.repository.LabOrderRepository;
import nimblix.in.HealthCareHub.response.LabOrderResponse;
import nimblix.in.HealthCareHub.service.LabOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabOrderServiceImpl implements LabOrderService {

    @Autowired
    private LabOrderRepository labOrderRepository;

    @Override
    public LabOrderResponse updateLabOrderStatus(Long id, LabOrderStatus status) {
        LabOrder labOrder = labOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lab Order not found with id: " + id));
        labOrder.setStatus(status);
        LabOrder newLabOrder = labOrderRepository.save(labOrder);
        return this.toOrderResponse(newLabOrder);
    }

    @Override
    public LabOrderResponse toOrderResponse(LabOrder order) {
        return LabOrderResponse.builder()
                .id(order.getId())
                .patientId(order.getPatient().getId())
                .doctorId(order.getDoctor().getId())
                .patientName(order.getPatient().getName())
                .doctorName(order.getDoctor().getName())
                .testName(order.getTestName())
                .status(order.getStatus())
                .result(order.getResult())
                .createdTime(order.getCreatedTime())
                .updatedTime(order.getUpdatedTime())
                .build();
    }

}

