package com.andreamaccan.backportfolio.repository;

import com.andreamaccan.backportfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
//    @PersistenceContext
//    EntityManager entityManager;
//        
//    public User getUserByCredentials(User user){
//        String emailQuery = "FROM User WHERE email = :email";
//        List<User> emailList = entityManager.createQuery(emailQuery)
//                .setParameter("email", user.getEmail())
//                .getemailList();
//
//        if (emailList.isEmpty()) {
//            return null;
//        }
//        
//        String passwordQuery = "FROM User WHERE password = :password";
//        List<User> passwordList = entityManager.createQuery(passwordQuery)
//                .setParameter("password", user.getPassword())
//                .getpasswordList();
//
//        if (passwordList.isEmpty()) {
//            return null;
//        }
//        
//        return null;
//    }
}
