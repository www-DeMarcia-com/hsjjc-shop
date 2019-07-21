package com.hsjjc.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hsjjc.pojo.CategoriesSum;
import com.hsjjc.pojo.TbCategory;
import com.hsjjc.pojo.TbUser;
public interface CategoryJPA extends JpaRepository<TbCategory,Long>{
//	@Cacheable(value="userbyphone")
//	List<TbCategory> findByPhone(String phone);
	
//	@Cacheable(value="userbyname")
	List<TbCategory> findByNameLike(String name,Sort sort);

	List<TbCategory> findByName(String name);
	
	@Query(value = "select c.*,k.num from tb_category c left join ( select p.cid ,count(p.name) num from tb_product p group by p.cid ) k on c.id=k.cid order by c.sort_order,c.id", nativeQuery = true)
	List<CategoriesSum> findAllAndNum();
	
//	@Cacheable(value="userbynameandpwd")
//	TbUser findByUsernameAndPassword(String username, String password);
	
   /* //查询大于20岁的用户
    @Query(value = "select * from t_user where t_age > ?1",nativeQuery = true)
    public List<UserEntity> nativeQuery(int age);

    //根据用户名、密码删除一条数据
    @Modifying
    @Query(value = "delete from t_user where t_name = ?1 and t_pwd = ?2",nativeQuery = true)
    public void deleteQuery(String name,String pwd);*/
}
