package Test.demo.Explore;

import Test.demo.Skills.*;

import java.util.*;
import java.util.function.Predicate;
import javax.persistence.criteria.*;

public class exploreFilter implements
    org.springframework.data.jpa.domain.Specification<Skills>{
        String userQuery;
        public void SkillsDatatableFilter(String queryString) {
            this.userQuery = queryString;
        }
        @Override
        public Predicate toPredicate(Root<Skills> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
            ArrayList<Predicate> predicates = new ArrayList<>();
            if (userQuery != null && userQuery != "") {
                predicates.add(criteriaBuilder.like(root.get("Name"), '%' + userQuery + '%'));
                predicates.add(criteriaBuilder.like(root.get("Location"), '%' + userQuery + '%'));
                predicates.add(criteriaBuilder.like(root.get("Price"), '%' + userQuery + '%'));
                predicates.add(criteriaBuilder.like(root.get("User ID"), '%' + userQuery + '%'));

            }
            return (! predicates.isEmpty() ? criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()])) : null);
        }
    }
