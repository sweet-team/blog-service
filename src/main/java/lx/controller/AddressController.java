package lx.controller;

import lx.domain.Address;
import lx.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping("/address/single/{id}")
    public ResponseEntity<Address> getAddressById(Long id){
        Address addressById = addressService.getAddressById(id);
        return ResponseEntity.ok(addressById);
    }
    @GetMapping("/address/children/{pid}")
    public ResponseEntity<List<Address>> getAddressByPid(Long pid){
        List<Address> addressesByPId = addressService.getAddressesByPId(pid);
        return ResponseEntity.ok(addressesByPId);
    }
    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddress(){
        List<Address> parentAddresses = addressService.getParentAddresses();
        return ResponseEntity.ok(parentAddresses);
    }
}
