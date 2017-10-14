package com.syolab.demos.empmgr.dao.spring;

import com.syolab.demos.empmgr.dao.domain.Employee;
import com.syolab.demos.empmgr.dao.domain.EmployeeStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.repository.PagingAndSortingRepository;
import java.util.List;
import reactor.core.publisher.Flux;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, String>,
        CustomizedEmployeeRepository {
    //List all employees by their status
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    // Paginate over a full-text search result
    Page<Employee> findAllBy(TextCriteria criteria, Pageable pageable);
    // {'geoNear' : 'location', 'near' : [x, y] }
    Flux<GeoResult<Employee>> findByLocationNear(Point location);
}