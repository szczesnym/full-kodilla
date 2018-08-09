package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query
    List<Company> firstThreeCharactersAreEqualParam(@Param("COMPANY_NAME_START") String paramCompanyName);

/*    @Query
    List<Company> withNamesContainsParam(@Param("COMPANY_NAME_PARAM") String companyNameParam);

Do dyskusji na telco

*/
    List<Company> findByNameContaining(String name);
}
