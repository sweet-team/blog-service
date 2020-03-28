package lx.repository;

import lx.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
    List<Address> findAddressByPidIsNull();
    List<Address> findAddressByPid(Long pid);
}
