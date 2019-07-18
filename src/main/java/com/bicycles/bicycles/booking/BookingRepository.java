package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.accessories.Accessory;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

}