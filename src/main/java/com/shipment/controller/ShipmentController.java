package com.shipment.controller;

import com.shipment.entity.ShipmentEntity;
import com.shipment.service.ShipmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ShipmentEntity createShipment(
            @RequestBody ShipmentEntity shipment) {

        return shipmentService.createShipment(shipment);
    }

    @GetMapping
    public List<ShipmentEntity> getAllShipments() {

        return shipmentService.getAllShipments();
    }

    @GetMapping("/{id}")
    public ShipmentEntity getShipmentById(
            @PathVariable Long id) {

        return shipmentService.getShipmentById(id);
    }

    @PutMapping("/{id}")
    public ShipmentEntity updateShipment(
            @PathVariable Long id,
            @RequestBody ShipmentEntity shipment) {

        return shipmentService.updateShipment(id, shipment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShipment(
            @PathVariable Long id) {

        shipmentService.deleteShipment(id);

        return ResponseEntity.noContent().build();
    }
}