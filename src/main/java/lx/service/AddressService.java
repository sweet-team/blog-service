package lx.service;

import lx.domain.Address;
import lx.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getParentAddresses(){
        List<Address> addressByPidIsNull = this.addressRepository.findAddressByPidIsNull();
        return addressByPidIsNull;
    }

    public List<Address> getAddressesByPId(Long pid){
        List<Address> addressByPid = this.addressRepository.findAddressByPid(pid);
        return addressByPid;
    }
    public Address getAddressById(Long id){
        Optional<Address> byId = this.addressRepository.findById(id);
        if(!byId.isPresent()){
            return null;
        }
        return byId.get();
    }

}
