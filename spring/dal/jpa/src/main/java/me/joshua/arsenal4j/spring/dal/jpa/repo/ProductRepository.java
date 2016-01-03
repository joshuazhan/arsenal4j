package me.joshua.arsenal4j.spring.dal.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.joshua.arsenal4j.spring.dal.jpa.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

	public List<Product> findByNameLikeAndDescriptionLike(String name, String description);

	public Product findOneByImagesFront(String front);

	public List<Product> findByIdIn(List<Long> ids);

	public List<Product> findByIdInAndName(List<Long> ids, String name);

	public Product findOneByName(String name);
}
