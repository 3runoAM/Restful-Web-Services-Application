package com.in28minutes.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        return this.applyFiltering("SomeBeanFilter", someBean, "field1", "field2");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){
        List<SomeBean> someBeanList = List.of(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"),
                new SomeBean("value13", "value23", "value33"));

        return this.applyFiltering("SomeBeanFilter", someBeanList, "field2", "field3");
    }

    public MappingJacksonValue applyFiltering(String filterName, Object object, String... fields){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
