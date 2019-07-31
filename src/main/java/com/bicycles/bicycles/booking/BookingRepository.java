package com.bicycles.bicycles.booking;

import com.bicycles.bicycles.bicycle.Bicycle;
import com.bicycles.bicycles.calendarDay.Day;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookingRepository extends PagingAndSortingRepository<Booking, Integer> {
    List<Booking> findByDayAndBicycle(Day d, Bicycle b);
}