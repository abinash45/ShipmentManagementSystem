package com.shipment.service;

import com.shipment.entity.ShipmentEntity;
import com.shipment.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public ShipmentEntity createShipment(ShipmentEntity shipment) {
        return shipmentRepository.save(shipment);
    }

    public List<ShipmentEntity> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public ShipmentEntity getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found with id: " + id));
    }

    public ShipmentEntity updateShipment(Long id, ShipmentEntity shipment) {

        ShipmentEntity existingShipment = getShipmentById(id);

        existingShipment.setTrackingNumber(shipment.getTrackingNumber());
        existingShipment.setCustomerName(shipment.getCustomerName());
        existingShipment.setOrigin(shipment.getOrigin());
        existingShipment.setDestination(shipment.getDestination());
        existingShipment.setStatus(shipment.getStatus());

        return shipmentRepository.save(existingShipment);
    }

    public void deleteShipment(Long id) {

        ShipmentEntity existingShipment = getShipmentById(id);

        shipmentRepository.delete(existingShipment);
    }
}