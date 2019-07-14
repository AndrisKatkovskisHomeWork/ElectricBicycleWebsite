//package com.bicycles.bicycles.calendar;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//
//
//// JpaRepository
//
//public interface DateCreatingRepository extends CrudRepository<DateCreating, String> {
//
//    List<DateCreating> findAllByReservationDate(Date reservationDate);
//
//    List<DateCreating> findAllByReservationTimeBetween(
//            Date reservationTimeStart,
//            Date reservationTimeEnd);
//
//    @Query("select a from DateCreating a where a.creationDateTime <= :creationDateTime")
//    List<DateCreating> findAllWithCreationDateTimeBefore(
//            @Param("creationDateTime") Date creationDateTime);
//
//}